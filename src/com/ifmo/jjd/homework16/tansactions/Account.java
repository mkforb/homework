package com.ifmo.jjd.homework16.tansactions;

public class Account {
    private String number;
    private long balance;

    public Account(String number, long balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public long getBalance() {
        return balance;
    }

    // TODO: добавить геттеры и сеттеры
}
