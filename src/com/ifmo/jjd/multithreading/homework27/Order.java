package com.ifmo.jjd.multithreading.homework27;

import java.util.UUID;

/**
 * Created by User on 24.05.2021.
 */
public class Order {
    enum Status {
        NEW, COOKING, READY
    }
    private final UUID id;
    private Status status = Status.NEW;

    public Order() {
        this.id = UUID.randomUUID();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order {" + id.toString() + ", " + status + "}";
    }
}