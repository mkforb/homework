package com.ifmo.jjd.homework7.task2.animal;

import com.ifmo.jjd.homework7.task2.util.Rand;

abstract public class FarmAnimal extends Animal {
    private final String type;
    private int health;
    private final int maxHealth;
    private final boolean edible;
    private final int resource;
    private boolean onFarm;

    public FarmAnimal(int weight, int speed, String type, int health, boolean edible, int resource, boolean onFarm) {
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
                animal = new Cow();
                break;
            case "cat":
                animal = new Cat();
                break;
            case "chicken":
                animal = new Chicken();
                break;
            case "rabbit":
                animal = new Rabbit();
                break;
        }
        return animal;
    }

    public int getHealth() {
        return health;
    }

    public boolean isEdible() {
        return edible;
    }

    public int getResource() {
        return resource;
    }

    public boolean isOnFarm() {
        return onFarm;
    }

    public void setOnFarm(boolean onFarm) {
        this.onFarm = onFarm;
    }

    private void addHealth(int count) {
        if (health + count >= maxHealth) {
            health = maxHealth;
        } else {
            health += count;
        }
    }

    public void minusHealth(int count) {
        if (health > count) {
            health -= count;
        } else {
            health = 0;
        }
    }

    public void eat() {
        addHealth(1);
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
