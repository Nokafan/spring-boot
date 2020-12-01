package spring.boot.parser.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import spring.boot.parser.model.User;

public interface UserService extends GeneralService<User> {
    User getByUserId(String externalUserId);

    List<User> findTopActiveUsers(Pageable pageable);
}
