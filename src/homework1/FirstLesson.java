package homework1;

public class FirstLesson {
    public static void main(String[] args) {
        // Задание 2
        long start = 10;
        long end = 20;
        long between = (start < end) ? (end - start) : -1;
        System.out.println(between);

        // Задание 3
        byte x = 79;
        int sum1 = ( x / 10 ) + ( x % 10 );
        System.out.println(sum1);

        // Задание 4
        short y = 678;
        int sum2 = ( y / 100 ) + ( ( y % 100 ) / 10 ) + ( ( y % 100 ) % 10 );
        System.out.println(sum2);
    }
}
