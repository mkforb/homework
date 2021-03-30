package com.ifmo.jjd.homework6.task1;

import java.util.Objects;

public class Author {
    private String firstname;
    private String lastname;

    public Author(String firstname, String lastname) {
        setFirstname(firstname);
        setLastname(lastname);
    }

    public String getFirstname() {
        return firstname;
    }

    private void setFirstname(String firstname) {
        Objects.requireNonNull(firstname, "firstname не может быть null");
        if (firstname.trim().length() < 2) throw new IllegalArgumentException("firstname < 2");
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    private void setLastname(String lastname) {
        Objects.requireNonNull(lastname, "lastname не может быть null");
        if (lastname.trim().length() < 2) throw new IllegalArgumentException("lastname < 2");
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
