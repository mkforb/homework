package com.ifmo.jjd.homework21;

import java.util.Scanner;

/**
 * Created by User on 11.05.2021.
 */
public class App {
    public static void main(String[] args) {
        Sensor tempSensor = new Sensor();
        tempSensor.addListener(new AbstractAlarm(100, 299, "Green"));
        tempSensor.addListener(new AbstractAlarm(300, 599, "Green, Yellow"));
        tempSensor.addListener(new AbstractAlarm(600, 9999, "Green, Yellow, Red"));
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите температуру:");
            int temp = scanner.nextInt();
            if (temp < -273) break;
            tempSensor.setTemp(temp);
        }
    }
}
