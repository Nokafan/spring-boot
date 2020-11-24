package spring.boot.parser.service;

import java.util.List;
import java.util.Set;
import spring.boot.parser.model.User;

public interface UserService {
    User save(User user);

    List<User> saveAll(Set<User> users);

    User getById(Long id);

    User getByUserId(String externalUserId);

    List<User> getAll();
}
