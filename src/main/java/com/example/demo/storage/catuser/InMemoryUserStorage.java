package com.example.demo.storage.catuser;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.exception.ValidateException;
import com.example.demo.model.CatUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class InMemoryUserStorage implements CatUserStorage {
    Map<Long, CatUser> catUserMap = new HashMap<>();
    private long dynamicId = 1;

    @Override
    public CatUser createUser(CatUser user) {
        user.setId(dynamicId++);
        catUserMap.put(user.getId(), user);
        log.info("Пользователь {} успешно создан", user);
        return user;
    }

    @Override
    public CatUser updateUser(CatUser user) {
        if (user.getId() <= 0) {
            throw new ValidateException("id не может быть 0 или меньше");
        }

        if (!catUserMap.containsKey(user.getId())) {
            throw new UserNotFoundException("пользователь с id " + user.getId() + " не найден");
        }

        catUserMap.put(user.getId(), user);
        log.info("пользователь {} обновлён", user);
        return user;
    }

    @Override
    public List<CatUser> getAllUsers() {
        if (catUserMap.isEmpty()) {
            log.info("список пользователей пуст");
        }
        return new ArrayList<>(catUserMap.values());
    }

    @Override
    public CatUser getUserById(long id) {
        return Optional.ofNullable(catUserMap.get(id))
                .orElseThrow(() -> new UserNotFoundException("пользователь c id " + id + " не найден"));
    }

    @Override
    public void deleteUserById(long id) {
        if (id <= 0) {
            throw new ValidateException("id должен быть положительным");
        }

        if (!catUserMap.containsKey(id)) {
            throw new UserNotFoundException("пользователь с id " + id + " не найден");
        }

        catUserMap.remove(id);
        log.info("пользователь с id {} удалён", id);
    }
}
