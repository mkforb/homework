package com.ifmo.jjd.multithreading.homework27;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by User on 29.05.2021.
 */
public class Cook implements Runnable {
    private final ArrayBlockingQueue<Order> cookClient;
    private final ArrayBlockingQueue<Order> waiterCook;

    public Cook(ArrayBlockingQueue<Order> cookClient, ArrayBlockingQueue<Order> waiterCook) {
        this.cookClient = cookClient;
        this.waiterCook = waiterCook;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        Order order = null;
        try {
            order = waiterCook.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Cook получил заказ " + order);
        if (order == null) {
            return;
        }
        order.setStatus(Order.Status.READY);
        try {
            cookClient.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " stopped");
    }
}
