package com.example.demo.controller;

import com.example.demo.model.CatPost;
import com.example.demo.service.CatPostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public CatPost createPost(@RequestBody CatPost catPost) {
        return postService.createPost(catPost);
    }

    @PutMapping
    public CatPost updatePost(@RequestBody CatPost catPost) {
        return postService.updatePost(catPost);
    }

    @GetMapping("/{id}")
    public CatPost getPostById(@PathVariable long id) {
        return postService.getPostById(id);
    }

    @GetMapping
    public List<CatPost> getAllPosts() {
        return postService.getAllPosts();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePostById(@PathVariable long id) {
        postService.deletePostById(id);
    }
}
