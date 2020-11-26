package spring.boot.parser.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.parser.model.User;
import spring.boot.parser.repository.UserRepository;
import spring.boot.parser.service.UserService;

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
    public List<User> saveAll(Iterable<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User getByUserId(String externalUserId) {
        return userRepository.findUserByUserId(externalUserId).orElseThrow();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
