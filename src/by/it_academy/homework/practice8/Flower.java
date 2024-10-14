package by.it_academy.homework.practice8;
//Реализовать иерархию цветов (розы, гвоздики, тюльпаны, лилии и… что-то на свой вкус).
//Создать несколько объектов-цветов.
//Собрать букет и определить его стоимость (в букет может входить несколько цветов одного типа).
//Определить все цвета, используемые в букете.
//Определить когда весь букет завянет.

public class Flower {
    private String name;
    private String color;
    private int lifeTime;
    private int price;

    public Flower(String name, String color, int lifeTime, int price) {
        this.name = name;
        this.color = color;
        this.lifeTime = lifeTime;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getLifeTime() {
        return lifeTime;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", lifeTime=" + lifeTime +
                '}';
    }
}
