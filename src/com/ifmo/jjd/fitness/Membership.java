package com.ifmo.jjd.fitness;

import java.time.LocalDate;

public class Membership {
    private final LocalDate regDate;
    private final LocalDate endDate;
    private final Visitor visitor;
    private final Type type;

    public Membership(LocalDate endDate, Visitor visitor, Type type) {
        this.regDate = LocalDate.now();
        this.endDate = endDate;
        this.visitor = visitor;
        this.type = type;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public Type getType() {
        return type;
    }
}
