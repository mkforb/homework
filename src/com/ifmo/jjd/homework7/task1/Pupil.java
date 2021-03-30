package com.ifmo.jjd.homework7.task1;

import java.util.Objects;

public class Pupil extends Person implements StudyAble {
    private String subjectStudied;
    private int knowledgeLevel;

    public Pupil(String fullname, int age, String subjectStudied, int knowledgeLevel) {
        super(fullname, age);
        setSubjectStudied(subjectStudied);
        setKnowledgeLevel(knowledgeLevel);
    }

    public String getSubjectStudied() {
        return subjectStudied;
    }

    public void setSubjectStudied(String subjectStudied) {
        Objects.requireNonNull(subjectStudied, "Изучаемый предмет не может быть null");
        this.subjectStudied = subjectStudied;
    }

    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(int knowledgeLevel) {
        if (knowledgeLevel < 0) throw new IllegalArgumentException("Уровень знаний не может быть отрицательным");
        this.knowledgeLevel = knowledgeLevel;
    }

    @Override
    public void study() {
        knowledgeLevel += 1;
    }
}
