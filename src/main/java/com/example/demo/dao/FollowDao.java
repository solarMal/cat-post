package com.example.demo.dao;

import com.example.demo.model.CatPost;

import java.util.Collection;
import java.util.List;

public interface FollowDao {
    List<CatPost> getFollowFeed(long id, int max);
}
