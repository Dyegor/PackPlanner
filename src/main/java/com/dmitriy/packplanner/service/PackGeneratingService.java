package com.dmitriy.packplanner.service;

import com.dmitriy.packplanner.entity.Item;
import com.dmitriy.packplanner.entity.Pack;
import com.dmitriy.packplanner.entity.inputEntities.InputData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PackGeneratingService {

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

    public static int calculateMaxQuantity(double packMaxWeight, double itemWeight) {
        return (int) (packMaxWeight / itemWeight);
    }

    public static List<Item> generatePacks(InputData inputData) {
        List<Item> listOfItems = new ArrayList<>();
        List<Item> items = inputData.getInputItems();
        double packMaxWeight = inputData.getInputCondition().getMaxWeight();
        int packMaxPieces = inputData.getInputCondition().getMaxPieces();

        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            Item packItem = Item.copy(item);

            int maxPossibleQuantity = calculateMaxQuantity(packMaxWeight, item.getItemWeight());
            if (maxPossibleQuantity == 0) {
                continue;
            }

            boolean exceeds = maxPossibleQuantity > packMaxPieces;

            if ((exceeds && (item.getQuantity() < packMaxPieces)) || (!exceeds && (item.getQuantity() < maxPossibleQuantity))) {
                packItem.setQuantity(item.getQuantity());
                listOfItems.add(packItem);

                packMaxPieces -= item.getQuantity();
                packMaxWeight -= item.getQuantity() * item.getItemWeight();

                items.remove(item);
                i--;
            } else if (exceeds) {
                packItem.setQuantity(packMaxPieces);
                listOfItems.add(packItem);

                item.setQuantity(item.getQuantity() - packMaxPieces);
                if (item.getQuantity() == 0) {
                    items.remove(item);
                }
                break;
            } else {
                packItem.setQuantity(maxPossibleQuantity);
                listOfItems.add(packItem);

                packMaxPieces -= maxPossibleQuantity;
                packMaxWeight -= maxPossibleQuantity * item.getItemWeight();

                item.setQuantity(item.getQuantity() - maxPossibleQuantity);
            }
        }
        return listOfItems;
    }
}
