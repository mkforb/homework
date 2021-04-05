package com.ifmo.jjd.homework7.task2.animal;

import com.ifmo.jjd.homework7.task2.util.Rand;

import static com.ifmo.jjd.homework7.task2.Settings.*;

public class Wolf extends WildAnimal {
    public Wolf() {
        super(Rand.getInt(WOLF_WEIGHT_FROM, WOLF_WEIGHT_TO),
                Rand.getInt(WOLF_SPEED_FROM, WOLF_SPEED_TO),
                "wolf",
                Rand.getInt(WOLF_STRENGTH_FROM, WOLF_STRENGTH_TO));
    }
}
