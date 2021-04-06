package com.ifmo.jjd.fitness;

public class Fitness {
    private final Subscription[] subscriptionsPool = new Subscription[20];
    private final Subscription[] subscriptionsGym = new Subscription[20];
    private final Subscription[] subscriptionsGroup = new Subscription[20];

    private boolean add(Subscription subscription, Zone zone) {
        switch (zone) {
            case POOL:
                for (int i = 0; i < subscriptionsPool.length; i++) {
                    if (subscriptionsPool[i] == null) {
                        subscriptionsPool[i] = subscription;
                        return true;
                    }
                }
                break;
            case GYM:
                for (int i = 0; i < subscriptionsGym.length; i++) {
                    if (subscriptionsGym[i] == null) {
                        subscriptionsGym[i] = subscription;
                        return true;
                    }
                }
                break;
            case GROUP:
                for (int i = 0; i < subscriptionsGroup.length; i++) {
                    if (subscriptionsGroup[i] == null) {
                        subscriptionsGroup[i] = subscription;
                        return true;
                    }
                }
                break;
        }
        return false;
    }

    public boolean visitorArrive(Subscription subscription, Zone zone) {
        if (!subscription.getType().hasZone(zone)) {
            System.out.println("Абонемент не имеет доступа в " + zone);
            return false;
        }
        if (!add(subscription, zone)) {
            System.out.println("Нет мест в " + zone);
            return false;
        }
        System.out.println("Абонемент зашел");
        return true;
    }

    public void visitorLeave(Subscription subscription) {
        for (int i = 0; i < subscriptionsPool.length; i++) {
            if (subscriptionsPool[i] == subscription) {
                subscriptionsPool[i] = null;
                System.out.println("Абонемент вышел");
                return;
            }
        }
        for (int i = 0; i < subscriptionsGym.length; i++) {
            if (subscriptionsGym[i] == subscription) {
                subscriptionsGym[i] = null;
                System.out.println("Абонемент вышел");
                return;
            }
        }
        for (int i = 0; i < subscriptionsGroup.length; i++) {
            if (subscriptionsGroup[i] == subscription) {
                subscriptionsGroup[i] = null;
                System.out.println("Абонемент вышел");
                return;
            }
        }
        System.out.println("Абонемент не приходил");
    }

    public void close() {

    }
}
