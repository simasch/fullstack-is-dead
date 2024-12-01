package ch.martinelli.demo.fullstack.thymeleaf.api;

import ch.martinelli.demo.fullstack.thymeleaf.domain.Person;
import ch.martinelli.demo.fullstack.thymeleaf.domain.PersonService;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public String findAll(Model model, Pageable pageable) {
        model.addAttribute("active", "persons");

        Page<Person> persons = personService.list(pageable);
        model.addAttribute("persons", persons);

        return "persons";
    }

    @GetMapping("/persons")
    @HxRequest
    public String findAllHtmx(Model model, Pageable pageable) {
        Page<Person> persons = personService.list(pageable);
        model.addAttribute("persons", persons);

        return "persons :: tr#content-rows";
    }
}
