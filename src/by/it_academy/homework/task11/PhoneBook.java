package by.it_academy.homework.task11;

import by.it_academy.homework.utils.Utils;

import java.util.*;

public class PhoneBook {
    private final Map<String, Set<String>> DATA = new HashMap<>();

    public PhoneBook() {
        generateData();
    }

    public void addNumber() {
        System.out.println("Добавить номер в книгу");
        String key = Utils.scanString("Введите имя:");
        String val = Utils.scanString("Введите номер или несколько через запятую:");
        String[] values = val.split(",");
        for (String value : values) {
            value = value.trim();
            if (!value.isEmpty()) {
                addToData(key, value);
            }
        }
    }

    private void generateData() {
        Map<String, String> dummyData = new HashMap<>();
        dummyData.put("Linda B. McClellan", "9182858791");
        dummyData.put("Allen I. White", "2313491012");
        dummyData.put("Julie R. Tanner", "9542760657");
        dummyData.put("George A. Oliver", "2252325278");
        dummyData.put("Nancy J. West", "9898375325");
        for (Map.Entry<String, String> entry : dummyData.entrySet()) {
            addToData(entry.getKey(), entry.getValue());
        }
        addToData("George A. Oliver", "2252325278");
        addToData("Nancy J. West", "98983753252");
    }

    private void addToData(String key, String value) {
        if (DATA.containsKey(key)) {
            DATA.get(key).add(value);
        } else {
            DATA.put(key, new HashSet<>(Collections.singletonList(value)));
        }
    }

    public void prettyPrint() {
        System.out.format("Телефонная книга: всего %d %s%n",
                DATA.size(),
                Utils.declOfNum(DATA.size(), new String[]{
                        "номер",
                        "номера",
                        "номеров"
                })
        );
        int num = 1;
        for (Map.Entry<String, Set<String>> entry : DATA.entrySet()) {
            System.out.format("%d. %s: %s%n",
                    num,
                    entry.getKey(),
                    printPhones(entry.getValue())
            );
            num++;
        }
    }

    public String printPhones(Set<String> phones) {
        return String.join(", ", phones);
    }
}
