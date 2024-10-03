package by.it_academy.homework.practice6;

public class UseTimeConverter {
    public static void main(String[] args) {
        TimeConverter timeConverter1 = new TimeConverter(1, 15, 20);
        System.out.println("Time converter with separate constructor: " + timeConverter1.toString());
        TimeConverter timeConverter2 = new TimeConverter(4519);
        System.out.println("Time converter with seconds constructor: " + timeConverter2.toString());
        System.out.println(timeConverter1.isEqual(timeConverter2) ? "Objects are equal" : "Objects are not equal");
    }
}