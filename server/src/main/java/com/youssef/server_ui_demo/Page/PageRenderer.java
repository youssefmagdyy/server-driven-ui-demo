package com.youssef.server_ui_demo.Page;

import com.youssef.server_ui_demo.Attribute.Attribute;
import com.youssef.server_ui_demo.Attribute.AttributeRepo;
import com.youssef.server_ui_demo.Attribute.AttributeType;
import com.youssef.server_ui_demo.QueryResolver.QueryResolver;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.spi.QueryEngine;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PageRenderer {

    private final QueryResolver queryResolver;
    private final AttributeRepo attributeRepo;

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
            if(entry.getKey().equals("attr"))
            {
               Attribute attr = attributeRepo.findByName(entry.getValue()).orElse(null);
               if(attr != null && attr.getType() == AttributeType.STRING)
               {
                   resolvedProps.put("text",attr.getValue());
               }
            }
            else if(entry.getKey().equals("query"))
            {
                Object result = queryResolver.runQuery(entry.getValue());
                resolvedProps.put("data",result);
            }
        }
        return new Component(compDef.name(), resolvedProps);
    }
}
