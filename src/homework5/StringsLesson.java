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
        int len = sc.nextInt();
        String[] words = new String[len];
        Arrays.fill(words, "");
        sc.nextLine();
        int index = 0;
        while (index < words.length) {
            System.out.println("Введите слово");
            String word = sc.nextLine();
            if (word.equals("exit")) {
                break;
            } else {
                String[] wordsSort = words.clone();
                Arrays.sort(wordsSort);
                if (Arrays.binarySearch(wordsSort, word) < 0) {
                    // Добавить слово
                    words[index] = word;
                    index++;
                } else {
                    System.out.println("Слово \"" + word + "\" уже есть");
                }
            }
        }
        System.out.println(Arrays.toString(words));

        // Задание 2
        // Найти количество вхождений одной строки в другую.
        // Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза
        int occurCount = 0;
        System.out.println("Введите строку, в которой будем искать");
        String strFull = sc.nextLine();
        System.out.println("Введите строку, которую будем искать");
        String strFind = sc.nextLine();
        if (strFull.length() == 0 || strFind.length() == 0 || strFind.length() > strFull.length()) {
            System.out.println("Ошибка");
        } else {
            if (strFull.startsWith(strFind)) {
                //occurCount++;
                //strFull = strFull.substring(strFind.length() - 1);
            }
            if (strFull.endsWith(strFind)) {
                //occurCount++;
                //strFull = strFull.substring(0, );
            }
            String[] arrStr = strFull.split(strFind);
            System.out.println(Arrays.toString(arrStr));
            System.out.println(arrStr.length - 1);
        }
    }
}
