package by.it_academy.homework.utils;

import java.util.Arrays;
import java.util.List;

public class ExerciseSelector {
    private final List<String> exercises;

    public ExerciseSelector(List<String> exercises) {
        this.exercises = exercises;
    }

    public ExerciseSelector(String[] exercises) {
        this.exercises = Arrays.asList(exercises);
    }

    public int selectExercise() {
        displayExercises();
        int number;
        int idx = 0;
        do {
            if (idx > 0) {
                System.out.print("Некорректный номер задачи! ");
            }
            number = Utils.getNumber("Выберите задачу из списка:");
            idx++;
        } while(number <= 0 || number > exercises.size());
        return number;
    }

    private void displayExercises() {
        System.out.println("Выберите задачу:");
        for (int i = 0; i < exercises.size(); i++) {
            System.out.println((i + 1) + ". " + exercises.get(i));
        }
    }
}
