package com.dmitriy.packplanner.service;

import com.dmitriy.packplanner.entity.Item;
import com.dmitriy.packplanner.entity.Pack;
import com.dmitriy.packplanner.entity.inputEntities.InputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PackGenerationService {

    public static void sortItems(String sortingType, List<Item> items) {
        if (!sortingType.equals("NATURAL")) {
            items.sort(Comparator.comparing(Item::getLength));
            if (sortingType.equals("LONG_TO_SHORT")) {
                Collections.reverse(items);
            }
        }
    }

    public static void sortPacks(String sortingType, List<Pack> listOfPacks) {
        if (!sortingType.equals("NATURAL")) {
            listOfPacks.sort(Comparator.comparing(Pack::getTotalLength));
            if (sortingType.equals("LONG_TO_SHORT")) {
                Collections.reverse(listOfPacks);
            }
        }
    }

    public static List<Item> generatePacks(InputData inputData) {
        List<Item> listOfItems = new ArrayList<>();
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

            int packItemQuantity = compareMaxQuantities(maxPossibleQuantity, maxPackItems, items.get(i).getQuantity());

            listOfItems.add(createNewItem(packItemQuantity, items.get(i)));

            maxPackItems -= packItemQuantity;
            maxPackWeight -= (packItemQuantity * items.get(i).getItemWeight());

            itemRemove(items, items.get(i--));
        }

        return listOfItems;
    }


    public static void itemRemove(List<Item> items, Item item) {
        if (item.getQuantity() == 0) {
            items.remove(item);
        }
    }

    public static int compareMaxQuantities(int maxPossibleQuantity, int maxPossibleItems, int itemQuantity) {
        return Math.min(Math.min(maxPossibleQuantity, maxPossibleItems), itemQuantity);
    }

    public static Item createNewItem(int quantityToWorkWith, Item item) {
        Item newItem = Item.copy(item);
        newItem.setQuantity(quantityToWorkWith);
        item.setQuantity(item.getQuantity() - quantityToWorkWith);

        return newItem;
    }
}
