package spring.boot.parser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.boot.parser.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findRoleByRoleName(Role.RoleName roleName);
}
