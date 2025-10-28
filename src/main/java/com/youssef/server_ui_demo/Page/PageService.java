package com.youssef.server_ui_demo.Page;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PageService {

    private final PageCompiler compiler;

    private final Map<String, RawPage> rawPages = Map.of(
            "home", new RawPage("home", List.of(
                    new RawComponent("Navbar",
                            Map.of(),
                            List.of(new RawComponent("Navlink",Map.of("label","Home","url","/"),List.of()),
                                    new RawComponent("Navlink",Map.of("label","Products","url","/products"),List.of()))
                    ),
                    new RawComponent("Header",
                            Map.of("title", "Welcome!", "subtitle", "This is a demo for server side rendering"),
                            List.of()
                    ),
                    new RawComponent("Banner",
                            Map.of("attr", "bannerTextAttr"),
                            List.of()
                    ),
                    new RawComponent("Grid",
                            Map.of("attr", "featuredProductsSQL"),
                            List.of()
                    )
            ))
            ,"products", new RawPage("products", List.of(
                    new RawComponent("Navbar",
                            Map.of(),
                            List.of(new RawComponent("Navlink",Map.of("label","Home","url","/"),List.of()),
                                    new RawComponent("Navlink",Map.of("label","Products","url","/products"),List.of()))
                    ),
                    new RawComponent("Header",
                            Map.of("title", "Products"),
                            List.of()
                    ),
                    new RawComponent("Grid",
                            Map.of("attr", "productsSQL"),
                            List.of()
                    )
            ))

    );


    public PageService(PageCompiler compiler) {
        this.compiler = compiler;
        RawPage rawPage = rawPages.get("home");
        compiler.compileRawPage(rawPage);
    }

    public PageDefinition getPageDefinition(String name)
    {
            RawPage rawPage = rawPages.get(name);
            if(rawPage == null)
                throw new IllegalArgumentException("Page not found");
            return compiler.compileRawPage(rawPage);
    }

}

