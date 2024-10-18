package by.it_academy.homework.practice9;

public class Main {


    public static void main(String[] args) {
        Pair<String> stringPair = new Pair<>("First element", "Second element");
        System.out.println(stringPair);
        System.out.format("First element is %s %n", stringPair.first());
        System.out.format("Second element is %s %n", stringPair.second());
        stringPair.swap();
        System.out.println();
        System.out.format("First element is %s %n", stringPair.first());
        System.out.format("Second element is %s %n", stringPair.second());
        stringPair.replaceFirst("Replaced first");
        stringPair.replaceLast("Replaced second");
        System.out.println();
        System.out.format("First element is %s %n", stringPair.first());
        System.out.format("Second element is %s %n", stringPair.second());
    }
}
