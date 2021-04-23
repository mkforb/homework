package com.ifmo.jjd.homework16.pupils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PupilTask {
    public static void main(String[] args) {

        System.out.println(getStream().collect(Collectors.toList()));

        // Используя Stream API:

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        System.out.println("Задание 1");
        Map<Pupil.Gender, ArrayList<Pupil>> mapByGender = getStream()
                .collect(Collectors.groupingBy(pupil -> pupil.getGender(), Collectors.toCollection(ArrayList::new)));
        System.out.println(mapByGender);

        // 2. Найти средний возраст учеников
        getStream().forEach(pupil -> System.out.print(pupil.getAge() + " "));
        System.out.println();
        System.out.println("Задание 2");
        Double avgAge = getStream()
                .map(pupil -> pupil.getAge())
                .collect(Collectors.averagingLong(value -> value));
        System.out.println(avgAge);
        // Другой вариант:
        avgAge = getStream()
                .mapToInt(pupil -> pupil.getAge())
                .average().orElse(0);
        System.out.println(avgAge);

        // 3. Найти самого младшего ученика
        System.out.println("Задание 3");
        Pupil minByAge = getStream()
                .min(Comparator.comparing(pupil -> pupil.getAge()))
                .get();
        System.out.println(minByAge);

        // 4. Найти самого взрослого ученика
        System.out.println("Задание 4");
        Pupil maxByAge = getStream()
                .max(Comparator.comparing(pupil -> pupil.getAge()))
                .get();
        System.out.println(maxByAge);

        // 5. Собрать учеников в группы по году рождения
        System.out.println("Задание 5");
        Map<Integer, List<Pupil>> groupByYear = getStream()
                .collect(Collectors.groupingBy(pupil -> pupil.getBirth().getYear()));
        System.out.println(groupByYear);

        // 6. Оставить учеников с неповторяющимися именами,
        // имена и дату рождения оставшихся вывести в консоль.
        // Например, [Иван, Александра, Ольга, Иван, Ольга] -> [Иван, Александра, Ольга]
        System.out.println("Задание 6");
        getStream()
                .collect(Collectors.groupingBy(pupil -> pupil.getName()))
                .forEach((s, pupils) -> System.out.println(pupils.get(0).getName() + " " + pupils.get(0).getBirth()));

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        System.out.println("Задание 7");
        List<Pupil> sorted = getStream()
                .sorted(Comparator.comparing(Pupil::getGender).thenComparing(Pupil::getBirth).thenComparing((o1, o2) -> - o1.getName().compareTo(o2.getName())))
                .collect(Collectors.toList());
        System.out.println(sorted);
        // Другой вариант:
        sorted = getStream().collect(Collectors.toList());
        sorted.sort(Comparator.comparing(Pupil::getGender)
                .thenComparing(Pupil::getBirth)
                .thenComparing(Comparator.comparing(Pupil::getName).reversed()));
        System.out.println(sorted);

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        System.out.println("Задание 8");
        getStream()
                .filter(pupil -> pupil.getAge() >= 10 && pupil.getAge() <= 16)
                .forEach(System.out::println);

        // 9. Собрать в список всех учеников с именем=someName
        System.out.println("Задание 9");
        List<Pupil> listSomeName = getStream()
                .filter(pupil -> pupil.getName().equals("Вася"))
                .collect(Collectors.toList());
        System.out.println(listSomeName);

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        System.out.println("Задание 10");
        Map<Pupil.Gender, Integer> mapGenderAges = getStream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.summingInt(Pupil::getAge)));
        System.out.println(mapGenderAges);
    }

    private static Stream<Pupil> getStream() {
        return Stream.of(
                new Pupil("Вася", Pupil.Gender.MALE, LocalDate.parse("2005-05-25")),
                new Pupil("Петя", Pupil.Gender.MALE, LocalDate.parse("2006-02-12")),
                new Pupil("Лена", Pupil.Gender.FEMALE, LocalDate.parse("2004-03-01")),
                new Pupil("Виталик", Pupil.Gender.MALE, LocalDate.parse("2004-09-25")),
                new Pupil("Вася", Pupil.Gender.MALE, LocalDate.parse("2006-10-01")),
                new Pupil("Нина", Pupil.Gender.FEMALE, LocalDate.parse("2004-03-01"))
        );
    }
}