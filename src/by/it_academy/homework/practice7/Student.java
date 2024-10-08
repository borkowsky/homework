package by.it_academy.homework.practice7;

public class Student extends Man {
    private int year;

    public Student(String name, int age, String gender, int weight, int year) {
        super(name, age, gender, weight);
        this.year = year;
    }

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

    @Override
    public String toString() {
        return "Student{" +
                "year=" + year +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", weight=" + weight +
                '}';
    }
}
