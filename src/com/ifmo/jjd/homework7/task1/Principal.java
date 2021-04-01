package com.ifmo.jjd.homework7.task1;

public class Principal extends Person {
    public Principal(String fullname, int age) {
        super(fullname, age);
    }

    public void announceClassStart() {
        System.out.println(getFullname() + " объявил начало занятий");
    }

    public void announceClassStop() {
        System.out.println(getFullname() + " объявил конец занятий");
    }

    @Override
    public String toString() {
        return "Principal{}";
    }
}
