package com.example.demo.controller;

import com.example.demo.service.CatPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feed/friends")
public class PostFeedController {

    CatPostService postService;

    @Autowired
    public PostFeedController(CatPostService postService) {
        this.postService = postService;
    }



}
