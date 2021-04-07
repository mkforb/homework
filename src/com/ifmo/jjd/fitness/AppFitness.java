package com.ifmo.jjd.fitness;

import java.time.LocalDate;

public class AppFitness {
    public static void main(String[] args) {
        Membership member1 = new Membership(LocalDate.of(2021, 4, 30),
                new Visitor("Василий", "Петров", 2003),
                Type.ONCE);
        Fitness fitness = new Fitness();
        fitness.visitorArrive(member1, Zone.GYM);
        /*for (int i = 0; i < 20; i++) {
            Membership mem1 = new Membership(LocalDate.parse("2021-09-30"), new Visitor("Петя", "П"+i, 1980+i), Type.ONCE);
            fitness.visitorArrive(mem1, Zone.GYM);
        }*/
        fitness.printVisitors();
        fitness.visitorLeave(member1);
        fitness.printVisitors();
        fitness.close();
    }
}
