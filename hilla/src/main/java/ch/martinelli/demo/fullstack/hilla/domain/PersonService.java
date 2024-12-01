package ch.martinelli.demo.fullstack.hilla.domain;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.crud.CrudRepositoryService;
import com.vaadin.hilla.crud.ListRepositoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AnonymousAllowed
@BrowserCallable
@Service
public class PersonService extends CrudRepositoryService<Person, Long, PersonRepository> {
}