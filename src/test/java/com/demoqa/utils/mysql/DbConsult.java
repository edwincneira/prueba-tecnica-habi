package com.demoqa.utils.mysql;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

public class DbConsult {
    private JdbcTemplate jdbc;
    private static final String USER = System.getenv("USER_DB_DEMOQA");
    private static final String PASSWORD = System.getenv("PASSWORD_DB_DEMOQA");
    private static final String HOST = System.getenv("HOST_DB_DEMOQA");

    public DbConsult() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(HOST);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        jdbc = new JdbcTemplate(dataSource);
    }

    public Object readValue(String query) {
        return jdbc.queryForObject(query, Object.class);
    }

    public Map<String, Object> readRow(String query) {
        return jdbc.queryForMap(query);
    }

    public List<Map<String, Object>> readRows(String query) {
        return jdbc.queryForList(query);
    }
}
