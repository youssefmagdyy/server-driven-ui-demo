package com.youssef.server_ui_demo.Page;

import java.util.List;
import java.util.Map;

public record Component(String name, Map<String, Object> props, List<Component> children) {}
