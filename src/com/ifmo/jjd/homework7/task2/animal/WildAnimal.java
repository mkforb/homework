package com.ifmo.jjd.homework7.task2.animal;

import com.ifmo.jjd.homework7.task2.util.Rand;

import static com.ifmo.jjd.homework7.task2.Settings.*;
import static com.ifmo.jjd.homework7.task2.Settings.WOLF_STRENGTH_TO;

public class WildAnimal extends Animal {
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
                animal = new WildAnimal(Rand.getInt(WOLF_WEIGHT_FROM, WOLF_WEIGHT_TO),
                        Rand.getInt(WOLF_SPEED_FROM, WOLF_SPEED_TO),
                        "wolf",
                        Rand.getInt(WOLF_STRENGTH_FROM, WOLF_STRENGTH_TO));
                break;
            case "bear":
                animal = new WildAnimal(Rand.getInt(BEAR_WEIGHT_FROM, BEAR_WEIGHT_TO),
                        Rand.getInt(BEAR_SPEED_FROM, BEAR_SPEED_TO),
                        "bear",
                        Rand.getInt(BEAR_STRENGTH_FROM, BEAR_STRENGTH_TO));
                break;
            case "fox":
                animal = new WildAnimal(Rand.getInt(FOX_WEIGHT_FROM, FOX_WEIGHT_TO),
                        Rand.getInt(FOX_SPEED_FROM, FOX_SPEED_TO),
                        "fox",
                        Rand.getInt(FOX_STRENGTH_FROM, FOX_STRENGTH_TO));
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
