package com.ifmo.jjd.multithreading.homework27;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by User on 29.05.2021.
 */
public class App {
    public static void main(String[] args) {
        ArrayBlockingQueue<Order> clientWaiter = new ArrayBlockingQueue<>(1);
        ArrayBlockingQueue<Order> waiterCook = new ArrayBlockingQueue<>(1);
        ArrayBlockingQueue<Order> cookClient = new ArrayBlockingQueue<>(1);
        Thread threadClient = new Thread(new Client(clientWaiter, cookClient));
        threadClient.setName("Client");
        threadClient.start();
        Thread threadWaiter = new Thread(new Waiter(waiterCook, clientWaiter));
        threadWaiter.setName("Waiter");
        threadWaiter.start();
        Thread threadCook = new Thread(new Cook(cookClient, waiterCook));
        threadCook.setName("Cook");
        threadCook.start();
    }
}
