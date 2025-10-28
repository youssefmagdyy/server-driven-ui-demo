package com.youssef.server_ui_demo.Page;

import java.util.List;
import java.util.Map;

public record RawComponent(String name, Map<String, Object> props, List<RawComponent> children
) {}
