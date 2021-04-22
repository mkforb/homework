package com.ifmo.jjd.homework16.pupils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
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

    public UUID getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public int getAge() {
        return Period.between(birth, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pupil)) return false;
        Pupil pupil = (Pupil) o;
        return Objects.equals(getNumber(), pupil.getNumber()) && Objects.equals(getName(), pupil.getName()) && getGender() == pupil.getGender() && Objects.equals(getBirth(), pupil.getBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getName(), getGender(), getBirth());
    }

    // TODO: добавить все необходимые методы

}