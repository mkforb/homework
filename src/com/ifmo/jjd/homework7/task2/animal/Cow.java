package com.ifmo.jjd.homework7.task2.animal;

import com.ifmo.jjd.homework7.task2.util.Rand;

import static com.ifmo.jjd.homework7.task2.Settings.*;

public class Cow extends FarmAnimal {
    public Cow() {
        super(Rand.getInt(COW_WEIGHT_FROM, COW_WEIGHT_TO),
                Rand.getInt(COW_SPEED_FROM, COW_SPEED_TO),
                "cow",
                Rand.getInt(COW_HEALTH_FROM, COW_HEALTH_TO),
                true,
                Rand.getInt(COW_RESOURCE_FROM, COW_RESOURCE_TO),
                true);
    }
}
