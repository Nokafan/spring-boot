package spring.boot.parser.controllers;

import java.util.HashSet;
import java.util.Set;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.parser.model.Role;
import spring.boot.parser.model.User;
import spring.boot.parser.service.RoleService;
import spring.boot.parser.service.UserService;

@Log4j
@RestController
public class InjectConroller {
    public static final String PASSWORD = "12345";
    public static final String USER_ADMIN = "admin";
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public InjectConroller(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/inject")
    public void injectAdmin() {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleByRoleName(ROLE_ADMIN));
        roles.add(roleService.getRoleByRoleName(ROLE_USER));
        User admin = User.builder()
                .userId(USER_ADMIN)
                .profileName(USER_ADMIN)
                .password(PASSWORD)
                .role(roles)
                .build();
        userService.save(admin);
        log.info("Custom user 'admin' has been saved successfully");
    }
}
