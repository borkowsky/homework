package by.it_academy.homework.practice7;

public class Student extends Man {
    private int year;

    public int getYear() {
        return year;
    }

    public void incYear(int year) {
        if (year < this.year) {
            return;
        }
        this.year = year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
