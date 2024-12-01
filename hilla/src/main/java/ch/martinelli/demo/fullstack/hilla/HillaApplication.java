package ch.martinelli.demo.fullstack.hilla;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of the Spring Boot application.
 * <p>
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 */
@SpringBootApplication
@Theme(value = "hilla")
public class HillaApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(HillaApplication.class, args);
    }
}
