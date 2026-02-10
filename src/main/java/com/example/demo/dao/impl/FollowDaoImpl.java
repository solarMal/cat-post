package com.example.demo.dao.impl;

import com.example.demo.dao.FollowDao;
import com.example.demo.dao.PostDao;
import com.example.demo.dao.UserDao;
import com.example.demo.model.CatPost;
import com.example.demo.model.CatUser;
import com.example.demo.model.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class FollowDaoImpl implements FollowDao {

    private final JdbcTemplate jdbcTemplate;
    private final UserDao userDao;
    private final PostDao postDao;

    @Autowired
    public FollowDaoImpl(JdbcTemplate jdbcTemplate, UserDao userDao, PostDao postDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
        this.postDao = postDao;
    }

    @Override
    public List<CatPost> getFollowFeed(long userid, int max) {
        // получаем все подписки пользователя
        String sql = "select * from cat_follow where subscriber_id = ?"; // напишите подходящий SQL-запрос

        List<Follow> follows = jdbcTemplate.query(sql, (rs, rowNum) -> makeFollow(rs), userid);

        Set<CatUser> authors = new HashSet<>();
        for (Follow follow : follows) {
            userDao.findUserById(follow.getAuthorId()).ifPresent(authors::add);
        }

        if (authors.isEmpty()) {
            return Collections.emptyList();
        }

        List<CatPost> posts = new ArrayList<>();
        for (CatUser user : authors) {
            posts.addAll(postDao.findPostsByUser(user));
        }

        return posts.stream()
                .sorted(Comparator.comparing(CatPost::getCreationDate).reversed())
                .limit(max)
                .toList();
    }

    private Follow makeFollow(ResultSet rs) throws SQLException {
        // реализуйте маппинг результата запроса в объект класса Follow
        long id = rs.getLong("id");
        long authorId = rs.getLong("author_id");
        long subscriberId = rs.getLong("subscriber_id");

        return new Follow(id, authorId, subscriberId);
    }
}
