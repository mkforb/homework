package com.ifmo.jjd.homework7.task2.animal;

abstract public class Animal {
    private final int weight;
    private final int speed;

    public Animal(int weight, int speed) {
        this.weight = weight;
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }

    public int getSpeed() {
        return speed;
    }
}
