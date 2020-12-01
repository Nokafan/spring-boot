package spring.boot.parser.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.boot.parser.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserId(String userId);

    @Query("SELECT r.user FROM Review r group by r.user ORDER BY COUNT(r.user) DESC")
    List<User> findTopActiveUsers(Pageable pageable);
}
