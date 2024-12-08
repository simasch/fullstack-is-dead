@import ch.martinelli.demo.fullstack.jte.domain.Person
@import org.springframework.data.domain.Page

@param Page<Person> persons

@for(int i = 0; i < persons.getContent().size(); i++)
    @if(i == persons.getSize() - 1)
        <tr hx-get="/persons/paging?size=${persons.getSize()}&page=${persons.getNumber() + 1}"
            hx-trigger="revealed"
            hx-swap="afterend">
            @template.fragments.person-row(person = persons.getContent().get(i))
        </tr>
    @else
        <tr>
            @template.fragments.person-row(person = persons.getContent().get(i))
        </tr>
    @endif
@endfor

