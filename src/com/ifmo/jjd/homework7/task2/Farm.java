package com.ifmo.jjd.homework7.task2;

import com.ifmo.jjd.homework7.task2.animal.FarmAnimal;
import com.ifmo.jjd.homework7.task2.animal.WildAnimal;
import com.ifmo.jjd.homework7.task2.util.Rand;

import java.util.Arrays;

public class Farm {
    private final Farmer farmer;
    private final FarmAnimal[] farmAnimals;
    private final WildAnimal[] wildAnimals;

    public Farm() {
        farmer = new Farmer();
        farmAnimals = new FarmAnimal[Settings.FARM_ANIMALS_COUNT];
        for (int i = 0; i < farmAnimals.length; i++) {
            farmAnimals[i] = FarmAnimal.get();
        }
        // ToDo: Как формируется массив с дикими животными?
        wildAnimals = new WildAnimal[Rand.getInt(15, 20)];
        for (int i = 0; i < wildAnimals.length; i++) {
            wildAnimals[i] = WildAnimal.get();
        }
    }

    public boolean passDay() {
        // Фермер тратит ежедневные ресурсы
        farmer.spendResource(Settings.DAY_RESOURCE);
        if (farmer.getResource() == 0) return false;
        int indexWild = Rand.getInt(wildAnimals.length);
        // Сделаем несколько попыток найти дикое животное, которое еще не прогоняли 3 раза
        for (int i = 0; i < 10; i++) {
            if (wildAnimals[i].comeToFarm()) {
                break;
            }
            indexWild = Rand.getInt(wildAnimals.length);
        }
        int indexFarm = Rand.getInt(farmAnimals.length);
        // Сделаем несколько попыток найти доступное домашнее животное
        for (int i = 0; i < 10; i++) {
            if (farmAnimals[indexFarm].isOnFarm()) {
                break;
            }
            indexFarm = Rand.getInt(farmAnimals.length);
        }
        if (wildAnimals[indexWild].comeToFarm()) {
            System.out.println(wildAnimals[indexWild] + " пришел на ферму");
            // Если дикое животное пришло на ферму
            if (Rand.getInt(2) == 0) {
                // Дикое животное атакует домашнее
                wildAnimals[indexWild].attack(farmAnimals[indexFarm]);
            } else {
                // Фермер прогоняет дикое животное
                farmer.chaseAnimal(wildAnimals[indexWild]);
            }
        }
        // Фермер кормит домашних животных
        for (int i = 0; i < farmAnimals.length; i++) {
            farmer.feedAnimal(farmAnimals[i]);
        }
        // Фермер собирает ресурсы
        boolean resourceCollected = false;
        for (int i = 0; i < farmAnimals.length; i++) {
            if (farmer.collectResource(farmAnimals[i])) {
                // Фермер собрал ресурсы
                resourceCollected = true;
            }
        }
        if (!resourceCollected) {
            // Не удалось ничего собрать
            for (int i = 0; i < farmAnimals.length; i++) {
                if (farmer.eatAnimal(farmAnimals[i])) {
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "farmer=" + farmer +
                ", farmAnimals=" + Arrays.toString(farmAnimals) +
                ", wildAnimals=" + Arrays.toString(wildAnimals) +
                '}';
    }
}
