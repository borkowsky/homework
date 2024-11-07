package by.it_academy.homework.task11;

import by.it_academy.homework.utils.ExerciseSelector;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ExerciseSelector selector = new ExerciseSelector(new String[]{
                "Замена ключей и значений в HashMap местами",
                "Телефонная книга"
        });
        switch (selector.selectExercise()) {
            case 1:
                exercise1();
                break;
            case 2:
                exercise2();
                break;
            default:
                System.out.println("Invalid task!");
                break;
        }
    }

    private static void exercise1() {
        Map<Integer, String> initialMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        initialMap.put(12, "One two");
        initialMap.put(13, "One three");
        initialMap.put(14, "One four");
        initialMap.put(15, "One five");
        for (Map.Entry<Integer, String> entry : initialMap.entrySet()) {
            resultMap.put(entry.getValue(), entry.getKey());
        }
        System.out.println("Initial map: " + initialMap);
        System.out.println("Result map: " + resultMap);
    }

    private static void exercise2() {
        PhoneBook addressBook = new PhoneBook();
        addressBook.prettyPrint();
        ExerciseSelector optionsSelector = new ExerciseSelector(new String[]{
                "Добавить номер",
                "Закончить выполнение"
        });
        int optNum = 1;
        while (optNum == 1) {
            addressBook.addNumber();
            addressBook.prettyPrint();
            optNum = optionsSelector.selectExercise();
        }
    }
}
