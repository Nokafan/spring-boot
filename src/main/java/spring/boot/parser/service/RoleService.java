package spring.boot.parser.service;

import java.util.List;
import spring.boot.parser.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getRoleByRoleName(String roleName);

    List<Role> getAll();
}
