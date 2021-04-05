package com.ifmo.jjd.homework7.task2.animal;

import com.ifmo.jjd.homework7.task2.util.Rand;

import static com.ifmo.jjd.homework7.task2.Settings.*;

public class Chicken extends FarmAnimal {
    public Chicken() {
        super(Rand.getInt(CHICKEN_WEIGHT_FROM, CHICKEN_WEIGHT_TO),
                Rand.getInt(CHICKEN_SPEED_FROM, CHICKEN_SPEED_TO),
                "chicken",
                Rand.getInt(CHICKEN_HEALTH_FROM, CHICKEN_HEALTH_TO),
                true,
                Rand.getInt(CHICKEN_RESOURCE_FROM, CHICKEN_RESOURCE_TO),
                true);
    }
}
