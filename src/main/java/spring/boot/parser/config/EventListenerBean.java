package spring.boot.parser.config;

import java.util.HashSet;
import java.util.Set;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import spring.boot.parser.model.Role;
import spring.boot.parser.model.User;
import spring.boot.parser.service.CsvToBeanParserService;
import spring.boot.parser.service.RecordToDatabaseService;
import spring.boot.parser.service.RoleService;
import spring.boot.parser.service.UserService;

@Log4j
@Component
public class EventListenerBean implements ApplicationListener<ApplicationStartedEvent> {
    public static final String PASSWORD = "12345";
    public static final String USER_ADMIN = "admin";
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
    private final CsvToBeanParserService parserService;
    private final RecordToDatabaseService recordToDatabaseService;
    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public EventListenerBean(CsvToBeanParserService parserService,
                             RecordToDatabaseService recordToDatabaseService,
                             RoleService roleService, UserService userService) {
        this.parserService = parserService;
        this.recordToDatabaseService = recordToDatabaseService;
        this.roleService = roleService;
        this.userService = userService;
    }

    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        Role adminRole = roleService.save(Role.of(ROLE_ADMIN));
        Role userRole = roleService.save(Role.of(ROLE_USER));
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        roles.add(userRole);
        User admin = User.builder()
                .userId(USER_ADMIN)
                .profileName(USER_ADMIN)
                .password(PASSWORD)
                .role(roles)
                .build();
        userService.save(admin);
        log.info("Custom user 'admin' has been saved successfully");
        parserService.saveEntities(recordToDatabaseService.getRecords());
        log.info("ApplicationStartedEvent has finished all tasks!");
    }
}
