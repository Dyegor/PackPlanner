package com.dmitriy.packplanner.service;

import com.dmitriy.packplanner.entity.inputEntities.InputData;
import com.dmitriy.packplanner.entity.Pack;
import com.dmitriy.packplanner.entity.Item;

import java.util.*;

public class PackPlannerService {
    public static List<Pack> fillPacks(InputData inputData) {
        List<Pack> listOfPacks = new ArrayList<>();
        int packId = 1;
        while (!inputData.getInputItems().isEmpty()) {
            Pack pack = new Pack();
            pack.setPackId(packId++);

            List<Item> listOfItems = PackGenerationService.generatePacks(inputData);
            pack.setListOfItems(listOfItems);
            listOfPacks.add(pack);
        }
        return listOfPacks;
    }
}
