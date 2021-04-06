package com.ifmo.jjd.fitness;

public class Visitor {
    private final String firstname;
    private final String lastname;
    private final int birthYear;

    public Visitor(String firstname, String lastname, int birthYear) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthYear = birthYear;
    }
}
