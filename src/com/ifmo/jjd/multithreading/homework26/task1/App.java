package com.ifmo.jjd.multithreading.homework26.task1;

/**
 * Created by User on 29.05.2021.
 */
public class App {
    public static void main(String[] args) {
        // Транзакции
        Account acc1 = new Account(400);
        Account acc2 = new Account(900);
        Thread thread1 = new Thread(new Transaction1(acc1, acc2, 50));
        thread1.start();
        Thread thread2 = new Thread(new Transaction2(acc2, acc1, 120));
        thread2.start();
    }
}
