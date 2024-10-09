package by.it_academy.homework.practice7;

public class UseStudent {
    public static void main(String[] args) {
        Man man = new Man("Roger", 19, "male", 73);
        System.out.println("Man class dump: " + man);
        man.setName("Roger redacted");
        man.setAge(20);
        man.setWeight(75);
        System.out.println("Man class dump after editing: " + man);
        Student student = new Student("Anna", 18, "female", 62, 2020);
        System.out.println("Student class dump: " + student);
        student.setYear(2021);
        student.setName("Anna redacted");
        student.setAge(19);
        student.setWeight(65);
        System.out.println("Student class dump after editing: " + student);
        // inc year in past
        student.incYear(2020); // should be 2021
        System.out.println("Student class dump after editing (change year in past): " + student);
        // inc year in future
        student.incYear(2022); // should be 2022
        System.out.println("Student class dump after editing (change year in future): " + student);
    }
}
