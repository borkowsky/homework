package by.it_academy.homework.task8;

import by.it_academy.homework.task8.airlines.Airlines;
import by.it_academy.homework.task8.airlines.vehicles.Helicopter;
import by.it_academy.homework.task8.airlines.vehicles.Plain;
import by.it_academy.homework.task8.airlines.vehicles.Quadcopter;
import by.it_academy.homework.task8.airlines.vehicles.Vehicle;
import by.it_academy.homework.task8.money.Money;
import by.it_academy.homework.utils.ExerciseSelector;
import by.it_academy.homework.utils.Utils;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ExerciseSelector excSelector = new ExerciseSelector(new String[]{
                "Класс для работы с деньгами (Money)",
                "Упражнение \"Авиакомпания\""
        });
        switch (excSelector.selectExercise()) {
            case 1:
                exercise1();
                break;
            case 2:
                exercise2();
                break;
            default:
                System.out.println("Invalid input provided!");

        }
    }

    private static void exercise1() {
        int dollars = Utils.getNumber("Введите количество долларов:");
        int cents = Utils.getNumber("Введите количество центов:");
        Money money = new Money(dollars, cents);
        System.out.println("Начальное значение: " + money.toStringPretty("ru"));
        int dollarsToAdd = Utils.getNumber("Введите количество долларов для добавления:");
        int centsToAdd = Utils.getNumber("Введите количество центов для добавления:");
        money.add(dollarsToAdd, centsToAdd);
        System.out.println("Результат сложения: " + money.toStringPretty("ru"));
        int dollarsToSubtract = Utils.getNumber("Введите количество долларов для вычитания:");
        int centsToSubtract = Utils.getNumber("Введите количество центов для вычитания:");
        money.subtract(dollarsToSubtract, centsToSubtract);
        System.out.println("Результат вычитания: " + money.toStringPretty("ru"));
        int dollars1 = Utils.getNumber("Введите количество долларов (для объекта сравнения):");
        int cents1 = Utils.getNumber("Введите количество центов (для объекта сравнения):");
        Money money1 = new Money(dollars1, cents1);
        System.out.println(money.equals(money1) ? "Экземпляры равны" : "Экземпляры не равны");
    }

    private static void exercise2() {
        int vehiclesCount = Utils.getRandomNumber(10, 20);
        Vehicle[] vehicles = new Vehicle[vehiclesCount];
        String[] vehicleTypes = new String[]{"plain", "helicopter", "quadcopter"};
        for (int i = 0; i < vehicles.length; i++) {
            String type = Utils.getRandomArrayElement(vehicleTypes);
            int[] seats = getSeatsByVehicleType(type);
            int[] loadCapacity = getLoadCapacityByVehicleType(type);
            vehicles[i] = getRandomVehicle(
                    type,
                    getVehicleNamesByType(type),
                    seats[0],
                    seats[1],
                    loadCapacity[0],
                    loadCapacity[1]
            );
        }
        Airlines airlines = new Airlines(vehicles);
        System.out.println("Сгенерирована авиакомпания");
        System.out.println(airlines.prettyToString());
        int minSeats = Utils.getNumber("Введите минимальное число посадочных мест:");
        int maxSeats = Utils.getNumber("Введите максимальное число посадочных мест:");
        List<Vehicle> foundedVehicleList1 = airlines.findPlainBySeats(minSeats, maxSeats);
        printPlainSearchResults(foundedVehicleList1);
        int minCapacity = Utils.getNumber("Введите минимальную грузоподъемность:");
        int maxCapacity = Utils.getNumber("Введите максимальную грузоподъемность:");
        List<Vehicle> foundedVehicleList2 = airlines.findPlainByLoadCapacity(minCapacity, maxCapacity);
        printPlainSearchResults(foundedVehicleList2);
    }

    private static Vehicle getRandomVehicle(String type, String[] names, int seatsMin, int seatsMax, int capacityMin, int capacityMax) {
        return switch (type) {
            case "helicopter" -> new Helicopter(
                    Utils.getRandomArrayElement(names),
                    Utils.getRandomNumber(seatsMin, seatsMax),
                    Utils.getRandomNumber(capacityMin, capacityMax)
            );
            case "quadcopter" -> new Quadcopter(
                    Utils.getRandomArrayElement(names),
                    Utils.getRandomNumber(seatsMin, seatsMax),
                    Utils.getRandomNumber(capacityMin, capacityMax)
            );
            default -> new Plain(
                    Utils.getRandomArrayElement(names),
                    Utils.getRandomNumber(seatsMin, seatsMax),
                    Utils.getRandomNumber(capacityMin, capacityMax)
            );
        };
    }

    private static void printPlainSearchResults(List<Vehicle> list) {
        if (!list.isEmpty()) {
            System.out.println(Utils.declOfNum(list.size(), new String[]{"Найден", "Найдено", "Найдено"})
                    + " "
                    + list.size()
                    + " "
                    + Utils.declOfNum(list.size(), new String[]{"самолет", "самолета", "самолетов"})
                    + ": ");
            list.forEach(System.out::println);
        } else {
            System.out.println("Самолеты с указанными параметрами не был найдены");
        }
    }

    private static String[] getVehicleNamesByType(String type) {
        String[] plainsNames = new String[]{
                "Boeing 757",
                "Bombardier CRJ-100",
                "CASA C-212 Aviocar",
                "Cessna 404",
                "de Havilland Canada Dash 7",
                "Embraer 190",
                "Douglas DC-4"
        };
        String[] helicoptersNames = new String[]{
                "AgustaWestland AW109",
                "Bell 206 JetRanger",
                "Bell 214",
                "Boeing Model 360",
                "Eurocopter AS365 Dauphin",
                "Eurocopter EC155",
                "MD Helicopters MD 500",
                "Robinson R22",
                "Robinson R66",
                "Sikorsky S-76"
        };
        String[] quadcoptersNames = new String[]{
                "P100 Agricultural Drone",
                "SplashDrone4",
                "Skydio X10D",
                "Parrot ANAFI USA",
                "DJI Inspire 1 Pro/Raw",
                "DJI Mavic 2 Enterprise Series"
        };
        return switch (type) {
            case "helicopter" -> helicoptersNames;
            case "quadcopter" -> quadcoptersNames;
            default -> plainsNames;
        };
    }

    private static int[] getSeatsByVehicleType(String type) {
        return switch (type) {
            case "helicopter" -> new int[]{10, 20};
            case "quadcopter" -> new int[]{0, 0};
            default -> new int[]{100, 200};
        };
    }

    private static int[] getLoadCapacityByVehicleType(String type) {
        return switch (type) {
            case "helicopter" -> new int[]{50, 300};
            case "quadcopter" -> new int[]{30, 100};
            default -> new int[]{500, 1500};
        };
    }
}
