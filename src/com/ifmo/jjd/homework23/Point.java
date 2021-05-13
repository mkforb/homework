package com.ifmo.jjd.homework23;

/**
 * Created by User on 12.05.2021.
 */
@Component(fileName = "params.properties", version = 2)
public class Point {
    @Required
    private int x;
    @Required
    private int y;
    @Required
    private String str;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", str='" + str + '\'' +
                '}';
    }
}