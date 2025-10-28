package com.youssef.server_ui_demo.Page;

import com.youssef.server_ui_demo.Attribute.Attribute;
import com.youssef.server_ui_demo.Attribute.AttributeRepo;
import com.youssef.server_ui_demo.Attribute.AttributeType;
import com.youssef.server_ui_demo.QueryResolver.QueryResolver;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.spi.QueryEngine;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PageRenderer {

    private final QueryResolver queryResolver;
    private final AttributeRepo attributeRepo;

    @Cacheable("pages")
    public Page renderPage(PageDefinition def)
    {
        List<Component> components = def.components().stream().map(this::resolveComponentDef).toList();
        return new Page(def.name(), components);
    }

    public Component resolveComponentDef(ComponentDefinition compDef)
    {
        Map<String, Object> resolvedProps = new HashMap<>(compDef.staticProps());

        for(var entry: compDef.dynamicProps().entrySet())
        {
               Attribute attr = attributeRepo.findByName(entry.getValue()).orElse(null);
               if(attr != null)
               {
                   switch (attr.getType())
                   {
                       case STRING -> resolvedProps.put("text",attr.getValue());
                       case SQL -> {
                           Object result = queryResolver.runQuery(attr.getValue());
                           resolvedProps.put("data",result);
                       }
                   }

               }
        }

        List<Component> childrenComps= compDef.children().stream().map(this::resolveComponentDef).toList();

        return new Component(compDef.name(), resolvedProps,childrenComps);
    }
}
