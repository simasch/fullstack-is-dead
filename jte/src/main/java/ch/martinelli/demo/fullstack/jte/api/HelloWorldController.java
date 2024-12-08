package ch.martinelli.demo.fullstack.jte.api;

import gg.jte.runtime.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String helloWorld() {
        return "pages/hello-world";
    }

    /*
     * https://docs.spring.io/spring-framework/reference/web/webmvc-view/mvc-fragments.html
     */
    @PostMapping("/greet")
    public String sayHello(Model model, @ModelAttribute("name") String name) {
        model.addAttribute("greeting", "Hello, " + (StringUtils.isBlank(name) ? "Stranger" : name));

        return "fragments/greeting";
    }

}
