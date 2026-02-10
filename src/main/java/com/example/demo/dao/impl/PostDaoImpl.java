package com.example.demo.dao.impl;

import com.example.demo.dao.PostDao;
import com.example.demo.model.CatPost;
import com.example.demo.model.CatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;

@Component
public class PostDaoImpl implements PostDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<CatPost> findPostsByUser(CatUser user) {
        //метод принимает в виде аргумента строку запроса, преобразователь и аргумент id пользователя
        String sql = "select * from cat_post where author_id = ? order by creation_date desc";

        return jdbcTemplate.query(sql, (rs, rowNum) -> makePost(user, rs), user.getId());
    }

    private CatPost makePost(CatUser user, ResultSet rs) throws SQLException {
        //используем конструктор, методы ResultSet
        //и готовое значение CatUser
        Long id = rs.getLong("id");
        String description = rs.getString("description");
        String photoUrl = rs.getString("photo_url");

        LocalDate creationDate = rs.getDate("creation_date").toLocalDate();

        return new CatPost(id, user, creationDate, photoUrl, description);
    }
}
