package com.ifmo.jjd.fitness;

import java.time.LocalDate;

public class AppFitness {
    public static void main(String[] args) {
        Subscription sub1 = new Subscription(LocalDate.of(2021, 4, 30),
                new Visitor("Василий", "Петров", 1990),
                SubscriptionType.ONCE);
        Fitness fitness = new Fitness();
        fitness.visitorArrive(sub1, Zone.GROUP);
        fitness.visitorLeave(sub1);
        fitness.close();
    }
}
