package ch.martinelli.demo.fullstack.jte.api;

import ch.martinelli.demo.fullstack.jte.domain.Person;
import ch.martinelli.demo.fullstack.jte.domain.PersonService;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public String findAll(Model model) {
        model.addAttribute("active", "persons");

        Page<Person> persons = personService.list(PageRequest.of(0, 10));
        model.addAttribute("persons", persons);

        return "pages/persons";
    }

    @GetMapping("/persons/paging")
    public String findAll(Model model, @RequestParam Integer page, @RequestParam Integer size) {
        Page<Person> persons = personService.list(PageRequest.of(page, size));
        model.addAttribute("persons", persons);

        return "fragments/person-rows";
    }
}
