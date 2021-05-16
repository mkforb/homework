package com.ifmo.jjd.homework10;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateTimeApp {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task1() {
        /*
        Задача 1
Самолет летит из Сиднея в Оттаву с двумя остановками в Хьюстоне и Вашингтоне.
Самолет вылетает из Сиднея (дата любая, например 16 июня 2020) в 19:00 (время местное для Сиднея).

Время в пути Сидней -  Хьюстон - 15 часов 35 минут
Время ожидания в аэропорту Хьюстона - 1 час
Время в пути  Хьюстон - Вашингтон - 2 часа 49 минут
Время ожидания в аэропорту Вашингтона - 1 час 10 минут
Время в пути Вашингтон - Оттава - 1 час 40 минут

Вывести в консоль:
Время прибытия! в аэропорт Оттавы (время местное для Оттавы)
Время вылета! из аэропорта Хьюстона (время местное для Хьюстона)
Время вылета! из аэропорта Вашингтона (время местное для Вашингтона)

Часовые пояса:
Сидней - Australia/Sydney
Хьюстон - America/Chicago
Вашингтон - America/New_York
Оттава - America/Toronto
         */
        ZoneId zoneSydney = ZoneId.of("Australia/Sydney");
        ZoneId zoneHouston = ZoneId.of("America/Chicago");
        ZoneId zoneWashington = ZoneId.of("America/New_York");
        ZoneId zoneOttawa = ZoneId.of("America/Toronto");

        HourMinute flightToHouston = new HourMinute(15, 35);
        HourMinute pauseHouston = new HourMinute(1, 0);
        HourMinute flightToWashington = new HourMinute(2, 49);
        HourMinute pauseWashington = new HourMinute(1, 10);
        HourMinute flightToOttawa = new HourMinute(1, 48);

        ZonedDateTime start = ZonedDateTime.of(LocalDateTime.parse("2020-06-16T19:00:00"), zoneSydney);
        ZonedDateTime arriveHouston = addHourMinute(start, flightToHouston, zoneHouston);
        ZonedDateTime departureHouston = addHourMinute(arriveHouston, pauseHouston, null);
        ZonedDateTime arriveWashington = addHourMinute(departureHouston, flightToWashington, zoneWashington);
        ZonedDateTime departureWashington = addHourMinute(arriveWashington, pauseWashington, null);
        ZonedDateTime arriveOttawa = addHourMinute(departureWashington, flightToOttawa, zoneOttawa);

        System.out.println("Прибытие в Оттаву - " + arriveOttawa);
        System.out.println("Вылет из Хьюстона - " + departureHouston);
        System.out.println("Вылет из Вашингтона - " + departureWashington);
    }

    private static ZonedDateTime addHourMinute(ZonedDateTime zdt, HourMinute hm, ZoneId zoneId) {
        ZonedDateTime newZdt = zdt.plusHours(hm.getHours()).plusMinutes(hm.getMinutes());
        if (zoneId != null) {
            newZdt = newZdt.withZoneSameInstant(zoneId);
        }
        return newZdt;
    }

    private static void task2() {
        /*
        Задача 2
Есть три рабочие смены :
с 7:00 до 15:00 утренняя
с 15:00 до 23:00 дневная
с 23:00 до 7:00 ночная
Определить, какая сейчас смена (относительно текущего времени)
         */
        LocalTime morningStart = LocalTime.parse("07:00:00");
        LocalTime dayStart = LocalTime.parse("15:00:00");
        LocalTime nightStart = LocalTime.parse("23:00:00");
        LocalTime toCheck = LocalTime.now();
        System.out.print(toCheck + " - ");
        if (toCheck.equals(morningStart) || toCheck.isAfter(morningStart) && toCheck.isBefore(dayStart)) {
            System.out.println("Утренняя смена");
        } else if (toCheck.equals(dayStart) || toCheck.isAfter(dayStart) && toCheck.isBefore(nightStart)) {
            System.out.println("Дневная смена");
        } else if (toCheck.equals(nightStart) || toCheck.isAfter(nightStart) || toCheck.isBefore(morningStart)) {
            System.out.println("Ночная смена");
        } else {
            System.out.println("Ошибка");
        }
    }

    private static void task3() {
        /*
        Задача 3
Допустим, наше последнее занятие состоится 16 июня 2021 года.
Сколько занятий осталось, если они проходят 3 раза в неделю (пн, ср, пт)?
Когда состоится защита диплома, если на подготовку дается 2 недели?
         */
        LocalDate last = LocalDate.parse("2021-06-16");
        LocalDate curr = LocalDate.now();
        int count = 0;
        if (isClassDay(curr) && LocalTime.now().isBefore(LocalTime.parse("18:40"))) {
            // Если сегодня день занятий и время еще до 18:40, сегодняшнее занятие еще впереди
            count++;
        }
        curr = curr.plusDays(1);
        while (curr.isBefore(last) || curr.equals(last)) {
            if (isClassDay(curr)) {
                count++;
            }
            curr = curr.plusDays(1);
        }
        System.out.println("Осталось занятий " + count);
        LocalDate diploma = last.plusWeeks(2);
        System.out.println("Защита диплома состоится " + diploma);
    }

    private static boolean isClassDay(LocalDate ld) {
        switch (ld.getDayOfWeek()) {
            case MONDAY:
            case WEDNESDAY:
            case FRIDAY:
                return true;
        }
        return false;
    }
}
