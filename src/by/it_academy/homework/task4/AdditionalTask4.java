package by.it_academy.homework.task4;

import java.util.Scanner;

public class AdditionalTask4 {
    final static Scanner sc = new Scanner(System.in);
    final static String[] tasks = {
            "Вывести все двузначные целые положительные числа, в которых и цифра единиц, и цифра десятков делятся без остатка на три.",
            "Вывести серию целых положительных последовательных чисел, начиная с введенного с клавиатуры значения и до 1",
            "Вывести на экран все целые числа, начиная с N и заканчивая M.",
            "Вывести количество положительных чисел из десяти введенных с клавиатуры",
            "Вывести трехзначные положительные числа, в которых сумма квадратов первой и последней цифр равна квадрату средней цифры",
            "Вывести все делители, их сумму и количество положительного целого числа, введенного с клавиатуры",
            "Ввести с клавиатуры 30 оценок и вывести среднюю арифметическую оценку класса, число учеников, получивших неудовлетворительные оценки",
            "Ввести три целых числа и проверить, являются ли они прогрессией. Если да, то вывести последующие 10 чисел из этой прогрессии"
    };

    public static void main(String[] args) {
        init();
    }

    private static void exercise1() {
        for (int i = 1; i < 100; i++) {
            int decimals = i / 10;
            int remainder = i % 10;
            if ((decimals % 3 == 0) && (remainder % 3 == 0)) System.out.print(" " + i + " ");
        }
    }

    private static void exercise2() {
        int number = getNumber("Введите целое положительное число:");
        if (number > 0) {
            for (int i = number; i > 1; i--) {
                System.out.print(i + "+");
            }
            System.out.print(1);
        } else {
            System.out.println("Введенное число не является целым положительным числом");
        }
    }

    private static void exercise3() {
        int n = getNumber("Введите число N"), m = getNumber("Введите число M");
        int startNumber = Math.min(n, m), endNumber = Math.max(n, m);
        for (int i = startNumber; i <= endNumber; i++) {
            System.out.print(" " + i + " ");
        }
    }

    private static void exercise4() {
        String[] labels = {"первое", "второе", "третье", "четвертое", "пятое", "шестое", "седьмое", "восьмое", "девятое", "десятое"};
        int positiveCount = 0;
        for (int i = 1; i <= 10; i++) {
            int number = getNumber("Введите " + labels[i - 1] + " число");
            if (number > 0) {
                positiveCount++;
            }
        }
        System.out.println("Количество положительных чисел: " + positiveCount);
    }

    private static void exercise5() {
        for (int i = 100; i <= 999; i++) {
            int firstDigit = i / 100;
            int secondDigit = (i % 100) / 10;
            int thirdDigit = (i % 100) % 10;
            if (((firstDigit * firstDigit) + (thirdDigit * thirdDigit)) == (secondDigit * secondDigit)) {
                System.out.print(" " + i + " ");
            }
        }
    }

    private static void exercise6() {
        int number = getNumber("Введите целое положительное число");
        if (number > 0) {
            int dividersCount = 0, dividersSum = 0;
            System.out.print("Делители числа " + number + ": ");
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    System.out.print(i + ((i == number) ? "" : ", "));
                    dividersCount++;
                    dividersSum += i;
                }
            }
            System.out.print(", их количество: " + dividersCount + ", их сумма: " + dividersSum);
        } else {
            System.out.println("Введено некорректное число");
        }
    }

    private static void exercise7() {
        int gradesSum = 0;
        int negativeGrades = 0;
        for (int i = 1; i <= 30; i++) {
            int grade = getNumber("Введите оценку ученика под номером " + i);
            if (grade > 5 || grade < 0) {
                System.out.println("Введена некорректная оценка (0-5)");
                i--;
                continue;
            }
            gradesSum += grade;
            if (grade < 3) {
                negativeGrades++;
            }
        }
        System.out.println("Среднее арифметическое значение оценок класса: " + ((double) gradesSum / 30));
        System.out.println("Учеников с неудовлетворительной оценкой: " + negativeGrades);
    }

    private static void exercise8() {
        int number1 = getNumber("Введите первое число");
        int number2 = getNumber("Введите второе число");
        int number3 = getNumber("Введите третье число");
        int diff = number2 - number1;
        System.out.print("Числа " + number1 + ", " + number2 + ", " + number3 + " ");
        if ((number3 - number2) == diff) {
            System.out.print("являются последовательными членами арифметической прогрессии, следующие 10 чисел: ");
            int lastNumber = number3;
            for (int i = 1; i <= 10; i++) {
                lastNumber += diff;
                System.out.print(lastNumber + ((i == 10) ? "" : ", "));
            }
        } else {
            System.out.print("не являются последовательными членами арифметической прогрессии");
        }
    }

    private static void init() {
        System.out.println("Список задач:");
        int i = 1;
        for (String task : tasks) {
            System.out.println("Задача " + i + ": " + task);
            i++;
        }
        int taskNum = getNumber("Введите номер задачи:");
        if (taskNum > 0 && taskNum <= tasks.length) {
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
                case 6:
                    exercise6();
                    break;
                case 7:
                    exercise7();
                    break;
                case 8:
                    exercise8();
                    break;
                default:
                    System.out.println("Invalid task num");
                    break;
            }
        } else {
            System.out.println("Invalid task num");
        }
    }

    private static int getNumber(String title) {
        if (!title.isEmpty()) {
            System.out.println(title);
        }
        return sc.nextInt();
    }
}
