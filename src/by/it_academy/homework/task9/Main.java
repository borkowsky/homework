package by.it_academy.homework.task9;

import by.it_academy.homework.utils.ExerciseSelector;
import by.it_academy.homework.utils.Utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String[] tasks = new String[]{
                "Показать номера символов, совпадающих с последним символом строки.",
                "Определить, является ли слово палиндромом.",
                "Найдите количество вхождения слова 'test' в строке.",
                "Регулярное выражение для поиска годов между 1977 и 1982.",
                "Регулярное выражение для валидации IP адреса."
        };
        ExerciseSelector exerciseSelector = new ExerciseSelector(tasks);
        switch (exerciseSelector.selectExercise()) {
            case 1:
                exercise1();
                break;
            case 2:
                exercise2();
                break;
            case 3:
                exercise3();
                break;
            case 4:
                exercise4();
                break;
            case 5:
                exercise5();
                break;
            default:
                System.out.println("Invalid task number provided!");
                break;
        }
    }

    public static void exercise1() {
        String str = Utils.scanString("Введите строку для поиска:");
        char ch = str.charAt(str.length() - 1);
        Pattern pattern = Pattern.compile(String.valueOf(ch));
        System.out.println("Последний символ: " + ch);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            if ((matcher.start() + 1) == str.length()) {
                break;
            }
            System.out.format("Символ %s найден на позиции %d%n", ch, (matcher.start() + 1));
        }
    }

    public static void exercise2() {
        String word = Utils.scanString("Введите слово для проверки:");
        char[] chars = word.toCharArray();
        boolean isPalindrome = true;
        for (int i = 0, j = chars.length - 1; j >= i; i++, j--) {
            if (!isPalindrome) {
                break;
            }
            isPalindrome = chars[i] == chars[j];
        }
        System.out.format("Слово %s %s палиндромом%n", word, (isPalindrome ? "является" : "не является"));
    }

    public static void exercise3() {
        String str = "Lorem Ipsum test is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been test the industry's standard dummy test text ever since the 1500s, " +
                "when an unknown printer test took a galley of type and scrambled it to make a type specimen book.";
        Pattern pattern = Pattern.compile("test");
        Matcher matcher = pattern.matcher(str);
        int totalMatches = 0;
        while (matcher.find()) {
            totalMatches++;
        }
        System.out.format("Количество вхождений слова \"test\" в строку: %d%n", totalMatches);
    }

    public static void exercise4() {
        String years = "1975 1976 1977 1978 1979 1980 1981 1982 1983 1984";
        Pattern pattern = Pattern.compile("(197[7-9])|(198[0-2])"); // 1977 - 1982
        Matcher matcher = pattern.matcher(years);
        System.out.print("Найдены совпадения: ");
        while (matcher.find()) {
            System.out.print(matcher.group() + " ");
        }
    }

    public static void exercise5() {
        String[] addresses = new String[]{
                "0.62.126.123",
                "185.170.115.22",
                "181.92.12.25",
                "20.28.-100.156", // invalid
                "75.60.2.56",
                "244.105.221.182",
                "172.255.800.236", // invalid
                "233.244.122.69",
                "128.88.217.127",
                "118.24.221.111",
                "172.494.170.236", // invalid
                "233.244.892.69", // invalid
        };
        String pattern = "^(([01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5])\\.){3}[01]?[0-9][0-9]?|2[0-4][0-9]|25[0-5]$";
        for (String address : addresses) {
            System.out.format("IP адрес %s %s%n", address, address.matches(pattern) ? "корректный" : "не корректный");
        }
    }
}
