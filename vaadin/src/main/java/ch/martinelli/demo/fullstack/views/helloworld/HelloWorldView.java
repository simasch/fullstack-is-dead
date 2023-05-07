package ch.martinelli.demo.fullstack.views.helloworld;

import ch.martinelli.demo.fullstack.views.MainLayout;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Hello World | Vaadin")
@Route(value = "hello", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class HelloWorldView extends HorizontalLayout {

    public HelloWorldView() {
        setMargin(true);

        TextField name = new TextField("Your name");

        Button sayHello = new Button("Say hello", e ->
                Notification.show("Hello %s".formatted(name.getValue()), 5000, Notification.Position.MIDDLE));

        add(name, sayHello);

        setVerticalComponentAlignment(Alignment.END, name, sayHello);
    }

}
