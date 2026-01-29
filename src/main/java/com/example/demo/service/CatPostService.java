package com.example.demo.service;

import com.example.demo.exception.PostNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.ValidateException;
import com.example.demo.model.CatPost;
import com.example.demo.model.CatUser;
import com.example.demo.storage.catpost.CatPostStorage;
import com.example.demo.storage.catuser.CatUserStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CatPostService {
     CatPostStorage postStorage;
     CatUserStorage userStorage;

     @Autowired
    public CatPostService(CatPostStorage catPostStorage, CatUserStorage catUserStorage) {
        this.postStorage = catPostStorage;
        this.userStorage = catUserStorage;
    }

    public CatPost createPost(CatPost catPost) {
         postValidate(catPost);
        CatUser user = userStorage.getUserById(catPost.getAuthorId());

        if (user == null) {
            throw new UserNotFoundException("user not found");
        }

        return postStorage.createPost(catPost);
    }

    public CatPost updatePost(CatPost catPost) {
         postValidate(catPost);

         CatPost post = postStorage.getPostById(catPost.getId());
         if (post == null) {
             throw new PostNotFoundException("Post with id " + catPost.getId() + " not found");
         }

         CatUser user = userStorage.getUserById(catPost.getAuthorId());
         if (user == null) {
             throw new UserNotFoundException("user not found");
         }

         if (user.getId() != post.getAuthorId()) {
             throw new ValidateException("only user with id " + post.getAuthorId() + " may update");
         }

         return postStorage.updatePost(catPost);
    }

    public CatPost getPostById(long id) {
         if (id <= 0) {
             throw new ValidateException("id must be positive");
         }
         return postStorage.getPostById(id);
    }

    public List<CatPost> getAllPosts() {
         return postStorage.getAllPosts();
    }

    public void deletePostById(long id) {
         postStorage.deletePostById(id);
    }

    private void postValidate(CatPost catPost) {
        if (catPost == null) {
            throw new ValidateException("post not exist");
        }

        if (catPost.getId() < 0) {
            throw new ValidateException("post id can't be less 0");
        }

        if (catPost.getAuthorId() <= 0) {
            throw new ValidateException("authorId must be positive");
        }

        if (catPost.getPhotoUrl() == null || catPost.getPhotoUrl().isBlank()) {
            throw new ValidateException("photo not found");
        }
    }
}
