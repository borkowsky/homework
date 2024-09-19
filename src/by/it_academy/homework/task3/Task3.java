package by.it_academy.homework.task3;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Задание 1. Получаем составные части трехзначного числа");
        exercise1();
        System.out.println("Задание 2. Получаем степень четности положительного трехначного числа");
        exercise2();
        System.out.println("Задание 3. Проверяем симметричность трехзначного числа");
        exercise3();
        System.out.println("Задание 4. Проверяем, могут ли указанные три числа быть сторонами треугольника");
        exercise4();
        System.out.println("Задание 5. Определяем сезон по введенному порядковому номеру месяца");
        exercise5();
    }

    private static void exercise1() {
//        Напишите класс, который принимает с клавиатуры целое положительное трехзначное число и выводит его на экран в «полном виде»: например, для числа 364 это будет выглядеть как 300+60+4.
        int integer = scanInteger("Введите трехзначное число");
        if (isValidNumber(integer)) {
            int firstDigit = getFirstDigit(integer);
            int secondDigit = getSecondDigit(integer);
            int thirdDigit = getThirdDigit(integer);
            System.out.println("Число " + integer + " состоит из " + (firstDigit * 100) + "+" + (secondDigit * 10) + "+" + thirdDigit);
        } else {
            System.out.println("Вы ввели некорректное число");
        }
    }

    private static void exercise2() {
        int integer = scanInteger("Введите трехзначное число (100-999)");
        if (isValidNumber(integer)) {
            int firstDigit = getFirstDigit(integer);
            int secondDigit = getSecondDigit(integer);
            int thirdDigit = getThirdDigit(integer);
            int parity = 0;
            if (isOdd(firstDigit)) {
                parity++;
            }
            if (isOdd(secondDigit)) {
                parity++;
            }
            if (isOdd(thirdDigit)) {
                parity++;
            }
            System.out.println("Степень четности числа " + integer + " равна " + parity);
        } else {
            System.out.println("Вы ввели некорректное число");
        }
    }

    private static void exercise3() {
        int integer = scanInteger("Введите трехзначное число (100-999)");
        if (isValidNumber(integer)) {
            int firstDigit = getFirstDigit(integer);
            int thirdDigit = getThirdDigit(integer);
            if (firstDigit == thirdDigit) {
                System.out.println("Число " + integer + " симметрично");
            } else {
                System.out.println("Число " + integer + " не симметрично");
            }
        } else {
            System.out.println("Вы ввели некорректное число");
        }
    }

    private static void exercise4() {
        int firstNumber = scanInteger("Введите первое трехзначное число (100-999)");
        int secondNumber = scanInteger("Введите второе трехзначное число (100-999)");
        int thirdNumber = scanInteger("Введите третье трехзначное число (100-999)");
        if (((firstNumber + secondNumber) > thirdNumber) || ((firstNumber + thirdNumber) > secondNumber) || ((secondNumber + thirdNumber) > firstNumber)) {
            System.out.println("Введенные числа могут быть сторонами треугольника");
        } else {
            System.out.println("Введенные числа не могут быть сторонами треугольника");
        }
    }

    private static void exercise5() {
        int monthNumber = scanInteger("Введите порядковый номер месяца (1-12)");
        String result = switch (monthNumber) {
            case 1 -> "Месяц Январь, сезон Зима";
            case 2 -> "Месяц Февраль, сезон Зима";
            case 3 -> "Месяц Март, сезон Весна";
            case 4 -> "Месяц Апрель, сезон Весна";
            case 5 -> "Месяц Май, сезон Весна";
            case 6 -> "Месяц Июнь, сезон Лето";
            case 7 -> "Месяц Июль, сезон Лето";
            case 8 -> "Месяц Август, сезон Лето";
            case 9 -> "Месяц Сентябрь, сезон Осень";
            case 10 -> "Месяц Октябрь, сезон Осень";
            case 11 -> "Месяц Ноябрь, сезон Осень";
            case 12 -> "Месяц Декабрь, сезон Зима";
            default -> "Некорректное значение месяца";
        };
        System.out.println("Введен номер " + monthNumber + ", результат: " + result);
    }

    private static int scanInteger(String title) {
        if (!title.isEmpty()) {
            System.out.println(title);
        }
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static boolean isOdd(int number) {
        return number % 2 == 0;
    }

    private static int getFirstDigit(int number) {
        return number / 100;
    }

    private static int getSecondDigit(int number) {
        return (number / 10) % 10;
    }

    private static int getThirdDigit(int number) {
        return number % 10;
    }

    private static boolean isValidNumber(int number) {
        return (number > 99 && number < 999);
    }
}
