package by.it_academy.homework.task12;

import by.it_academy.homework.utils.ExerciseSelector;
import by.it_academy.homework.utils.Utils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ExerciseSelector selector = new ExerciseSelector(new String[]{
                "Поиск дублирующихся значений в списке",
                "Реализовать собственный стек",
                "Подсчет количества вхождений элементов в массив"
        });
        switch (selector.selectExercise()) {
            case 1:
                exercise1();
                break;
            case 2:
                exercise2();
                break;
            case 3:
                exercise3();
                break;
            default:
                System.out.println("Invalid task num provided!");
                break;
        }
    }

    private static void exercise1() {
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 20; i++) {
            list.add(Utils.getRandomNumber(1, 10));
        }
        System.out.printf("Initial list: %s%n", list);
        System.out.printf("Duplicates: %s%n", Utils.findDuplicates(list));
    }

    private static void exercise2() {
        CustomStack<Integer> stack = new CustomStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(Utils.getRandomNumber(1, 10));
        }
        System.out.printf("Initial stack: %s%n", stack);
        int valueToAdd = Utils.getRandomNumber(10, 20);
        System.out.printf("Added value to stack: %s%n", valueToAdd);
        stack.push(valueToAdd);
        System.out.printf("Stack: %s%n", stack);
        System.out.printf("Stack peek method: %d%n", stack.peek());
        System.out.printf("Stack: %s%n", stack);
        System.out.printf("Stack pop method: %d%n", stack.pop());
        System.out.printf("Stack: %s%n", stack);
        int valueToSearch = Utils.getRandomNumber(1, 10);
        System.out.printf("Stack search method (%d): %d%n", valueToSearch, stack.search(valueToSearch));
    }

    private static void exercise3() {
        Integer[] intArr = Utils.getRandomNumbers(10, 1, 7);
        System.out.printf("Initial array: %s%n", Arrays.toString(intArr));
        Map<Integer, Integer> map = arrayToMap(intArr);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("Number: %d, Frequency: %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static <K> Map<K, Integer> arrayToMap(K[] arr) {
        List<K> list = Arrays.asList(arr);
        Map<K, Integer> resultMap = new HashMap<>();
        for (K key : arr) {
            resultMap.put(key, Collections.frequency(list, key));
        }
        return resultMap;
    }
}
