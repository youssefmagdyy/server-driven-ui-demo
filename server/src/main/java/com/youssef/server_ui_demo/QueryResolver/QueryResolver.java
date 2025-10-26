package com.youssef.server_ui_demo.QueryResolver;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class QueryResolver {

    private final JdbcTemplate jdbc;

    public List<Map<String, Object>> runQuery(String sql) {
        return jdbc.queryForList(sql);
    }
}
