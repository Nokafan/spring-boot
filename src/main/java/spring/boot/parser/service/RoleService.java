package spring.boot.parser.service;

import spring.boot.parser.model.Role;

public interface RoleService extends GeneralService<Role> {
    Role getRoleByRoleName(String roleName);
}
