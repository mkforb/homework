package com.ifmo.jjd.homework6.task1;

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

    public void setFirstname(String firstname) {
        if (firstname == null || firstname.trim().length() < 2) {
            throw new IllegalArgumentException("firstname < 2");
        }
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        if (lastname == null || lastname.trim().length() < 2) {
            throw new IllegalArgumentException("lastname < 2");
        }
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
