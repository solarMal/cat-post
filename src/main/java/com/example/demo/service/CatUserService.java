package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.ValidateException;
import com.example.demo.model.CatUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CatUserService {
    private final UserDao userDao;

    @Autowired
    public CatUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<CatUser> findUserById(long id) {
        return userDao.findUserById(id);
    }

    public CatUser createUser(CatUser catUser) {
        validateUser(catUser);
        return userDao.createUser(catUser);
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
