package com.example.demo.service;

import com.example.demo.dao.PostDao;
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

import java.util.Collection;
import java.util.List;

@Service
@Slf4j
public class CatPostService {
     CatUserService userService;
     PostDao postDao;

     @Autowired
    public CatPostService(CatUserService userService, PostDao postDao) {
        this.userService = userService;
        this.postDao = postDao;
    }

    public Collection<CatPost> findPostsByUser(long userId) {
         CatUser user = userService.findUserById(userId)
                 .orElseThrow(() -> new UserNotFoundException("пользователь с id " + userId + " не найден"));

         return postDao.findPostsByUser(user);
    }
}
