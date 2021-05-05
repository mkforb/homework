package com.ifmo.jjd.homework19;

/**
 * Created by User on 28.04.2021.
 */
public class ServerApp {
    public static void main(String[] args) {
        new ImgServer(8999).start();
    }
}