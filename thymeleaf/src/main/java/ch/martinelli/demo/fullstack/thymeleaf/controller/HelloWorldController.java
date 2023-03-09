package ch.martinelli.demo.fullstack.thymeleaf.controller;

import io.github.wimdeblauwe.hsbt.mvc.HtmxResponse;
import io.github.wimdeblauwe.hsbt.mvc.HxRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloWorldController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    @GetMapping("/")
    public String helloWorld() {
        return "hello-world";
    }

    @PostMapping("/greet")
    @HxRequest
    public HtmxResponse sayHello(Model model, @ModelAttribute("name") String name) {
        model.addAttribute("greeting", "Hello, " + name);

        return new HtmxResponse().addTemplate("fragments :: greeting");
    }

}
