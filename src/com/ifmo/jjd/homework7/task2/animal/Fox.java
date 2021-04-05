package com.ifmo.jjd.homework7.task2.animal;

import com.ifmo.jjd.homework7.task2.util.Rand;

import static com.ifmo.jjd.homework7.task2.Settings.*;

public class Fox extends WildAnimal {
    public Fox () {
        super(Rand.getInt(FOX_WEIGHT_FROM, FOX_WEIGHT_TO),
                Rand.getInt(FOX_SPEED_FROM, FOX_SPEED_TO),
                "fox",
                Rand.getInt(FOX_STRENGTH_FROM, FOX_STRENGTH_TO));
    }
}
