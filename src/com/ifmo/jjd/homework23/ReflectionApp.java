package com.ifmo.jjd.homework23;

/**
 * Created by User on 14.05.2021.
 */
public class ReflectionApp {
    public static void main(String[] args) {
        int int1 = 15;
        toString(int1);
    }

    private static void toString(Object o) {
        System.out.println(o.getClass().getName());
        if (o.getClass().isPrimitive()) {
            System.out.println(o);
        } else {
            System.out.println(o);
        }
    }
}
