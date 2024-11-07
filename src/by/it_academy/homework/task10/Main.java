package by.it_academy.homework.task10;

import by.it_academy.homework.task10.shop.Item;
import by.it_academy.homework.task10.shop.Order;
import by.it_academy.homework.utils.Utils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Item> items = generateItems();
        Order order = new Order(items);
        order.prettyPrint();
        System.out.println();
        Item itemToAdd = getRandomItem(items);
        System.out.format("1. Add item (item ID %s): result is %s", itemToAdd.getId(), order.addItem(itemToAdd));
        order.prettyPrint();
        System.out.println();
        List<Item> itemsToAdd = generateItems();
        System.out.format("2. Add items (size %d): result is %s", itemsToAdd.size(), order.addItems(itemsToAdd));
        order.prettyPrint();
        System.out.println();
        Item itemToRemoveByRef = getRandomItem(items);
        System.out.format("3. Remove item by reference (item ID %s): result is %s", itemToRemoveByRef.getId(), order.removeItem(itemToRemoveByRef));
        order.prettyPrint();
        System.out.println();
        System.out.format("4. Remove item by reference (item is null): result is %s", order.removeItem(null));
        order.prettyPrint();
        System.out.println();
        Item itemToRemoveById = getRandomItem(items);
        System.out.format("5. Remove item by ID (item ID %s): result is %s", itemToRemoveByRef.getId(), order.removeItemById(itemToRemoveById.getId()));
        order.prettyPrint();
        System.out.println();
        System.out.format("6. Remove item by ID (item ID is null): result is %s", order.removeItemById(null));
        order.prettyPrint();
        System.out.println();
        List<UUID> randomIdsToRemove = getPartOfIds(items);
        System.out.format("7. Remove items by ID (IDs: %s): result is %s", randomIdsToRemove, order.removeItemsById(randomIdsToRemove));
        order.prettyPrint();
        System.out.println();
        List<UUID> randomIdsWNullToRemove = new ArrayList<>();
        randomIdsWNullToRemove.add(null);
        randomIdsWNullToRemove.add(null);
        System.out.format("8. Remove items by ID (IDs: %s): result is %s", randomIdsWNullToRemove, order.removeItemsById(randomIdsWNullToRemove));
        order.prettyPrint();
        System.out.println();
        List<Item> randomItemsToRemove = new ArrayList<>();
        randomItemsToRemove.add(getRandomItem(items));
        randomItemsToRemove.add(getRandomItem(items));
        System.out.format("9. Remove items by reference (%s): result is %s", randomItemsToRemove, order.removeItems(randomItemsToRemove));
        order.prettyPrint();
    }

    private static List<Item> generateItems() {
        Map<String, Double> items = getItemsHashMap();
        String[] keys = items.keySet().toArray(new String[0]);
        List<Item> itemsList = new ArrayList<>();
        int[] randomArr = Utils.getRandomNumbers(Utils.getRandomNumber(3, items.size()), 0, items.size() - 1);
        for (int j : randomArr) {
            itemsList.add(new Item(keys[j], items.get(keys[j])));
        }
        return itemsList;
    }

    private static Item getRandomItem(List<Item> items) {
        return items.get(Utils.getRandomNumber(0, items.size() - 1));
    }

    private static List<UUID> getPartOfIds(List<Item> items) {
        return items.subList(0, Utils.getRandomNumber(0, items.size() - 1)).stream()
                .map(Item::getId)
                .toList();
    }

    private static Map<String, Double> getItemsHashMap() {
        Map<String, Double> items = new HashMap<>();
        items.put("Silver Arrows", 4.0);
        items.put("Bronze Arrows", 1.1);
        items.put("Adamant Arrows", 6.3);
        items.put("Hardwood Recurve", 59.2);
        items.put("Hardwood Compound Bow", 69.9);
        items.put("Bronzed Heavy Crossbow", 63.3);
        items.put("Ghost Willow Piercer", 64.5);
        items.put("Mithril Heavy Crossbow", 88.2);
        items.put("Steel Bolts", 1.0);
        items.put("Iron Bolts", 2.0);
        items.put("Bronze Heads", 1.1);
        items.put("Feathers", 0.5);
        return items;
    }
}
