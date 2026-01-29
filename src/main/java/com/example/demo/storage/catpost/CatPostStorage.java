package com.example.demo.storage.catpost;

import com.example.demo.model.CatPost;

import java.util.List;

public interface CatPostStorage {
    CatPost createPost(CatPost catPost);
    CatPost updatePost(CatPost catPost);
    CatPost getPostById(long id);
    List<CatPost> getAllPosts();
    void deletePostById(long id);
}
