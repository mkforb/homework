package com.ifmo.jjd.homework7.task1;

public class AppSchool {
    public static void main(String[] args) {
        Principal principal = new Principal("Сергей Петрович", 38);
        School school = new School("Школа", principal, 1, 1);
        school.addTeacher(new Teacher("Вера Петровна", 28, "Математика"));
        school.addPupil(new Pupil("Вася", 8, "Математика", 1));

        System.out.println(school);

        school.schoolDay();
        System.out.println(school);

        school.schoolDay();
        System.out.println(school);
    }
}
