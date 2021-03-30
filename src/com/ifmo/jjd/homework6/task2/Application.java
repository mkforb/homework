package com.ifmo.jjd.homework6.task2;

public class Application {
    public static void main(String[] args) {
        Cat catTom = new Cat("Том", 10, 3);
        catTom.catchMouse(new Mouse(9));
        catTom.catchMouse(new Mouse(1));

        Cat catVasya = new Cat("Васька", 12, 2);
        catVasya.catchMouse(new Mouse(3));
        catVasya.catchMouse(new Mouse(11));

        catTom.attackCat(catVasya);

        System.out.println(catTom);
        System.out.println(catVasya);
    }
}
