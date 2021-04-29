package com.ifmo.jjd.homework14;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который принимает на вход мапу (например, firstTaskMap) и город (например, city),
        //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        System.out.println(getLogins(firstTaskMap, city));

        // TODO:: дан список слов (например, words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(wordFrequency(words));

        // TODO:: дана мапа (например, customerMap).
        //  Написать статический метод, который принимает на вход аргументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(customersByAge(customerMap, 23, 50));

        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту
        //  встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы
        //  по количеству букв:
        //  например, в одну группу попадут слова:
        //  3 - [the, war, jar, get, met...],
        //  в другую 2 - [on, up, no, of...] и тд
        //  результат сохранить в Map<Integer, ArrayList>
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. вывести частоту встречаемости букв английского алфавита в данном тексте. Вывести в процентах для каждой буквы

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        // 1
        System.out.println(text1(text, "uncover"));
        // 2
        System.out.println(text2(text));
        // 3
        text3(text);
        // 4
    }

    private static List<String> getLogins(Map<String, String> map, String city) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(city)) list.add(entry.getKey());
        }
        return list;
    }

    private static Map<String, Integer> wordFrequency(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            int i = map.getOrDefault(s, 0) + 1;
            map.put(s, i);
        }
        return map;
    }

    private static Map<String, Customer> customersByAge(Map<String, Customer> map, int from, int to) {
        Map<String, Customer> map1 = new HashMap<>();
        for (Map.Entry<String, Customer> mapEntry : map.entrySet()) {
            if (mapEntry.getValue().getAge() >= from && mapEntry.getValue().getAge() <= to) {
                map1.put(mapEntry.getKey(), mapEntry.getValue());
            }
        }
        return map1;
    }

    private static int text1(String text, String word) {
        int freq = 0;
        String[] words = text.toLowerCase().split(" ");
        for (String s : words) {
            if (s.equals(word)) freq++;
        }
        return freq;
    }

    private static Map<Integer, List<String>> text2(String text) {
        Map<Integer, List<String>> map = new HashMap<>();
        String[] words = text.toLowerCase().split(" ");
        for (String s : words) {
            List<String> list = map.getOrDefault(s.length(), new ArrayList<>());
            if (!list.contains(s)) list.add(s);
            map.put(s.length(), list);
        }
        return map;
    }

    private static void text3(String text) {
        String[] words = text.toLowerCase().split(" ");
        Map<String, Integer> map = wordFrequency(Arrays.asList(words));
        System.out.println(map);
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        TreeSet<Map.Entry<String, Integer>> treeSet = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int i = Integer.compare(o2.getValue(), o1.getValue());
                if (i != 0) return i;
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        treeSet.addAll(entries);
        int i = 0;
        for (Map.Entry<String, Integer> entry : treeSet) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            i++;
            if (i == 10) return;
        }
    }

}

