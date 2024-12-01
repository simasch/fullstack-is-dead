package ch.martinelli.demo.fullstack.hilla.domain;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import com.vaadin.hilla.Nonnull;
import org.springframework.stereotype.Service;

@BrowserCallable
@AnonymousAllowed
@Service
public class HelloWorldService {

    public @Nonnull String sayHello(String name) {
        if (name.isEmpty()) {
            return "Hello stranger";
        } else {
            return "Hello " + name;
        }
    }
}
