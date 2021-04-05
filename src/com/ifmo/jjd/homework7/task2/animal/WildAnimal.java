package com.ifmo.jjd.homework7.task2.animal;

import com.ifmo.jjd.homework7.task2.util.Rand;

abstract public class WildAnimal extends Animal {
    private final String name;
    private final int strength;
    private int chasingCount;

    public WildAnimal(int weight, int speed, String name, int strength) {
        super(weight, speed);
        this.name = name;
        this.strength = strength;
        this.chasingCount = 0;
    }

    public static WildAnimal get() {
        WildAnimal animal = null;
        String[] types = {"wolf", "bear", "fox"};
        String type = types[Rand.getInt(types.length)];
        switch (type) {
            case "wolf":
                animal = new Wolf();
                break;
            case "bear":
                animal = new Bear();
                break;
            case "fox":
                animal = new Fox();
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
        if (animal.getHealth() == 0) animal.setOnFarm(false);
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
