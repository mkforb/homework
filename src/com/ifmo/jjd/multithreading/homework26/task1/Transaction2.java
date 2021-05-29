package com.ifmo.jjd.multithreading.homework26.task1;

/**
 * Created by User on 23.05.2021.
 */
public class Transaction2 extends Transaction {
    public Transaction2(Account src, Account dst, int money) {
        super(src, dst, money);
    }

    @Override
    public void run() {
        // перевод с src на dst
        if (src.getBalance() < money) {
            System.out.println("Недостаточно средств на счету " + src.getUuid());
            return;
        }
        // Вариант 1:
        if (src.getUuid().compareTo(dst.getUuid()) < 0) {
            synchronized (src) {
                synchronized (dst){
                    src.subtract(money);
                    dst.add(money);
                }
            }
        } else {
            synchronized (dst) {
                synchronized (src){
                    src.subtract(money);
                    dst.add(money);
                }
            }
        }
    }
}
