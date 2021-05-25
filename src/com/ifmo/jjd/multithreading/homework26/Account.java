package com.ifmo.jjd.multithreading.homework26;

import java.util.UUID;

public class Account {
    private final UUID uuid;
    private int balance;

    public Account(int balance) {
        this.balance = balance;
        uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void subtract(int sum) {
        balance -= sum;
        System.out.println("Счет " + uuid + " уменьшен на " + sum);
        System.out.println(this);
    }

    public void add(int sum) {
        balance += sum;
        System.out.println("Счет " + uuid + " увеличен на " + sum);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return uuid + ": " + balance;
    }
}