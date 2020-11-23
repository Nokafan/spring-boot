package com.gmail.stepura.volodymyr.service;

import com.gmail.stepura.volodymyr.model.User;
import java.util.List;
import java.util.Set;

public interface UserService {
    User save(User user);

    List<User> saveAll(Set<User> users);

    User getById(Long id);

    User getByUserId(String string);

    List<User> getAll();
}
