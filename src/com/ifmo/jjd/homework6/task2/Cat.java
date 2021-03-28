package com.ifmo.jjd.homework6.task2;

import java.util.Objects;

public class Cat {
    private String name;
    private String color;
    private int speed;
    private int weight;
    private Mouse[] mice;

    public Cat(String name, String color, int speed, int weight) {
        setName(name);
        setColor(color);
        setSpeed(speed);
        setWeight(weight);
        mice = new Mouse[100];
    }

    public void catchMouse(Mouse mouse) {
        if (speed <= mouse.getSpeed()) {
            System.out.println("Кот не смог поймать эту мышь");
            return;
        }
        for (int i = 0; i < mice.length; i++) {
            if (mice[i] == null) {
                mice[i] = mouse;
                return;
            }
        }
        System.out.println("Кот больше не может ловить мышей");
    }

    public void attackCat(Cat cat) {
        if (weight > cat.getWeight()) {
            for (int i = 0; i < cat.getMice().length; i++) {
                if (speed > cat.getMice()[i].getSpeed()) {
                    catchMouse(cat.getMice()[i]);
                    // cat.getMice()[i] == null; // ToDo: нет доступа, нужен метод
                }
            }
        } else {
            System.out.println("Этот кот сильнее");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Objects.requireNonNull(name, "name не может быть null");
        if (name.length() < 3) throw new IllegalArgumentException("name < 3");
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        Objects.requireNonNull(color, "color не может быть null");
        if (color.length() < 3) throw new IllegalArgumentException("color < 3");
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("speed < 0");
        }
        this.speed = speed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("weight < 0");
        }
        this.weight = weight;
    }

    public Mouse[] getMice() {
        return mice;
    }
}
