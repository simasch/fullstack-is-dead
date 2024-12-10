@import ch.martinelli.demo.fullstack.jte.domain.Person
@import org.springframework.data.domain.Page

@param Page<Person> persons

@template.layout.main(
active = "persons",
content = @`
<h1>Persons</h1>

    <table class="table">
        <tr>
            <th style="width: 10rem">First Name</th>
            <th style="width: 10rem">Last Name</th>
            <th style="width: 10rem">Email</th>
            <th style="width: 14rem">Phone</th>
            <th style="width: 10rem">Date of Birth</th>
            <th style="width: 15rem">Occupation</th>
            <th>Role</th>
            <th>Important</th>
        </tr>
        @template.fragments.person-rows(persons = persons)
    </table>
`
)

