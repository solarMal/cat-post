package com.example.demo.service;

import com.example.demo.exception.ValidateException;
import com.example.demo.model.CatUser;
import com.example.demo.storage.catuser.CatUserStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CatUserService {
    CatUserStorage userStorage;

    @Autowired
    public CatUserService(CatUserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public CatUser createUser(CatUser catUser) {
        validateUser(catUser);
        return userStorage.createUser(catUser);
    }

    public CatUser updateUser(CatUser catUser) {
        validateUser(catUser);
        return userStorage.updateUser(catUser);
    }

    public List<CatUser> getAllUsers() {
        return userStorage.getAllUsers();
    }

    public CatUser getUserById(long id) {
        return userStorage.getUserById(id);
    }

    public void deleteUserById(long id) {
        userStorage.deleteUserById(id);
    }

    private void validateUser(CatUser user) {
        if (user == null) {
            throw new ValidateException("Пользователь не может быть null");
        }

        if (user.getId() < 0) {
            throw new ValidateException("id не может быть меньше 0");
        }

        if (user.getUserName() == null || user.getUserName().isBlank()) {
            throw new ValidateException("username не может быть пустым");
        }

        if (user.getNickName() == null || user.getNickName().isBlank()) {
            throw new ValidateException("nickname не может быть пустым");
        }
    }
}
