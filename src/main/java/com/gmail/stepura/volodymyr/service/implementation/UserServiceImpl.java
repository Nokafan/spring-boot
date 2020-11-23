package com.gmail.stepura.volodymyr.service.implementation;

import com.gmail.stepura.volodymyr.model.User;
import com.gmail.stepura.volodymyr.repository.UserRepository;
import com.gmail.stepura.volodymyr.service.UserService;
import java.util.List;
import java.util.Set;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> saveAll(Set<User> userSet) {
        return userRepository.saveAll(userSet);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User getByUserId(String string) {
        return userRepository.findUserByUserId(string).orElseThrow();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
