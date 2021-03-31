package com.ifmo.jjd.homework7.task1;

import java.util.Objects;

public class Teacher extends Person implements TeachAble {
    private String taughtSubject;

    public Teacher(String fullname, int age, String taughtSubject) {
        super(fullname, age);
        setTaughtSubject(taughtSubject);
    }

    public String getTaughtSubject() {
        return taughtSubject;
    }

    public void setTaughtSubject(String taughtSubject) {
        Objects.requireNonNull(taughtSubject, "Преподаваемый предмет не может быть null");
        this.taughtSubject = taughtSubject;
    }

    @Override
    public void teach(StudyAble studyAble) {
        studyAble.study();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "taughtSubject='" + taughtSubject + '\'' +
                '}';
    }
}
