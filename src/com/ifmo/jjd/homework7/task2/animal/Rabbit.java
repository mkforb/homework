package com.ifmo.jjd.homework7.task2.animal;

import com.ifmo.jjd.homework7.task2.util.Rand;

import static com.ifmo.jjd.homework7.task2.Settings.*;

public class Rabbit extends FarmAnimal {
    public Rabbit() {
        super(Rand.getInt(RABBIT_WEIGHT_FROM, RABBIT_WEIGHT_TO),
                Rand.getInt(RABBIT_SPEED_FROM, RABBIT_SPEED_TO),
                "rabbit",
                Rand.getInt(RABBIT_HEALTH_FROM, RABBIT_HEALTH_TO),
                true,
                0,
                true);
    }
}
