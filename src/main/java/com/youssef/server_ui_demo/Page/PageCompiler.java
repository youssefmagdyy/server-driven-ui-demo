package com.youssef.server_ui_demo.Page;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PageCompiler {

    @Cacheable("pageDefs")
    public PageDefinition compileRawPage(RawPage rawPage)
    {
        List<ComponentDefinition> compiledComponents = rawPage.rawComponents().stream().map(this::compileRawComponent).toList();
        return new PageDefinition(rawPage.name(),compiledComponents);
    }

    public ComponentDefinition compileRawComponent(RawComponent rawComp) {
        Map<String, Object> staticProps = new HashMap<>();
        Map<String, String> dynamicProps = new HashMap<>();
        for (var entry : rawComp.props().entrySet()) {

            if (entry.getKey().equals("attr")) {
                dynamicProps.put(entry.getKey(), (String) entry.getValue());
            } else {
                staticProps.put(entry.getKey(), entry.getValue());
            }
        }

        List<ComponentDefinition> childrenCompDefs= rawComp.children().stream().map(this::compileRawComponent).toList();


        return new ComponentDefinition(rawComp.name(), staticProps, dynamicProps,childrenCompDefs);

    }
}
