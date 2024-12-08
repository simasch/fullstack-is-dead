@import ch.martinelli.demo.fullstack.jte.domain.Person
@import org.springframework.data.domain.Page

@param Page<Person> persons

@template.layout.main(
active = "persons",
content = @`
<h1>Persons</h1>

    <table class="table">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Date of Birth</th>
            <th>Occupation</th>
            <th>Role</th>
            <th>Important</th>
        </tr>
        @template.fragments.person-rows(persons = persons)
    </table>
`
)

