package com.ifmo.jjd.multithreading.homework26.task1;

/**
 * Created by User on 23.05.2021.
 */
public class Transaction1 extends Transaction {
    public Transaction1(Account src, Account dst, int money) {
        super(src, dst, money);
    }

    @Override
    public void run() {
        // перевод с src на dst
        if (src.getBalance() < money) {
            System.out.println("Недостаточно средств на счету " + src.getUuid());
            return;
        }
        // Вариант 1: Сначала списать, потом зачислить. Поочередная блокировка src, dst
        synchronized (src) {
            src.subtract(money);
        }
        synchronized (dst) {
            dst.add(money);
        }
    }
}
