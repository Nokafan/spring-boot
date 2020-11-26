package spring.boot.parser.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.parser.model.Role;
import spring.boot.parser.repository.RoleRepository;
import spring.boot.parser.service.RoleService;

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
    public List<Role> saveAll(Iterable<Role> roles) {
        return roleRepository.saveAll(roles);
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).orElseThrow();
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
