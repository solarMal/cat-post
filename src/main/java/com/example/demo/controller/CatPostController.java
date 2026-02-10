package com.example.demo.controller;

import com.example.demo.model.CatPost;
import com.example.demo.service.CatPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/posts")
public class CatPostController {
    CatPostService postService;

    @Autowired
    public CatPostController(CatPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/user/{id}")
    public Collection<CatPost> findAll(@PathVariable long id) {
        return postService.findPostsByUser(id);
    }
}
