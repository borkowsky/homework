package by.it_academy.homework.task8.airlines.vehicles;

public abstract class Vehicle {
    private String name;
    private int seats;
    private int loadCapacity;

    public Vehicle(String name, int seats, int loadCapacity) {
        this.name = name;
        this.seats = seats;
        this.loadCapacity = loadCapacity;
    }

    public String getName() {
        return name;
    }

    public int getSeats() {
        return seats;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }
}
