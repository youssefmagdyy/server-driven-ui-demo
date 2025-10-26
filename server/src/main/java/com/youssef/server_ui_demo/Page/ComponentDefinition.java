package com.youssef.server_ui_demo.Page;

import java.util.Map;

public record ComponentDefinition(String name, Map<String, Object> staticProps, Map<String, String> dynamicProps) {
}
