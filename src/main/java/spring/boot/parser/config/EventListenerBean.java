package spring.boot.parser.config;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import spring.boot.parser.model.Role;
import spring.boot.parser.service.CsvToBeanParserService;
import spring.boot.parser.service.RecordToDatabaseService;
import spring.boot.parser.service.RoleService;

@Log4j
@Component
public class EventListenerBean implements ApplicationListener<ApplicationStartedEvent> {
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
    @Value("${input.file.path}")
    private String fileName;
    private final RecordToDatabaseService parserService;
    private final CsvToBeanParserService csvToBeanParserService;
    private final RoleService roleService;

    @Autowired
    public EventListenerBean(RecordToDatabaseService parserService,
                             CsvToBeanParserService csvToBeanParserService,
                             RoleService roleService) {
        this.parserService = parserService;
        this.csvToBeanParserService = csvToBeanParserService;
        this.roleService = roleService;
    }

    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        roleService.save(Role.of(ROLE_ADMIN));
        roleService.save(Role.of(ROLE_USER));
        parserService.saveEntities(csvToBeanParserService.getRecords(fileName));
        log.info("ApplicationStartedEvent has finished all tasks!");
    }
}
