package by.it_academy.homework.task10.shop;

import by.it_academy.homework.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Order {
    private final UUID ID;
    private List<Item> items;

    public Order(List<Item> items) {
        this.ID = UUID.randomUUID();
        this.items = items;
    }

    public boolean addItem(Item item) {
        return this.items.add(item);
    }

    public boolean addItems(List<Item> items) {
        return this.items.addAll(items);
    }

    public boolean removeItem(Item item) {
        return this.items.remove(item);
    }

    public boolean removeItems(List<Item> items) {
        return this.items.removeAll(items);
    }

    public boolean removeItemById(UUID id) {
        int initialSize = this.items.size();
        this.items = this.items.stream()
                .filter(item -> !item.getId().equals(id))
                .collect(Collectors.toCollection(ArrayList::new));
        return initialSize != this.items.size();
    }

    public boolean removeItemsById(List<UUID> ids) {
        boolean result = true;
        for (UUID id : ids) {
            if (!this.removeItemById(id)) {
                result = false;
            }
        }
        return result;
    }

    public double getItemsSum() {
        return this.items.stream()
                .map(Item::getPrice)
                .reduce(0.0, Double::sum);
    }

    public void prettyPrint() {
        System.out.format("В заказе %s %d %s:%n%s%nИх общая сумма: %.2f$",
                ID,
                items.size(),
                Utils.declOfNum(items.size(), new String[]{
                        "товар",
                        "товара",
                        "товаров"
                }),
                prettyPrintItems(),
                getItemsSum()
        );
    }

    public String prettyPrintItems() {
        return items.stream()
                .map(item -> String.format("%s - %.2f$ (ID %s)", item.getName(), item.getPrice(), item.getId()))
                .collect(Collectors.joining("\n"));
    }
}
