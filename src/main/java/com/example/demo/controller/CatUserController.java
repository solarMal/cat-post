package com.example.demo.controller;

import com.example.demo.model.CatUser;
import com.example.demo.service.CatUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/users")
public class CatUserController {
    CatUserService userService;

    @Autowired
    public CatUserController(CatUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public Optional<CatUser> getUser(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public CatUser createUser(@RequestBody CatUser catUser) {
        return userService.createUser(catUser);
    }

//    @PutMapping
//    public CatUser updateUser(@RequestBody CatUser catUser) {
//        return userService.updateUser(catUser);
//    }
//
//    @GetMapping
//    public List<CatUser> getAllUsers() {
//        return userService.getAllUsers();
//    }
//
//    @GetMapping("/{id}")
//    public CatUser getUserById(@PathVariable long id) {
//        return userService.getUserById(id);
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteUserById(@PathVariable long id) {
//        userService.deleteUserById(id);
//    }
}
