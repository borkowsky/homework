package by.it_academy.homework.practice8;

import java.util.Arrays;

public class Bouquet {
    private Flower[] flowers;

    public Bouquet(Flower[] flowers) {
        this.flowers = flowers;
    }

    public Flower[] getFlowers() {
        return flowers;
    }

    public int getFullPrice() {
        int fullPrice = 0;
        for (Flower flower: flowers) {
            fullPrice += flower.getPrice();
        }
        return fullPrice;
    }

    public String[] getColors () {
        String[] colors = new String[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            colors[i] = flowers[i].getColor();
        }
        return colors;
    }

    public int getLifetime () {
        int lifetime = 0;
        for (Flower flower: flowers) {
            if (lifetime < flower.getLifeTime()) {
                lifetime = flower.getLifeTime();
            }
        }
        return lifetime;
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "flowers=" + Arrays.toString(flowers) +
                '}';
    }
}
