package com.ifmo.jjd.fitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class Fitness {
    private final Membership[][] members = new Membership[Zone.values().length][Settings.ZONE_CAPACITY]; // 0 - POOL, 1 - GYM, 2 - GROUP

    private boolean add(Membership membership, Zone zone) {
        Objects.requireNonNull(membership, "membership не может быть null");
        Objects.requireNonNull(zone, "zone не может быть null");
        for (int i = 0; i < members[zone.getCode()].length; i++) {
            if (members[zone.getCode()][i] == null) {
                members[zone.getCode()][i] = membership;
                return true;
            }
        }
        return false;
    }

    public boolean visitorArrive(Membership membership, Zone zone) {
        Objects.requireNonNull(membership, "membership не может быть null");
        Objects.requireNonNull(zone, "zone не может быть null");
        // Фиксируем дату и время
        LocalDateTime dtCurrent = LocalDateTime.now();
        // Проверить дату
        if (membership.getRegDate().isAfter(dtCurrent.toLocalDate())) {
            System.out.println("Абонемент еще не действует");
            return false;
        }
        if (membership.getEndDate().isBefore(dtCurrent.toLocalDate())) {
            System.out.println("Абонемент просрочен");
            return false;
        }
        // Проверить, что абонемент не заходил
        if (isMembershipInside(membership)) {
            System.out.println(membership.getVisitor() + " уже внутри");
            return false;
        }
        // Проверить допустимую зону
        if (!membership.getType().hasZone(zone)) {
            System.out.println("Абонемент не имеет доступа в " + zone);
            return false;
        }
        // Проверить время посещения
        if (!membership.getType().isOnTime(LocalTime.now())) {
            System.out.println("Абонемент не подходит по времени");
            return false;
        }
        // Впустить "абонемент"
        if (!add(membership, zone)) {
            System.out.println("Нет мест в " + zone);
            return false;
        }
        System.out.println(membership.getVisitor() + " зашел в " + zone + " " + dtCurrent.format(Settings.DTF));
        return true;
    }

    public void visitorLeave(Membership membership) {
        Objects.requireNonNull(membership, "membership не может быть null");
        // Фиксируем дату и время
        LocalDateTime dtCurrent = LocalDateTime.now();
        // Найти и выпустить "абонемент"
        for (int i = 0; i < members.length; i++) {
            for (int j = 0; j < members[i].length; j++) {
                if (members[i][j] == membership) {
                    members[i][j] = null;
                    System.out.println(membership.getVisitor() + " вышел " + dtCurrent.format(Settings.DTF));
                    return;
                }
            }
        }
        System.out.println("Абонемент не приходил");
    }

    public boolean isMembershipInside(Membership membership) {
        // Поиск абонемента среди зарегистрированных
        Objects.requireNonNull(membership, "membership не может быть null");
        for (Membership[] arr1 : members) {
            for (Membership elem1 : arr1) {
                if (elem1 == membership) return true;
            }
        }
        return false;
    }

    public void close() {
        System.out.println("Фитнес клуб закрывается");
        // Выгнать всех из фитнес клуба
        for (int i = 0; i < members.length; i++) {
            for (int j = 0; j < members[i].length; j++) {
                if (members[i][j] == null) continue;
                visitorLeave(members[i][j]);
            }
        }
    }

    public void printVisitors() {
        for (int i = 0; i < members.length; i++) {
            System.out.println("Посетители " + Zone.values()[i] + ":");
            for (int j = 0; j < members[i].length; j++) {
                if (members[i][j] == null) continue;
                System.out.println("- " + members[i][j].getVisitor());
            }
        }
    }
}
