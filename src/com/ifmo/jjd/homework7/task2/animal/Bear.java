package com.ifmo.jjd.homework7.task2.animal;

import com.ifmo.jjd.homework7.task2.util.Rand;

import static com.ifmo.jjd.homework7.task2.Settings.*;

public class Bear extends WildAnimal {
    public Bear() {
        super(Rand.getInt(BEAR_WEIGHT_FROM, BEAR_WEIGHT_TO),
                Rand.getInt(BEAR_SPEED_FROM, BEAR_SPEED_TO),
                "bear",
                Rand.getInt(BEAR_STRENGTH_FROM, BEAR_STRENGTH_TO));
    }
}
