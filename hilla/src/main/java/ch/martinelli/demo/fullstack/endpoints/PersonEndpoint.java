package ch.martinelli.demo.fullstack.endpoints;

import ch.martinelli.demo.fullstack.data.Person;
import ch.martinelli.demo.fullstack.data.PersonService;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;
import dev.hilla.Nonnull;
import dev.hilla.exception.EndpointException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Endpoint
@AnonymousAllowed
public class PersonEndpoint {

    private final PersonService service;

    public PersonEndpoint(PersonService service) {
        this.service = service;
    }

    @Nonnull
    public Page<@Nonnull Person> list(Pageable page) {
        return service.list(page);
    }

    public Optional<Person> get(@Nonnull Long id) {
        return service.get(id);
    }

    @Nonnull
    public Person update(@Nonnull Person entity) {
        try {
            return service.update(entity);
        } catch (OptimisticLockingFailureException e) {
            throw new EndpointException("Somebody else has updated the data while you were making changes.");
        }
    }

    public void delete(@Nonnull Long id) {
        service.delete(id);
    }

    public int count() {
        return service.count();
    }

}
