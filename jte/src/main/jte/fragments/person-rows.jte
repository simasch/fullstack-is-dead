@import ch.martinelli.demo.fullstack.jte.domain.Person
@import org.springframework.data.domain.Page

@param Page<Person> persons

@for(Person person : persons.getContent())
    <tr>
        <td>${person.getFirstName()}</td>
        <td>${person.getLastName()}</td>
        <td>${person.getEmail()}</td>
        <td>${person.getPhone()}</td>
        <td>${person.getDateOfBirth().toString()}</td>
        <td>${person.getOccupation()}</td>
        <td>${person.getRole()}</td>
        <td>${person.isImportant() ? "✓" : ""}</td>
    </tr>
@endfor

