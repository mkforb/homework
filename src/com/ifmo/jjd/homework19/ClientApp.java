package com.ifmo.jjd.homework19;

/**
 * Created by User on 28.04.2021.
 */
public class ClientApp {
    public static void main(String[] args) {
        new Client("127.0.0.1", 8999).start();
    }
}