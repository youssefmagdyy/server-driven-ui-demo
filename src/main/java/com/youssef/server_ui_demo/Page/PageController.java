package com.youssef.server_ui_demo.Page;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page")
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;
    private final PageRenderer pageRenderer;

    @GetMapping("/{name}")
    public ResponseEntity<?> getPage(@PathVariable String name)
    {
        try {
            PageDefinition pageDef = pageService.getPageDefinition(name);
                Page page = pageRenderer.renderPage(pageDef);
                return ResponseEntity.ok(page);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
