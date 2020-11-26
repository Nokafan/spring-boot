package spring.boot.parser;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.parser.controllers.InjectConroller;

@SpringBootTest
public class ApplicationTests {
    @Autowired
    private InjectConroller injectConroller;

    @Test
    void contextLoadedInjectConroller_Ok() {
        assertThat(injectConroller).isNotNull();
    }
}
