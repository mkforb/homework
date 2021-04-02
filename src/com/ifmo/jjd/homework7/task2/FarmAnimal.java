package com.ifmo.jjd.homework7.task2;

import com.ifmo.jjd.homework7.task2.util.Rand;

public class FarmAnimal extends Animal {
    private final String type;
    private int health;
    private final int maxHealth;
    private final boolean edible;
    private final int resource;
    private boolean onFarm;

    private FarmAnimal(int weight, int speed, String type, int health, boolean edible, int resource, boolean onFarm) {
        super(weight, speed);
        this.type = type;
        this.health = health;
        this.maxHealth = health;
        this.edible = edible;
        this.resource = resource;
        this.onFarm = onFarm;
    }

    public static FarmAnimal get() {
        FarmAnimal animal = null;
        String[] types = {"cow", "cat", "chicken", "rabbit"};
        String type = types[Rand.getInt(types.length)];
        switch (type) {
            case "cow":
                animal = new FarmAnimal(Rand.getInt(200, 300),
                        Rand.getInt(5, 15),
                        type,
                        Rand.getInt(100, 200),
                        true,
                        Rand.getInt(10, 20),
                        true);
                break;
            case "cat":
                animal = new FarmAnimal(Rand.getInt(5, 10),
                        Rand.getInt(15, 25),
                        type,
                        Rand.getInt(10, 20),
                        false,
                        0,
                        true);
                break;
            case "chicken":
                animal = new FarmAnimal(Rand.getInt(3, 5),
                        Rand.getInt(2, 6),
                        type,
                        Rand.getInt(10, 20),
                        true,
                        Rand.getInt(5, 10),
                        true);
                break;
            case "rabbit":
                animal = new FarmAnimal(Rand.getInt(3, 5),
                        Rand.getInt(20, 30),
                        type,
                        Rand.getInt(20, 40),
                        true,
                        0,
                        true);
                break;
        }
        return animal;
    }

    public boolean isEdible() {
        return onFarm && edible;
    }

    public int getResource() {
        return onFarm ? resource : 0;
    }

    public boolean isOnFarm() {
        return onFarm;
    }

    public void setOnFarm(boolean onFarm) {
        this.onFarm = onFarm;
    }

    private void addHealth() {
        if (!onFarm || health == maxHealth) return;
        health++;
    }

    public void minusHealth(int count) {
        if (!onFarm) return;
        if (health > count) {
            health -= count;
        } else {
            health = 0;
            onFarm = false;
        }
    }

    public boolean eat() {
        if (!onFarm) return false;
        addHealth();
        return true;
    }

    @Override
    public String toString() {
        return type + "{" + health + "/" + maxHealth +
                ", edible=" + edible +
                ", resource=" + resource +
                ", onFarm=" + onFarm +
                ", speed=" + getSpeed() +
                "}";
    }
}
