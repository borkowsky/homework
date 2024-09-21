package by.it_academy.homework.task4;

import java.util.Scanner;

public class Task4 {
    final static String[] tasksList = {
            "Вывести таблицу умножения",
            "Умножение двух чисел (рекурсия)",
            "Последовательность Фибоначчи",
            "Проверка положительного числа (рекурсия)",
            "* Количество «счастливых» билетов в рулоне"
    };
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        init();
    }

    private static void exercise1() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Таблица умножения числа " + i);
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + " * " + j + " = " + i * j);
            }
        }
    }

    private static void exercise2() {
        int number1 = getNumber("Введите первое число");
        int number2 = getNumber("Введите второе число");
        System.out.println("Результат умножения: " + (number1 * number2));
        int answer = getNumber("Хотите продолжить выполнение задачи? 1 - да, любое другое значение - нет");
        if (answer == 1) {
            exercise2();
        } else {
            System.out.println("Задача выполнена");
        }
    }

    private static void exercise3() {
        int number1 = getNumber("Введите первое число");
        int number2 = getNumber("Введите второе число");
        int n = getNumber("Введите число N");
        if (n > 0) {
            int n1 = number1;
            int n2 = number2;
            int sum = 0;
            int resultSum = 0;
            for (int i = 1; i <= n; i++) {
                sum = n1 + n2;
                resultSum += sum;
                System.out.println("Итерация " + i + ": " + n1 + " + " + n2 + " = " + (n1 + n2));
                n1 = n2;
                n2 = sum;
            }
            System.out.println("Результат: " + resultSum);
        } else {
            System.out.println("Введено некорректное число N");
        }
    }

    private static void exercise4() {
        int number = getNumber("Введите число");
        System.out.print("Введенное число: " + number);
        if (number != 0) {
            System.out.print(", " + (number > 0 ? "Плюс" : "Минус") + "\n");
            exercise4();
        } else {
            System.out.print(", выполнение окончено\n");
        }
    }

    private static void exercise5() {
        int luckyTicketsCount = 0;
        for (int i = 1; i <= 999999; i++) {
            int firstNumbers = i / 1000;
            int lastNumbers = i % 1000;
            int firstDigit = firstNumbers / 100;
            int secondDigit = (firstNumbers /10) % 10;
            int thirdDigit = firstNumbers % 10;
            int fourthDigit = lastNumbers / 100;
            int fifthDigit = (lastNumbers /10) % 10;
            int sixthDigit = lastNumbers % 10;
            if ((firstDigit + secondDigit + thirdDigit) == (fourthDigit + fifthDigit + sixthDigit)) {
                luckyTicketsCount++;
            }
        }
        System.out.println("Количество билетов с симметричной суммой: " + luckyTicketsCount);
    }

    private static void init() {
        System.out.println("Список задач:");
        int i = 1;
        for (String taskName : tasksList) {
            System.out.println("Задача " + i + ": " + taskName);
            i++;
        }
        selectTask();
    }

    private static void selectTask() {
        System.out.println("Введите номер задачи:");
        int taskNum = sc.nextInt();
        if (taskNum > 0 && taskNum <= tasksList.length) {
            System.out.println(tasksList[taskNum - 1]);
            switch (taskNum) {
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
                    System.out.println("Invalid taskNum");
                    break;
            }
        } else {
            System.out.println("Такой задачи нет в списке, проверка завершена");
        }

    }

    private static int getNumber(String title) {
        if (!title.isEmpty()) {
            System.out.println(title);
        }
        return sc.nextInt();
    }
}
