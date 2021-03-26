package homework5;

import java.util.Arrays;
import java.util.Scanner;

public class StringsLesson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Задание 1
        // Задать массив на n слов. В цикле считывать с консоли слова (scanner.nextLine()),
        // и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
        // В итоге в массиве будут только уникальные слова.
        // Выход из программы по слову exit (его в массив не добавлять) или если массив заполнен
        // Перед завершением программы, вывести получившийся массив в консоль

        System.out.println("Укажите кол-во слов");
        int len = Integer.parseInt(sc.nextLine());
        String[] words = new String[len];
        int index = 0;
        while (index < words.length) {
            System.out.println("Введите слово");
            String word = sc.nextLine().trim();
            if (word.equals("exit")) break;
            for (int i = 0; i < words.length; i++) {
                if (words[i] == null) {
                    words[i] = word;
                    index++;
                    break;
                } else if (words[i].equals(word)) {
                    System.out.println("Слово \"" + word + "\" уже есть");
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(words));

        // Задание 2
        // Найти количество вхождений одной строки в другую.
        // Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза

        int occurCount = 0; // Кол-во вхождений
        String str = "";
        String find = "";
        while (str.equals("")) {
            System.out.println("Введите строку, в которой будем искать");
            str = sc.nextLine().trim();
        }
        while (find.equals("")) {
            System.out.println("Введите строку, которую будем искать");
            find = sc.nextLine().trim();
        }
        if (find.length() <= str.length()) {
            while (str.startsWith(find)) {
                occurCount++;
                str = str.substring(find.length());
            }
            while (str.endsWith(find)) {
                occurCount++;
                str = str.substring(0, str.length() - find.length());
            }
            String[] arrStr = str.split(find);
            occurCount += arrStr.length - 1;
        }
        System.out.println(occurCount);

        // Задание 3
        // Написать функцию, которая проверяет, является ли строка палиндромом.
        // Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам
        // как слева направо, так и справа налево.
        // Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром

        str = "";
        while (str.equals("")) {
            System.out.println("Введите строку для проверки на палиндром");
            str = sc.nextLine().trim();
        }
        str = str.replaceAll(" ", "");
        String strRev = (new StringBuilder(str)).reverse().toString();

        /*str = str.replaceAll(" ", "").toLowerCase();
        // Поделить строку пополам
        int mod = str.length() % 2;
        String str1 = str.substring(0, str.length() / 2);
        String str2 = str.substring(str.length() / 2 + mod);
        // Преобразовать две строки в массивы
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        // Сравнить массивы
        boolean isPalindrom = true;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[chars2.length - i - 1]) {
                isPalindrom = false;
                break;
            }
        }*/
        if (str.equalsIgnoreCase(strRev)) {
            System.out.println("Строка является палиндромом");
        } else {
            System.out.println("Строка не является палиндромом");
        }

        // Задание 4
        // Заменить все буквы в слове на строчные, а первую букву на заглавную
        // Например, дано hello, получаем Hello / дано HeLLO, получаем Hello

        str = "";
        while (str.equals("")) {
            System.out.println("Введите строку для преобразования");
            str = sc.nextLine().trim();
        }
        str = str.toLowerCase();
        String newStr = str.substring(0, 1).toUpperCase() + str.substring(1);
        System.out.println(newStr);

        // Задание 5
        // Вводится с клавиатуры массив слов. Определить, сколько слов начинается на определенную букву.

        occurCount = 0;
        System.out.println("Введите массив слов через пробел");
        str = "";
        while (str.equals("")) {
            str = sc.nextLine().trim();
        }
        str = str.toUpperCase();
        words = str.split(" ");
        System.out.println("На какую букву будем искать слова?");
        str = "";
        while (str.equals("")) {
            // ToDo: String или char?
            str = sc.nextLine();
            if (str.length() > 1) {
                System.out.println("Введите одну букву");
                str = "";
            }
            // ToDo: Проверить что введена буква, а не символ. По коду unicode?
        }
        char[] chars1 = str.toUpperCase().toCharArray();
        for (String word : words) {
            if (word.length() > 0) {
                char[] chars2 = word.toCharArray();
                if (chars1[0] == chars2[0]) occurCount++;
            }
        }
        System.out.println(occurCount);
    }
}
