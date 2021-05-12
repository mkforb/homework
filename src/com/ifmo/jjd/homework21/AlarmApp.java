package com.ifmo.jjd.homework21;

import java.util.Scanner;

/**
 * Created by User on 11.05.2021.
 */
public class AlarmApp {
    public static void main(String[] args) {
        Sensor tempSensor = new Sensor();
        tempSensor.addListener(new MainAlarm(100, 299, "Green"));
        tempSensor.addListener(new MainAlarm(300, 599, "Green, Yellow"));
        tempSensor.addListener(new MainAlarm(600, 9999, "Green, Yellow, Red"));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите температуру:");
            int temp = scanner.nextInt();
            if (temp < -273) break;
            tempSensor.setTemp(temp);
        }
    }
}
