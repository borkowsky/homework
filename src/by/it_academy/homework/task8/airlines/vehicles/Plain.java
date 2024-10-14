package by.it_academy.homework.task8.airlines.vehicles;

public class Plain extends Vehicle {
    public Plain(String name, int seats, int loadCapacity) {
        super(name, seats, loadCapacity);
    }

    @Override
    public String toString() {
        return "Plain{" +
                "name=" + super.getName() +
                ", seats=" + super.getSeats() +
                ", loadCapacity=" + super.getLoadCapacity() +
                "}";
    }

    public String getName() {
        return super.getName();
    }

    public int getSeats() {
        return super.getSeats();
    }

    public int getLoadCapacity() {
        return super.getLoadCapacity();
    }
}
