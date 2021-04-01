package com.ifmo.jjd.homework7.task2;

public class Farmer {
    private int resource;

    public Farmer() {
        resource = Settings.START_RESOURCE;
    }

    public int getResource() {
        return resource;
    }

    public void spendResource(int count) {
        if (resource > count) {
            resource -= count;
        } else {
            resource = 0;
        }
        System.out.println(this + " тратит " + count + " ресурсов");
    }

    public boolean collectResource(FarmAnimal animal) {
        if (animal.getResource() <= 0) {
            // Животное не может давать ресурс
            return false;
        }
        resource += animal.getResource();
        System.out.println(this + " собрал ресурс с " + animal);
        return true;
    }

    public boolean eatAnimal(FarmAnimal animal) {
        if (!animal.isEdible() || !animal.isOnFarm()) {
            // Животное не пригодно в пищу
            return false;
        }
        resource += animal.getWeight();
        animal.setOnFarm(false);
        System.out.println(this + " съел " + animal);
        return true;
    }

    public void chaseAnimal(WildAnimal animal) {
        animal.chase();
        System.out.println("Фермер прогнал " + animal);
    }

    public void feedAnimal(FarmAnimal animal) {
        if (animal.eat()) {
            System.out.println("Фермер покормил " + animal);
        }
    }

    @Override
    public String toString() {
        return "Farmer{" + resource + "}";
    }
}
