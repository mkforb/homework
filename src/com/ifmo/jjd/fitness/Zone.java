package com.ifmo.jjd.fitness;

public enum Zone {
    POOL(0, "бассейн"),
    GYM(1, "тренажерный зал"),
    GROUP(2, "групповые занятия");

    private final int code;
    private final String title;

    Zone(int code, String title) {
        this.code = code;
        this.title = title;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return title;
    }
}
