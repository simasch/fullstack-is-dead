package ch.martinelli.demo.fullstack.thymeleaf.api;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.FragmentsRendering;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String helloWorld(Model model) {
        model.addAttribute("active", "hello-world");
        return "hello-world";
    }

    /*
     * https://docs.spring.io/spring-framework/reference/web/webmvc-view/mvc-fragments.html
     */
    @PostMapping("/greet")
    @HxRequest
    public FragmentsRendering sayHello(Model model, @ModelAttribute("name") String name) {
        model.addAttribute("greeting", "Hello, " + (StringUtils.isBlank(name) ? "Stranger" : name));

        return FragmentsRendering
                .with("fragments :: greeting")
                .build();
    }

}
