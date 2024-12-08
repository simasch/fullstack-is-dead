@import ch.martinelli.demo.fullstack.jte.domain.Person

@param Person person

<td>${person.getFirstName()}</td>
<td>${person.getLastName()}</td>
<td>${person.getEmail()}</td>
<td>${person.getPhone()}</td>
<td>${person.getDateOfBirth().toString()}</td>
<td>${person.getOccupation()}</td>
<td>${person.getRole()}</td>
<td>${person.isImportant() ? "✓" : ""}</td>
