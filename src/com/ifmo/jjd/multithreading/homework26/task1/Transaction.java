package com.ifmo.jjd.multithreading.homework26.task1;

import com.ifmo.jjd.multithreading.homework26.task1.Account;

public abstract class Transaction implements Runnable{
    protected final Account src;
    protected final Account dst;
    protected int money;

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }
}