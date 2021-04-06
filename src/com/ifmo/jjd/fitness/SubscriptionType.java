package com.ifmo.jjd.fitness;

import java.time.LocalTime;

public enum SubscriptionType {
    ONCE(new Zone[]{Zone.POOL, Zone.GYM}, LocalTime.of(8, 0), LocalTime.of(22, 0)),
    DAY(new Zone[]{Zone.GYM, Zone.GROUP}, LocalTime.of(8, 0), LocalTime.of(16, 0)),
    FULL(new Zone[]{Zone.POOL, Zone.GYM, Zone.GROUP}, LocalTime.of(8, 0), LocalTime.of(22, 0));

    private final Zone[] zones;
    private final LocalTime timeFrom;
    private final LocalTime timeTo;

    SubscriptionType(Zone[] zones, LocalTime timeFrom, LocalTime timeTo) {
        this.zones = zones;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public boolean hasZone(Zone zone) {
        for (Zone elem : zones) {
            if (elem == zone) return true;
        }
        return false;
    }
}
