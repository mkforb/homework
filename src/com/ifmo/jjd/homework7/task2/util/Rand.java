package com.ifmo.jjd.homework7.task2.util;

public class Rand {
    public static int getInt(int min, int max){
        return (int) (Math.random() * (max - min)) + min;
    }

    public static int getInt(int max) {
        return getInt(0, max);
    }
}
