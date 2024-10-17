package by.it_academy.homework.utils;

import java.util.Random;
import java.util.Scanner;

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

    public static int getNumber(String title) {
        System.out.println(title);
        return SCANNER.nextInt();
    }

    public static int getNumber() {
        return SCANNER.nextInt();
    }

    public static int getRandomNumber(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static String getRandomArrayElement(String[] array) {
        return array[getRandomNumber(1, array.length) - 1];
    }
}
