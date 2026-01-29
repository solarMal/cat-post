package com.example.demo.storage.catuser;

import com.example.demo.model.CatUser;

import java.util.List;

public interface CatUserStorage {
    CatUser createUser(CatUser user);
    CatUser updateUser(CatUser user);
    List<CatUser> getAllUsers();
    CatUser getUserById(long id);
    void deleteUserById(long id);
}
