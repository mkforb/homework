package com.ifmo.jjd.homework16.tansactions;

public class Transaction {
    private String uuid;
    private long sum;
    private Account account;

    public Transaction(String uuid, long sum, Account account) {
        this.uuid = uuid;
        this.sum = sum;
        this.account = account;
    }

    // TODO: добавить геттеры и сеттеры
}