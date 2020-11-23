package com.gmail.stepura.volodymyr.config;

import com.gmail.stepura.volodymyr.model.Role;
import com.gmail.stepura.volodymyr.model.User;
import com.gmail.stepura.volodymyr.service.CsvToBeanParserService;
import com.gmail.stepura.volodymyr.service.FileReaderService;
import com.gmail.stepura.volodymyr.service.RoleService;
import com.gmail.stepura.volodymyr.service.UserService;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class EventListenerBean implements ApplicationListener<ApplicationStartedEvent> {
    public static final String PASSWORD = "12345";
    private final CsvToBeanParserService parserService;
    private final FileReaderService fileReaderService;
    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public EventListenerBean(CsvToBeanParserService parserService,
                             FileReaderService fileReaderService,
                             RoleService roleService, UserService userService) {
        this.parserService = parserService;
        this.fileReaderService = fileReaderService;
        this.roleService = roleService;
        this.userService = userService;
    }

    public void onApplicationEvent(ApplicationStartedEvent arc) {
        Role adminRole = roleService.save(Role.of("ADMIN"));
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        User admin = User.builder()
                .userId("admin")
                .profileName("admin")
                .password(PASSWORD)
                .role(roles)
                .build();
        userService.save(admin);

        try {
            parserService.saveBeans(fileReaderService.getRows());
        } catch (IOException e) {
            log.error("Error reading file", e);
        }
    }
}
