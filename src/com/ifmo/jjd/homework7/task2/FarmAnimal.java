package com.ifmo.jjd.homework7.task2;

import com.ifmo.jjd.homework7.task2.util.Randoms;

public class FarmAnimal extends Animal {
    private final String type;
    private int health;
    private final int maxHealth;
    private boolean edible;
    private int resource;
    private boolean onFarm;

    public FarmAnimal() {
        String[] types = {"cow", "cat", "chicken", "rabbit"};
        type = types[Randoms.getRandomInt(types.length)];
        switch (type) {
            case "cow":
                setWeight(Randoms.getRandomInt(200, 300));
                setSpeed(Randoms.getRandomInt(5, 15));
                health = Randoms.getRandomInt(100, 200);
                edible = true;
                resource = Randoms.getRandomInt(10, 20);
                break;
            case "cat":
                setWeight(Randoms.getRandomInt(5, 10));
                setSpeed(Randoms.getRandomInt(15, 25));
                health = Randoms.getRandomInt(10, 20);
                edible = false;
                resource = 0;
                break;
            case "chicken":
                setWeight(Randoms.getRandomInt(3, 5));
                setSpeed(Randoms.getRandomInt(2, 6));
                health = Randoms.getRandomInt(10, 20);
                edible = true;
                resource = Randoms.getRandomInt(5, 10);
                break;
            case "rabbit":
                setWeight(Randoms.getRandomInt(3, 5));
                setSpeed(Randoms.getRandomInt(20, 30));
                health = Randoms.getRandomInt(20, 40);
                edible = true;
                resource = 0;
                break;
        }
        maxHealth = health;
        onFarm = true;
    }

    public boolean isEdible() {
        return edible;
    }

    public int getResource() {
        if (!onFarm) return 0;
        return resource;
    }

    public boolean isOnFarm() {
        return onFarm;
    }

    public void setOnFarm(boolean onFarm) {
        this.onFarm = onFarm;
    }

    private void addHealth() {
        if (!onFarm) return;
        if (health == maxHealth) return;
        health++;
    }

    public void minusHealth(int count) {
        if (!onFarm) return;
        if (health > count) {
            health -= count;
        } else {
            health = 0;
            onFarm = false;
            edible = false;
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
