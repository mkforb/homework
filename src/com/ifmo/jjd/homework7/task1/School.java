package com.ifmo.jjd.homework7.task1;

import java.util.Objects;

public class School {
    private String title;
    private Principal principal;
    private Teacher[] teachers;
    private Pupil[] pupils;

    public School(String title, Principal principal) {
        Objects.requireNonNull(title, "Название не может быть null");
        Objects.requireNonNull(principal, "Директор не может быть null");
        if (title.length() < 3) throw new IllegalArgumentException("title < 3");
        this.title = title;
        this.principal = principal;
    }

    public String getTitle() {
        return title;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void schoolDay() {
        principal.announceClassStart();
        // Учиться
        principal.announceClassStop();
    }
}
