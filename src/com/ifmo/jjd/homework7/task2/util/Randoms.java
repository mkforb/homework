package com.ifmo.jjd.homework7.task2.util;

public class Randoms {
    public static int getRandomInt(int min, int max){
        return (int) (Math.random() * (max - min)) + min;
    }

    public static int getRandomInt(int max) {
        return getRandomInt(0, max);
    }
}
