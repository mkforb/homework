package homework2;

import java.util.Scanner;

public class DecisionMaking {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер задания");
        byte taskNum = in.nextByte();

        switch (taskNum) {
            case 1:
                // Задание 1
                byte count = 75;
                if (count <= 100 && count >= 90) {
                    System.out.println("Отлично");
                } else if (count <= 89 && count >= 60) {
                    System.out.println("Хорошо");
                } else if (count <= 59 && count >= 40) {
                    System.out.println("Удовлетворительно");
                } else if (count <= 39 && count >= 0) {
                    System.out.println("Попробуйте в следующий раз");
                } else {
                    System.out.println("Введены некорректные данные");
                }
                break;

            case 2:
                // Задание 2
                System.out.println("Введите первый операнд");
                int a1 = in.nextInt();
                System.out.println("Введите второй операнд");
                int a2 = in.nextInt();
                System.out.println("Введите оператор");
                byte oper = in.nextByte();
                switch (oper) {
                    case 3:
                        System.out.println(a1 + " + " + a2 + " = " + (a1 + a2));
                        break;
                    case 5:
                        System.out.println(a1 + " - " + a2 + " = " + (a1 - a2));
                        break;
                    case 7:
                        System.out.println(a1 + " * " + a2 + " = " + (a1 * a2));
                        break;
                    case 9:
                        System.out.println(a1 + " / " + a2 + " = " + ((double) a1 / a2));
                        break;
                    default:
                        System.out.println("Введен некорректный оператор");
                }
                break;

            case 3:
                // Задание 3
                System.out.println("Введите кол-во тарелок");
                int plates = in.nextInt();
                System.out.println("Введите кол-во моющего средства");
                double detergent = in.nextDouble();
                while (plates >= 1 && detergent >= 0.5) {
                    System.out.println("Осталось " + plates + " тарелок и " + detergent + " моющего средства");
                    plates -= 1;
                    detergent -= 0.5;
                }
                if (plates == 0 && detergent == 0) {
                    System.out.println("Не осталось ни тарелок, ни моющего средства");
                } else if (plates == 0) {
                    System.out.println("Осталось " + detergent + " моющего средства");
                } else {
                    System.out.println("Осталось " + plates + " тарелок");
                }
                break;

            case 4:
                // Задание 4
                byte numProg = 8;
                while (true) {
                    System.out.println("Введите число от 1 до 9");
                    byte numUser = in.nextByte();
                    if (numUser < 0 || numUser > 9) {
                        System.out.println("Введено некорректное число");
                    } else if (numProg > numUser) {
                        System.out.println("загаданное число больше");
                    } else if (numProg < numUser) {
                        System.out.println("загаданное число меньше");
                    } else if (numProg == numUser) {
                        System.out.println("Вы угадали");
                        break;
                    } else if (numUser == 0) {
                        System.out.println("Выход из программы");
                        break;
                    }
                }
                break;

            case 5:
                // Задание 5
                int random = 10 + (int) ( Math.random() * 491 );
                if (random > 25 && random < 200) {
                    System.out.println("Число " + random + " содержится в интервале (25;200)");
                } else {
                    System.out.println("Число " + random + " не содержится в интервале (25;200)");
                }
                break;

            case 6:
                // Задание 6
                int x1 = 1, x2 = 100;
                int x;
                System.out.println("Загадайте число от 1 до 100");
                while (x1 <= x2) {
                    x = x1 + ( x2 - x1 ) / 2;
                    System.out.println("Загаданное число равно " + x + "? (НЕТ - 0, ДА - 1)");
                    byte answ = in.nextByte();
                    if (answ == 1) {
                        break;
                    } else if (answ == 0) {
                        System.out.println("Загаданное число больше " + x + "? (НЕТ - 0, ДА - 1)");
                        answ = in.nextByte();
                        if (answ == 1) {
                            x1 = x + 1;
                        } else if (answ == 0) {
                            x2 = x - 1;
                        } else {
                            // ToDo: Если ответ не 0 и не 1
                            System.out.println("Дан некорректный ответ");
                            break;
                        }
                    } else {
                        // ToDo: Если ответ не 0 и не 1
                        System.out.println("Дан некорректный ответ");
                        break;
                    }
                    System.out.println(x1 + " " + x2);
                }
                break;

            default:
                System.out.println("Некорректный номер задания");
        }
    }
}
