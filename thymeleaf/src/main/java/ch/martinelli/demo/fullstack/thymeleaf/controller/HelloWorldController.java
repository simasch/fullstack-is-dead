package ch.martinelli.demo.fullstack.thymeleaf.controller;

import io.github.wimdeblauwe.hsbt.mvc.HtmxResponse;
import io.github.wimdeblauwe.hsbt.mvc.HxRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/")
    public String helloWorld(Model model) {
        model.addAttribute("active", "hello-world");
        return "hello-world";
    }

    @PostMapping("/greet")
    @HxRequest
    public HtmxResponse sayHello(Model model, @ModelAttribute("name") String name) {
        model.addAttribute("greeting", "Hello, " + (StringUtils.isBlank(name) ? "Stranger" : name));

        return new HtmxResponse().addTemplate("fragments :: greeting");
    }

}
