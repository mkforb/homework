package com.ifmo.jjd.fitness;

import java.time.LocalDate;

public class Subscription {
    private final LocalDate regDate;
    private final LocalDate endDate;
    private final Visitor visitor;
    private final SubscriptionType type;

    public Subscription(LocalDate endDate, Visitor visitor, SubscriptionType type) {
        this.regDate = LocalDate.now();
        this.endDate = endDate;
        this.visitor = visitor;
        this.type = type;
    }

    public SubscriptionType getType() {
        return type;
    }
}
