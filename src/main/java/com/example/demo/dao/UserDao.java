package com.example.demo.dao;

import com.example.demo.model.CatUser;

import java.util.Optional;

public interface UserDao {
    Optional<CatUser> findUserById(long id);
}
