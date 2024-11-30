package by.it_academy.homework.task13;

import java.io.Serializable;

public class Book implements Serializable {
    private final String name;
    private final String author;
    private final Integer year;

    public Book(String author, String name, Integer year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }
}
