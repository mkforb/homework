package com.ifmo.jjd.homework7.task2;

public class AppFarm {
    public static void main(String[] args) {
        Farm farm = new Farm();
        System.out.println(farm);
        for (int i = 0; i < 730; i++) {
            System.out.println("День " + (i+1));
            if (!farm.passDay()) {
                System.out.println("Ресурсы закончились");
                break;
            }
        }
        System.out.println(farm);
    }
}
