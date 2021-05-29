package com.ifmo.jjd.multithreading.homework27;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by User on 29.05.2021.
 */
public class Waiter implements Runnable {
    private final ArrayBlockingQueue<Order> waiterCook;
    private final ArrayBlockingQueue<Order> clientWaiter;

    public Waiter(ArrayBlockingQueue<Order> waiterCook, ArrayBlockingQueue<Order> clientWaiter) {
        this.waiterCook = Objects.requireNonNull(waiterCook);
        this.clientWaiter = Objects.requireNonNull(clientWaiter);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        Order order = null;
        try {
            order = clientWaiter.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Waiter получил заказ " + order);
        if (order == null) {
            return;
        }
        order.setStatus(Order.Status.COOKING);
        try {
            waiterCook.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " stopped");
    }
}
