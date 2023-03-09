package ch.martinelli.demo.fullstack.thymeleaf.controller;

import ch.martinelli.demo.fullstack.thymeleaf.data.Person;
import ch.martinelli.demo.fullstack.thymeleaf.data.PersonService;
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
    public String findAll(Model model) {
        model.addAttribute("active", "persons");

        Page<Person> persons = personService.list(Pageable.unpaged());
        model.addAttribute("persons", persons);

        return "persons";
    }
}
