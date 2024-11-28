package by.it_academy.homework.task13;

import by.it_academy.homework.utils.ExerciseSelector;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

//Управление списком книг.
//Файл books.txt содержит список книг в бинарном формате. Необходимо прочитать этот список книг из файла в классе BookManager и добавить в этот класс следующие методы:
//фильтрация книг по определенным критериям (по автору, по количеству страниц)
//сортировка книг по различным параметрам (по названию, по автору, по количеству страниц)
//создание подсписков книг (например, список книг определенного автора или список книг с количеством страниц больше определенного значения)

public class Main {
    public static void main(String[] args) {
        ExerciseSelector selector = new ExerciseSelector(new String[]{
                "Менеджер книг (фильтр, сортировка, группирование)",
                "Манипуляции с массивом (стрим + лямбда)"
        });
        switch (selector.selectExercise()) {
            case 1:
                exercise1();
                break;
            case 2:
                exercise2();
                break;
            default:
                System.out.println("Invalid task number provided!");
        }
    }

    private static void exercise1() {
        BookManager bookManager = new BookManager();
        List<Book> booksFiltered1 = bookManager.getFilteredBooksList(book -> "Караткевич".equals(book.getAuthor()));
        System.out.println("Filtered books list by AUTHOR:");
        printList(booksFiltered1);
        System.out.println();

        List<Book> sortedBooks1 = bookManager.getSortedBooksList(Comparator.comparing(Book::getName));
        System.out.println("Sorted books list by NAME:");
        printList(sortedBooks1);
        System.out.println();

        Map<Boolean, List<Book>> groupedBooksList = bookManager.getGroupedBooksList(book -> 2020 < book.getYear());
        System.out.println("Grouped books list by YEAR greater than 2020:");
        for (Map.Entry<Boolean, List<Book>> entry : groupedBooksList.entrySet()) {
            System.out.printf("Key: %s, Value: %s%n", entry.getKey(), entry.getValue());
        }
    }

    private static void exercise2() {
        List<String> initialList = Arrays.asList("a1", "a2", "a3", "b1", "b3", "c2", "c1", "c5");
        System.out.printf("Initial list: %s%n", initialList);
        long finalCount = initialList.stream()
                .filter(str -> !str.contains("3"))
                .sorted(Comparator.comparing(Main::getDigitFromString))
                .sorted(Comparator.comparing(Main::getLetterFromString).reversed())
                .skip(1)
                .limit(initialList.stream()
                        .filter(str -> !str.contains("3"))
                        .count() - 1)
                .map(str -> {
                    str = str.toUpperCase();
                    System.out.println(str);
                    return str;
                })
                .count();
        System.out.printf("Final count: %d%n", finalCount);
    }

    private static String getDigitFromString(String str) {
        return str.replaceAll("[a-zA-Z]+", "");
    }

    private static String getLetterFromString(String str) {
        return str.replaceAll("[0-9]+", "");
    }

    private static <T> void printList(List<T> list) {
        list.forEach(System.out::println);
    }
}
