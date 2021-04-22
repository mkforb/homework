package com.ifmo.jjd.homework16.pupils;

import java.time.LocalDate;
import java.util.UUID;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private UUID number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    public Pupil(String name, Gender gender, LocalDate birth) {
        this.number = UUID.randomUUID();
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    // TODO: добавить все необходимые методы

}