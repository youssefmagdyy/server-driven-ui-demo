package com.youssef.server_ui_demo.Page;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PageService {

    private final Map<String, PageDefinition> compiledPages = new HashMap<>();

    public PageService(PageCompiler compiler) {
        List<RawPage> rawPages = List.of(
                new RawPage("home", List.of(
                        new RawComponent("Header", Map.of("title", "Welcome!", "subtitle", "This a demo for server side rendering")),
                        new RawComponent("Banner", Map.of("attr", "bannerTextAttr")),
                        new RawComponent("Grid", Map.of("query", "SELECT * FROM Products WHERE featured = TRUE"))
                ))
        );

        for(RawPage rawPage: rawPages)
        {
            compiledPages.put(rawPage.name(), compiler.compileRawPage(rawPage));
        }
    }

    public PageDefinition getPageDefinition(String name)
    {
        return compiledPages.get(name);
    }

}

