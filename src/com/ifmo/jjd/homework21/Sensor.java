package com.ifmo.jjd.homework21;

import java.util.ArrayList;

/**
 * Created by User on 11.05.2021.
 */
public class Sensor {
    private int temp;
    private ArrayList<Alarm> listeners = new ArrayList<>();

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
        listeners.forEach(alarm -> alarm.tempChanged(temp));
    }

    public void addListener(Alarm listener) {
        listeners.add(listener);
    }

    public void removeListener(Alarm listener) {
        listeners.remove(listener);
    }
}
