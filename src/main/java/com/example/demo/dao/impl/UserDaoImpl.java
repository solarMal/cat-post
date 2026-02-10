package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.model.CatUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
@Slf4j
public class UserDaoImpl implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<CatUser> findUserById(long id) {
        //выполняем запрос к базе данных
        SqlRowSet userRows = jdbcTemplate.queryForRowSet("select * from cat_user where id = ?", id);

        if (userRows.next()) {
            log.info("Найден пользователь: {} {} {}", userRows.getLong("id")
                    , userRows.getString("user_name"), userRows.getString("nick_name"));

            CatUser user = new CatUser(
                    userRows.getLong("id"),
                    userRows.getString("user_name"),
                    userRows.getString("nick_name")
            );

            return Optional.of(user);
        } else {
            log.info("Пользователь с идентификатором {} не найден", id);
            return Optional.empty();
        }
    }


}
