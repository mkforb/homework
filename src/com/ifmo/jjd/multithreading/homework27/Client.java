package com.ifmo.jjd.multithreading.homework27;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by User on 24.05.2021.
 */
public class Client implements Runnable {
    private final ArrayBlockingQueue<Order> clientWaiter;
    private final ArrayBlockingQueue<Order> cookClient;

    public Client(ArrayBlockingQueue<Order> clientWaiter, ArrayBlockingQueue<Order> cookClient) {
        this.clientWaiter = Objects.requireNonNull(clientWaiter);
        this.cookClient = Objects.requireNonNull(cookClient);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        Order order = new Order();
        try {
            clientWaiter.put(order);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Order order1 = cookClient.take();
            System.out.println("Client получил заказ " + order1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " stopped");
    }
}
