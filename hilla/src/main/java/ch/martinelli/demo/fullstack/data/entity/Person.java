package ch.martinelli.demo.fullstack.data.entity;

import dev.hilla.Nonnull;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;

@Entity
public class Person extends AbstractEntity {

    @Nonnull
    private String firstName;
    @Nonnull
    private String lastName;
    @Email
    @Nonnull
    private String email;
    @Nonnull
    private String phone;
    private LocalDate dateOfBirth;
    @Nonnull
    private String occupation;
    @Nonnull
    private String role;
    private boolean important;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getOccupation() {
        return occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public boolean isImportant() {
        return important;
    }
    public void setImportant(boolean important) {
        this.important = important;
    }

}
