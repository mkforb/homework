package com.ifmo.jjd.fitness;

import java.time.LocalDate;
import java.util.Objects;

public class Visitor {
    private final String firstname;
    private final String lastname;
    private final int birthYear;

    public Visitor(String firstname, String lastname, int birthYear) {
        // Проверка firstname
        Objects.requireNonNull(firstname, "firstname не может быть null");
        if (firstname.length() < 2) throw new IllegalArgumentException("Длина firstname < 2");
        // Проверка lastname
        Objects.requireNonNull(lastname, "lastname не может быть null");
        if (lastname.length() < 2) throw new IllegalArgumentException("Длина lastname < 2");
        // Проверка birthYear
        if (LocalDate.now().getYear() - birthYear < 18) throw new IllegalArgumentException("Посещение разрешено с 18 лет");
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthYear = birthYear;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visitor)) return false;
        Visitor visitor = (Visitor) o;
        return birthYear == visitor.birthYear && firstname.equals(visitor.firstname) && lastname.equals(visitor.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, birthYear);
    }

    @Override
    public String toString() {
        return firstname + " " + lastname + " (" + birthYear + ")";
    }
}
