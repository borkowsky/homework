package by.it_academy.homework.task13;

import java.io.Serializable;

public class Book implements Serializable {
    private final String NAME;
    private final String AUTHOR;
    private final Integer YEAR;

    public Book(String AUTHOR, String NAME, Integer YEAR) {
        this.NAME = NAME;
        this.AUTHOR = AUTHOR;
        this.YEAR = YEAR;
    }

    @Override
    public String toString() {
        return "Book{" +
                "NAME='" + NAME + '\'' +
                ", AUTHOR='" + AUTHOR + '\'' +
                ", YEAR='" + YEAR + '\'' +
                '}';
    }

    public String getNAME() {
        return NAME;
    }

    public String getAUTHOR() {
        return AUTHOR;
    }

    public Integer getYEAR() {
        return YEAR;
    }
}
