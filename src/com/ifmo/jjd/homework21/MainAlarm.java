package com.ifmo.jjd.homework21;

/**
 * Created by User on 11.05.2021.
 */
public class MainAlarm implements Alarm {
    private final int tempFrom;
    private final int tempTo;
    private final String text;
    private boolean reached = false;

    public MainAlarm(int tempFrom, int tempTo, String text) {
        this.tempFrom = tempFrom;
        this.tempTo = tempTo;
        this.text = text;
    }

    @Override
    public void tempChanged(int temp) {
        if (temp >= tempFrom && temp <= tempTo) {
            if (!reached) {
                reached = true;
                System.out.println(text);
            }
        } else {
            reached = false;
        }
    }
}
