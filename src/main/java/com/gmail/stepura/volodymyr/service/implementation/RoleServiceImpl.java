package com.gmail.stepura.volodymyr.service.implementation;

import com.gmail.stepura.volodymyr.model.Role;
import com.gmail.stepura.volodymyr.repository.RoleRepository;
import com.gmail.stepura.volodymyr.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(Role.RoleName.valueOf(roleName));
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }
}
