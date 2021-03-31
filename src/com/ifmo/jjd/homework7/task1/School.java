package com.ifmo.jjd.homework7.task1;

import java.util.Arrays;
import java.util.Objects;

public class School {
    private String title;
    private Principal principal;
    private Teacher[] teachers;
    private Pupil[] pupils;

    public School(String title, Principal principal, int teachersCount, int pupilsCount) {
        Objects.requireNonNull(title, "Название не может быть null");
        Objects.requireNonNull(principal, "Директор не может быть null");
        if (title.length() < 3) throw new IllegalArgumentException("title < 3");
        if (teachersCount < 1) throw new IllegalArgumentException("Школа не может быть без учителей");
        if (pupilsCount < 1) throw new IllegalArgumentException("Школа не может быть без учеников");
        this.title = title;
        this.principal = principal;
        teachers = new Teacher[teachersCount];
        pupils = new Pupil[pupilsCount];
    }

    public String getTitle() {
        return title;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public boolean addTeacher(Teacher teacher) {
        Objects.requireNonNull(teacher, "Учитель не может быть null");
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teachers[i] = teacher;
                return true;
            }
        }
        System.out.println("Все учителя уже добавлены");
        return false;
    }

    public boolean addPupil(Pupil pupil) {
        Objects.requireNonNull(pupil, "Ученик не может быть null");
        for (int i = 0; i < pupils.length; i++) {
            if (pupils[i] == null) {
                pupils[i] = pupil;
                return true;
            }
        }
        System.out.println("Все ученики уже добавлены");
        return false;
    }

    public void schoolDay() {
        principal.announceClassStart();
        // Учиться
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) break;
            for (int j = 0; j < pupils.length; j++) {
                if (pupils[j] == null) break;
                if (teachers[i].getTaughtSubject().equals(pupils[j].getSubjectStudied())) {
                    teachers[i].teach(pupils[j]);
                }
            }
        }
        principal.announceClassStop();
    }

    @Override
    public String toString() {
        return "School{" +
                "title='" + title + '\'' +
                ", principal=" + principal +
                ", teachers=" + Arrays.toString(teachers) +
                ", pupils=" + Arrays.toString(pupils) +
                '}';
    }
}
