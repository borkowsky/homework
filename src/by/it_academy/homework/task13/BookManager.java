package by.it_academy.homework.task13;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookManager {
    private final String PATH = "resources/books.txt";
    private List<Book> books = new ArrayList<>();

    public BookManager() {
        writeSampleBooks();
        parseBooks();
    }

    private void writeSampleBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Оруэлл", "1984", 2021));
        books.add(new Book("Караткевич", "Дзiкае паляванне караля Стаха", 2020));
        books.add(new Book("Толкиен", "Хоббит", 2024));
        try (FileOutputStream fos = new FileOutputStream(PATH)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.printf("[writeSampleBooks] Error occurred: %s%n", e.getMessage());
        }
    }

    private void parseBooks() {
        try (InputStream inpStream = new FileInputStream(PATH)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inpStream);
            books = (List<Book>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("[parseBooks] Error occurred: %s%n", e.getMessage());
        }
    }

    public List<Book> getFilteredBooksList(Predicate<Book> predicate) {
        return books.stream().filter(predicate).collect(Collectors.toList());
    }

    public List<Book> getSortedBooksList(Comparator<Book> comparator) {
        List<Book> result = books;
        result.sort(comparator);
        return result;
    }

    public Map<Boolean, List<Book>> getGroupedBooksList(Function<Book, Boolean> function) {
        return books.stream()
                .collect(Collectors.groupingBy(function));
    }
}
