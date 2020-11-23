package com.gmail.stepura.volodymyr.service;

import com.gmail.stepura.volodymyr.model.Role;
import java.util.List;

public interface RoleService {
    Role save(Role role);

    Role getRoleByRoleName(String roleName);

    List<Role> getAll();
}
