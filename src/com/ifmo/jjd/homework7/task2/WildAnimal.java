package com.ifmo.jjd.homework7.task2;

import com.ifmo.jjd.homework7.task2.util.Randoms;

public class WildAnimal extends Animal {
    private String name;
    private int strength;
    private int chasingCount;

    public WildAnimal() {
        String[] types = {"wolf", "bear", "fox"};
        name = types[Randoms.getRandomInt(types.length)];
        switch (name) {
            case "wolf":
                setWeight(Randoms.getRandomInt(20, 40));
                setSpeed(Randoms.getRandomInt(15, 25));
                strength = Randoms.getRandomInt(50, 100);
                break;
            case "bear":
                setWeight(Randoms.getRandomInt(200, 300));
                setSpeed(Randoms.getRandomInt(20, 30));
                strength = Randoms.getRandomInt(100, 200);
                break;
            case "fox":
                setWeight(Randoms.getRandomInt(10, 20));
                setSpeed(Randoms.getRandomInt(20, 30));
                strength = Randoms.getRandomInt(20, 40);
                break;
        }
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
