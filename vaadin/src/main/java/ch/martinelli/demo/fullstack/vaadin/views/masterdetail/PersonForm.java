package ch.martinelli.demo.fullstack.vaadin.views.masterdetail;

import ch.martinelli.demo.fullstack.vaadin.domain.Person;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;

public class PersonForm extends FormLayout {

    private final BeanValidationBinder<Person> binder = new BeanValidationBinder<>(Person.class);

    private TextField firstName;
    private TextField lastName;
    private TextField email;
    private TextField phone;
    private DatePicker dateOfBirth;
    private TextField occupation;
    private TextField role;
    private Checkbox important;

    public PersonForm() {
        firstName = new TextField("First Name");
        lastName = new TextField("Last Name");
        email = new TextField("Email");
        phone = new TextField("Phone");
        dateOfBirth = new DatePicker("Date Of Birth");
        occupation = new TextField("Occupation");
        role = new TextField("Role");
        important = new Checkbox("Important");

        add(firstName, lastName, email, phone, dateOfBirth, occupation, role, important);

        // Bind fields. This is where you would define converters and validation rules
        binder.bindInstanceFields(this);
    }

    public void writeBean(Person person) throws ValidationException {
        binder.writeBean(person);
    }

    public void readBean(Person person) {
        binder.readBean(person);
    }
}
