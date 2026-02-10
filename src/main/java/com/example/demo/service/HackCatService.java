package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class HackCatService {

    public static final String JDBC_URL="jdbc:postgresql://localhost:5432/catandpost";
    public static final String JDBC_USERNAME="catuser";
    public static final String JDBC_DRIVER="org.postgresql.Driver";

    public void tryPassword(String jdbcPassword) {
        DriverManagerDataSource dataSourceConst = new DriverManagerDataSource();
        dataSourceConst.setDriverClassName(JDBC_DRIVER);
        dataSourceConst.setUrl(JDBC_URL);
        dataSourceConst.setUsername(JDBC_USERNAME);
        dataSourceConst.setPassword(jdbcPassword);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceConst);
        jdbcTemplate.execute("SELECT 1;");
        // проверьте подключение с паролем и параметрами БД
    }

    public Optional<String> doHackNow(){
        List<String> catWordList = Arrays.asList("meow", "purr", "purrrrrr", "zzz");
        for (String cat : catWordList) {
            try {
                tryPassword(cat);
                return Optional.of(cat);
            } catch (Exception e) {
                log.info("пароль {} не подходит", catWordList);
            }
        }
        return Optional.empty();
    }
}
