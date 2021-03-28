package com.ifmo.jjd.homework6.task2;

public class Application {
    public static void main(String[] args) {
        Cat catTom = new Cat("Том", "серый", 10, 3);
        catTom.catchMouse(new Mouse(9));
        System.out.println(catTom);
    }
}
