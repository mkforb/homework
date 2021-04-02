package com.ifmo.jjd.homework7.task2;

import com.ifmo.jjd.homework7.task2.util.Rand;

public class WildAnimal extends Animal {
    private final String name;
    private final int strength;
    private int chasingCount;

    private WildAnimal(int weight, int speed, String name, int strength) {
        super(weight, speed);
        this.name = name;
        this.strength = strength;
        this.chasingCount = 0;
    }

    public static WildAnimal get() {
        WildAnimal animal = null;
        String[] types = {"wolf", "bear", "fox"};
        String name = types[Rand.getInt(types.length)];
        switch (name) {
            case "wolf":
                animal = new WildAnimal(Rand.getInt(20, 40),
                        Rand.getInt(15, 25),
                        name,
                        Rand.getInt(50, 100));
                break;
            case "bear":
                animal = new WildAnimal(Rand.getInt(200, 300),
                        Rand.getInt(20, 30),
                        name,
                        Rand.getInt(100, 200));
                break;
            case "fox":
                animal = new WildAnimal(Rand.getInt(10, 20),
                        Rand.getInt(20, 30),
                        name,
                        Rand.getInt(20, 40));
                break;
        }
        return animal;
    }

    public void attack(FarmAnimal animal) {
        if (!animal.isOnFarm()) return;
        System.out.println(this + " атакует " + animal);
        if (getSpeed() <= animal.getSpeed()) {
            // Не может догнать
            System.out.println(animal + " убежал");
            return;
        }
        animal.minusHealth(strength);
        System.out.println(animal);
    }

    public void chase() {
        chasingCount++;
    }

    public boolean comeToFarm() {
        return chasingCount < 3;
    }

    @Override
    public String toString() {
        return name + "{" + strength + ", chasingCount=" + chasingCount + ", speed=" + getSpeed() + "}";
    }
}
