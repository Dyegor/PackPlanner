package com.dmitriy.packplanner.service;

import com.dmitriy.packplanner.entity.Item;
import com.dmitriy.packplanner.entity.inputEntities.InputData;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class PackGenerationService {

    public static <T> void sort(String sortingType, List<T> list, Function<T, Integer> comparingFunction) {
        if (!sortingType.equals("NATURAL")) {
            list.sort(Comparator.comparing(comparingFunction));
            if (sortingType.equals("LONG_TO_SHORT")) {
                Collections.reverse(list);
            }
        }
    }

    public static void generatePacks(InputData inputData, List<Item> listOfItems) {
        List<Item> items = inputData.getInputItems();
        int maxPackItems = inputData.getInputCondition().getMaxPieces();
        double maxPackWeight = inputData.getInputCondition().getMaxWeight();

        for (int i = 0; i < items.size(); i++) {
            if (maxPackItems == 0) {
                break;
            }

            int maxPossibleQuantity = (int) (maxPackWeight / items.get(i).getItemWeight());
            if (maxPossibleQuantity == 0) {
                continue;
            }

            int packItemQuantity = compareQuantities(maxPossibleQuantity, maxPackItems, items.get(i).getQuantity());

            listOfItems.add(createNewItem(packItemQuantity, items.get(i)));

            maxPackItems -= packItemQuantity;
            maxPackWeight -= (packItemQuantity * items.get(i).getItemWeight());

            itemRemove(items, items.get(i--));
        }
    }

    public static void itemRemove(List<Item> items, Item item) {
        if (item.getQuantity() == 0) {
            items.remove(item);
        }
    }

    public static int compareQuantities(int maxPossibleQuantity, int maxPossibleItems, int itemQuantity) {
        return Math.min(Math.min(maxPossibleQuantity, maxPossibleItems), itemQuantity);
    }

    public static Item createNewItem(int quantityToWorkWith, Item item) {
        Item newItem = Item.copy(item);
        newItem.setQuantity(quantityToWorkWith);
        item.setQuantity(item.getQuantity() - quantityToWorkWith);

        return newItem;
    }
}
