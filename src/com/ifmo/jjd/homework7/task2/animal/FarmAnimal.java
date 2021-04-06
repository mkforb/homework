package com.ifmo.jjd.homework7.task2.animal;

import com.ifmo.jjd.homework7.task2.util.Rand;

import static com.ifmo.jjd.homework7.task2.Settings.*;

public class FarmAnimal extends Animal {
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
                animal = new FarmAnimal(Rand.getInt(COW_WEIGHT_FROM, COW_WEIGHT_TO),
                        Rand.getInt(COW_SPEED_FROM, COW_SPEED_TO),
                        "cow",
                        Rand.getInt(COW_HEALTH_FROM, COW_HEALTH_TO),
                        true,
                        Rand.getInt(COW_RESOURCE_FROM, COW_RESOURCE_TO),
                        true);
                break;
            case "cat":
                animal = new FarmAnimal(Rand.getInt(CAT_WEIGHT_FROM, CAT_WEIGHT_TO),
                        Rand.getInt(CAT_SPEED_FROM, CAT_SPEED_TO),
                        "cat",
                        Rand.getInt(CAT_HEALTH_FROM, CAT_HEALTH_TO),
                        false,
                        0,
                        true);
                break;
            case "chicken":
                animal = new FarmAnimal(Rand.getInt(CHICKEN_WEIGHT_FROM, CHICKEN_WEIGHT_TO),
                        Rand.getInt(CHICKEN_SPEED_FROM, CHICKEN_SPEED_TO),
                        "chicken",
                        Rand.getInt(CHICKEN_HEALTH_FROM, CHICKEN_HEALTH_TO),
                        true,
                        Rand.getInt(CHICKEN_RESOURCE_FROM, CHICKEN_RESOURCE_TO),
                        true);
                break;
            case "rabbit":
                animal = new FarmAnimal(Rand.getInt(RABBIT_WEIGHT_FROM, RABBIT_WEIGHT_TO),
                        Rand.getInt(RABBIT_SPEED_FROM, RABBIT_SPEED_TO),
                        "rabbit",
                        Rand.getInt(RABBIT_HEALTH_FROM, RABBIT_HEALTH_TO),
                        true,
                        0,
                        true);
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
