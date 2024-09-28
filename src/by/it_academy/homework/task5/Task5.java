package by.it_academy.homework.task5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task5 {
    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();
    private static final String[] tasks = {
            "Вывести первые N элементов последовательности",
            "Заменить каждый элемент массива с нечетным индексом на ноль",
            "Определить, является ли массив чисел возрастающей последовательностью",
            "Вывести четные и нечетные ячейки массива",
            "Проверить, находится ли число в массиве",
            "* Вывести четные элементы из массива со случайными числами (массив длиной более 3)",
            "* Написать метод, принимающий массив в качестве параметра, который заполнит его положительными случайными числами так, чтобы его половины были идентичны"
    };

    public static void main(String[] args) {
        init();
    }

    private static void exercise1() {
        int subsequenceNum = 20;
        int[] array1 = {1, -2, 3, -4, 5, -6};
        int[] array2 = {1, 0, 2, 0, 3, 0, 4};
        System.out.println("Исходный массив array1 " + Arrays.toString(array1));
        int[] resultArray1 = new int[subsequenceNum];
        for (int i = 0; i < subsequenceNum; i++) {
            resultArray1[i] = (array1.length > i) ? array1[i] : (i % 2 == 0) ? (Math.abs(resultArray1[i - 1]) + 1) : -(Math.abs(resultArray1[i - 1]) + 1);
        }
        System.out.println("Первые " + subsequenceNum + " элементов массива array1 " + Arrays.toString(resultArray1));

        System.out.println("Исходный массив array2 " + Arrays.toString(array2));
        int[] resultArray2 = new int[subsequenceNum];
        for (int i = 0; i < subsequenceNum; i++) {
            resultArray2[i] = (array2.length > i) ? array2[i] : (resultArray2[i - 1] == 0) ? (resultArray2[i - 2] + 1) : 0;
        }
        System.out.println("Первые " + subsequenceNum + " элементов массива array2 " + Arrays.toString(resultArray2));
    }

    private static void exercise2() {
        int[] array = getRandomArray(15, 1, 200);
        System.out.println("Исходный массив: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                continue;
            }
            array[i] = (i % 2 == 0) ? array[i] : 0;
        }
        System.out.println("Массив результат: " + Arrays.toString(array));
    }

    private static void exercise3() {
        int[] array = getRandomArray(4, 10, 99);
        System.out.print("Исходный массив: " + Arrays.toString(array));
        boolean isSequence = false;
        for (int i = 0; i < array.length; i++) {
            isSequence = i == 0 || (array[i - 1] < array[i]);
            if (!isSequence) {
                break;
            }
        }
        System.out.print(isSequence ? ", является последовательностью" : ", не является последовательностью");
    }

    private static void exercise4() {
        int size = getNumber("Введите длину массива:");
        int[] array = getRandomArray(size, 10, 99);
        System.out.println("Исходный массив: " + Arrays.toString(array));
        int[] oddArray = new int[(int) Math.floor((double) (size - 1) / 2)];
        int[] evenArray = new int[(int) Math.ceil((double) (size - 1) / 2)];
        int oddArrIndex = 0;
        int evenArrIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                continue;
            }
            if (i % 2 == 0) {
                oddArray[oddArrIndex] = array[i];
                oddArrIndex++;
            } else {
                evenArray[evenArrIndex] = array[i];
                evenArrIndex++;
            }
        }
        System.out.println("Массив значений с четными ключами " + Arrays.toString(oddArray));
        System.out.println("Массив значений с нечетными ключами " + Arrays.toString(evenArray));
    }

    private static void exercise5(int[] array, int x) {
        Arrays.sort(array);
        System.out.print("Массив для поиска значения: " + Arrays.toString(array) + ", искомое значение: " + x + ", элемент " + (Arrays.binarySearch(array, x) >= 0 ? "найден" : "не найден") + " в массиве");
    }

    private static void exercise6(boolean recursive) {
        int size = getNumber(recursive ? "Некорректное число, повторите ввод:" : "Введите размер массива (больше 3):");
        if (size <= 3) {
            exercise6(true);
            return;
        }
        int[] array = getRandomArray(size, 0, size);
        System.out.println("Исходный сгенерированный массив: " + Arrays.toString(array));
        int oddElementsCount = 0;
        for (int j : array) {
            if ((j % 2 == 0) && j != 0) {
                oddElementsCount++;
            }
        }
        int[] resultArray = new int[oddElementsCount];
        int currResultArrayIndex = 0;
        for (int j : array) {
            if ((j % 2 == 0) && j != 0) {
                resultArray[currResultArrayIndex] = j;
                currResultArrayIndex++;
            }
        }
        System.out.println("Результирующий массив с четными значениями: " + Arrays.toString(resultArray));
    }

    private static void exercise7(int[] array) {
        for (int i = 0, j = array.length - 1; i <= j; i++, j--) {
            array[i] = array[j] = getRandomNumber(10, 99);
        }
        System.out.println("Заполненный отзеркаленный массив: " + Arrays.toString(array));
    }

    private static void init() {
        System.out.println("Список задач:");
        int i = 1;
        for (String taskName : tasks) {
            System.out.println("Задача " + i + ": " + taskName);
            i++;
        }
        selectTask();
    }

    private static void selectTask() {
        System.out.println("Введите номер задачи:");
        int taskNum = sc.nextInt();
        if (taskNum > 0 && taskNum <= tasks.length) {
            System.out.println(tasks[taskNum - 1]);
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
                    exercise5(getRandomArray(10, 10, 50), getRandomNumber(10, 50));
                    break;
                case 6:
                    exercise6(false);
                    break;
                case 7:
                    exercise7(new int[getRandomNumber(10, 20)]);
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

    private static int[] getRandomArray(int size, int min, int max) {
        int[] resultArray = new int[size];
        for (int i = 0; i < size; i++) {
            resultArray[i] = getRandomNumber(min, max);
        }
        return resultArray;
    }

    private static int getRandomNumber(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }
}
