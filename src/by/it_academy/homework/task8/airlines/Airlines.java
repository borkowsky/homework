package by.it_academy.homework.task8.airlines;

import by.it_academy.homework.task8.airlines.vehicles.Helicopter;
import by.it_academy.homework.task8.airlines.vehicles.Plain;
import by.it_academy.homework.task8.airlines.vehicles.Quadcopter;
import by.it_academy.homework.task8.airlines.vehicles.Vehicle;
import by.it_academy.homework.utils.Utils;

import java.util.Arrays;
import java.util.List;

public class Airlines {
    private List<Vehicle> vehiclesList;
    private int plainsCount;
    private int helicopterCount;
    private int quadcopterCount;

    public Airlines(List<Vehicle> vehiclesList) {
        this.vehiclesList = vehiclesList;
        calculateVehiclesCounts();
    }

    public Airlines(Vehicle[] vehicles) {
        this.vehiclesList = Arrays.asList(vehicles);
        calculateVehiclesCounts();
    }

    public int getTotalSeats() {
        int seats = 0;
        for (Vehicle vehicle : this.vehiclesList) {
            seats += vehicle.getSeats();
        }
        return seats;
    }

    public String prettyToString() {
        return "Авиакомпания с " + vehiclesList.size() + " транспортными средствами, " +
                "из них " + plainsCount + " " + Utils.declOfNum(plainsCount, new String[]{
                "самолет",
                "самолета",
                "самолетов"}) +
                ", " + helicopterCount + " " + Utils.declOfNum(helicopterCount, new String[]{
                "вертолет",
                "вертолета",
                "вертолетов"}) +
                ", " + quadcopterCount + " " + Utils.declOfNum(quadcopterCount, new String[]{
                "квадрокоптер",
                "квадрокоптера",
                "квадрокоптеров"}) +
                "\nИх общая вместимость: " + getTotalSeats() + " " + Utils.declOfNum(getTotalSeats(), new String[]{
                "посадочное место",
                "посадочных места",
                "посадочных мест"}) +
                "\nИх общая грузоподъемность: " + getTotalLoadCapacity() + " " + Utils.declOfNum(getTotalLoadCapacity(), new String[]{
                "килограмм",
                "килограмма",
                "килограммов"});
    }

    public int getTotalLoadCapacity() {
        int loadCapacity = 0;
        for (Vehicle vehicle : this.vehiclesList) {
            loadCapacity += vehicle.getLoadCapacity();
        }
        return loadCapacity;
    }

    public List<Vehicle> getVehiclesList() {
        return vehiclesList;
    }

    public List<Vehicle> findPlainBySeats(int seatsMin, int seatsMax) {
        return this.vehiclesList
                .stream()
                .filter(vehicle -> vehicle instanceof Plain
                        && vehicle.getSeats() >= seatsMin
                        && vehicle.getSeats() <= seatsMax)
                .toList();
    }

    public List<Vehicle> findPlainByLoadCapacity(int capacityMin, int capacityMax) {
        return this.vehiclesList
                .stream()
                .filter(vehicle -> vehicle instanceof Plain
                        && vehicle.getLoadCapacity() >= capacityMin
                        && vehicle.getLoadCapacity() <= capacityMax)
                .toList();
    }

    private void calculateVehiclesCounts() {
        for (Vehicle vehicle : this.vehiclesList) {
            if (vehicle instanceof Helicopter) {
                helicopterCount++;
            } else if (vehicle instanceof Quadcopter) {
                quadcopterCount++;
            } else {
                plainsCount++;
            }
        }
    }
}
