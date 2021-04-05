package com.ifmo.jjd.homework7.task2.animal;

import com.ifmo.jjd.homework7.task2.util.Rand;

import static com.ifmo.jjd.homework7.task2.Settings.*;

public class Cat extends FarmAnimal {
    public Cat() {
        super(Rand.getInt(CAT_WEIGHT_FROM, CAT_WEIGHT_TO),
                Rand.getInt(CAT_SPEED_FROM, CAT_SPEED_TO),
                "cat",
                Rand.getInt(CAT_HEALTH_FROM, CAT_HEALTH_TO),
                false,
                0,
                true);
    }
}
