package homework4;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        // Задание 1
        // Создать одномерный массив типа int на 20 элементов. Заполнить его рандомными значениями от 3 до 500.
        // Поменять местами минимальный и максимальный элементы.
        int[] ints1 = new int[20];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // Заполнить и найти минимальный и максимальный элементы
        for (int i = 0; i < ints1.length; i++) {
            ints1[i] = 3 + (int) (Math.random() * 498);
            if (ints1[i] < min) min = ints1[i];
            if (ints1[i] > max) max = ints1[i];
        }
        // Вывести исходный массив
        System.out.println(Arrays.toString(ints1));
        System.out.println("min = " + min + ", max = " + max);
        // Поменять местами
        for (int i = 0; i < ints1.length; i++) {
            if (ints1[i] == min) ints1[i] = max;
            else if (ints1[i] == max) ints1[i] = min;
        }
        System.out.println(Arrays.toString(ints1));

        // Задание 2
        // Дан массив целых чисел [78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90].
        // Образуйте из него два отсортированных по возрастанию массива, содержащих четные и нечетные числа.
        int[] ints2 = {78, 32, 76, 100, 0, 6301, 331, 77, 24, 2, 90};
        int lenEven = 0; // Длина массива четных чисел
        int lenOdd = 0; // Длина массива нечетных чисел
        // Определить длину массивов четных и нечетных чисел
        for (int arrElem : ints2) {
            if (arrElem % 2 == 0) lenEven++;
            else lenOdd++;
        }
        // Создать массивы
        int[] intsEven = new int[lenEven];
        int[] intsOdd = new int[lenOdd];
        int indexEven = 0;
        int indexOdd = 0;
        // Заполнить массивы
        for (int arrElem : ints2) {
            if (arrElem % 2 == 0) {
                intsEven[indexEven] = arrElem;
                indexEven++;
            } else {
                intsOdd[indexOdd] = arrElem;
                indexOdd++;
            }
        }
        // Сортировка и вывод
        Arrays.sort(intsEven);
        Arrays.sort(intsOdd);
        System.out.println(Arrays.toString(intsEven));
        System.out.println(Arrays.toString(intsOdd));

        // Задание 3
        // Дан массив целых чисел [-321, 894, -45, 782, -29, 12, -88]. Отрицательные элементы массива перенести в новый массив.
        // Размер массива должен быть равен количеству отрицательных элементов.
        int[] ints3 = {-321, 894, -45, 782, -29, 12, -88};
        int lenNegative = 0;
        int indexNegative = 0;
        // Найти длину массива с отрицательными числами
        for (int arrElem : ints3) {
            if (arrElem < 0) lenNegative++;
        }
        // Создать массив
        int[] intsNegative = new int[lenNegative];
        // Заполнить массив
        if (lenNegative > 0) {
            for (int arrElem : ints3) {
                if (arrElem < 0) {
                    intsNegative[indexNegative] = arrElem;
                    indexNegative++;
                }
            }
        }
        System.out.println(Arrays.toString(intsNegative));

        // Задание 4
        // Создать массив из чётных чисел [2, 4, 6, 8, 10, 12 ... 18, 20] и
        // вывести элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)
        intsEven = new int[10];
        for (int i = 0; i < 10; i++) {
            intsEven[i] = (i + 1) * 2;
        }
        System.out.println(Arrays.toString(intsEven));
        for (int i = intsEven.length - 1; i >= 0; i--) {
            System.out.print(intsEven[i] + " ");
        }
        System.out.println();

        // Задание 5
        // Создать массив из 11 случайных целых чисел из отрезка [-1;1], вывести массив в консоль.
        // Определить какой элемент встречается в массиве чаще всего и вывести информацию об этом в консоль.
        int[] ints5 = new int[11];
        int[] intsCount = new int[3]; // Поскольку у нас может быть только 3 значения: -1, 0, 1
        int elem = Integer.MAX_VALUE;
        for (int i = 0; i < 11; i++) {
            ints5[i] = (int) (Math.random() * 3) - 1;
            switch (ints5[i]) {
                case -1:
                    intsCount[0]++;
                    break;
                case 0:
                    intsCount[1]++;
                    break;
                case 1:
                    intsCount[2]++;
                    break;
            }
        }
        System.out.println(Arrays.toString(ints5));
        max = intsCount[0];
        for (int i = 1; i < intsCount.length; i++) {
            if (intsCount[i] > max) max = intsCount[i];
        }
        for (int i = 0; i < intsCount.length; i++) {
            if (intsCount[i] == max) {
                switch (i) {
                    case 0:
                        elem = -1;
                        break;
                    case 1:
                        elem = 0;
                        break;
                    case 2:
                        elem = 1;
                        break;
                }
                System.out.println("Элемент " + elem + " встречается чаще всего (" + max + " раз)");
            }
        }
    }
}
