package spring.boot.parser.service;

import spring.boot.parser.model.User;

public interface UserService extends GeneralService<User> {
    User getByUserId(String externalUserId);
}
