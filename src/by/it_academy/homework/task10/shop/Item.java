package by.it_academy.homework.task10.shop;

import java.util.UUID;

public class Item {
    private final UUID ID;
    private String name;
    private double price;

    public Item(String name, double price) {
        ID = UUID.randomUUID();
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return ID;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + ID +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
