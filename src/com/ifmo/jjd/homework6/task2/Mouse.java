package com.ifmo.jjd.homework6.task2;

public class Mouse {
    private int speed;

    public Mouse(int speed) {
        setSpeed(speed);
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
}
