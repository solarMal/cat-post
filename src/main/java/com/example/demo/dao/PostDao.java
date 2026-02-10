package com.example.demo.dao;

import com.example.demo.model.CatPost;
import com.example.demo.model.CatUser;

import java.util.Collection;

public interface PostDao {
    Collection<CatPost> findPostsByUser(CatUser user);
}
