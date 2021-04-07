package com.ifmo.jjd.fitness;

import java.time.LocalDate;
import java.util.Objects;

public class Membership {
    private final LocalDate regDate;
    private final LocalDate endDate;
    private final Visitor visitor;
    private final Type type;

    public Membership(LocalDate endDate, Visitor visitor, Type type) {
        // Проверка endDate
        Objects.requireNonNull(endDate, "endDate не может быть null");
        if (endDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("endDate < текущей даты");
        // Проверка visitor
        Objects.requireNonNull(visitor, "visitor не может быть null");
        // Проверка type
        Objects.requireNonNull(type, "type не может быть null");
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
