package by.it_academy.homework.practice8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Flower tulip = new Flower("tulip", "red", 3, 50);
        Flower rose = new Flower("rose", "pink", 5, 70);
        Flower carnation = new Flower("carnation", "white", 7, 30);
        Flower lily = new Flower("lily", "yellow", 4, 30);

        Flower[] flowers = {tulip, rose, carnation, lily};
        Bouquet bouquet = new Bouquet(flowers);
        System.out.println("Full price: " + bouquet.getFullPrice());
        System.out.println("Flowers colors: " + Arrays.toString(bouquet.getColors()));
        System.out.println("Bouquet lifetime: " + bouquet.getLifetime());
    }
}
