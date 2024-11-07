package by.it_academy.homework.utils;

import java.util.*;

public class Utils {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    public static String declOfNum(int count, String[] labels) {
        int[] cases = {2, 0, 1, 1, 1, 2};
        if (count < 1) {
            return labels[2];
        }
        return labels[(count % 100 > 4 && count % 100 < 20) ? 2 : cases[Math.min(count % 10, 5)]];
    }

    public static int scanNumber(String title) {
        System.out.println(title);
        return SCANNER.nextInt();
    }

    public static int scanNumber() {
        return SCANNER.nextInt();
    }

    public static String scanString(String title) {
        System.out.println(title);
        return SCANNER.next();
    }

    public static String scanString() {
        return SCANNER.next();
    }

    public static int getRandomNumber(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static int[] getRandomNumbers(int size, int min, int max) {
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = RANDOM.nextInt(max - min + 1) + min;
        }
        return numbers;
    }

    public static <T> T getRandomArrayElement(T[] array) {
        return array[getRandomNumber(1, array.length) - 1];
    }

    private static <T> T[] shuffleArray(T[] array) {
        List<T> list = Arrays.asList(array);
        Collections.shuffle(list);
        return list.toArray(array);
    }
}
