package com.dmitriy.packplanner.service;

import com.dmitriy.packplanner.entity.inputEntities.InputCondition;
import com.dmitriy.packplanner.entity.inputEntities.InputData;
import com.dmitriy.packplanner.entity.Item;

import java.util.List;

public class DataPreparationService {
    public static Item populateItem(String[] inputValues) {
        Item inputItem = new Item();
        if (inputValues != null && inputValues.length == 4) {
            inputItem.setId(DataValidationService.parseInt(inputValues[0]));
            inputItem.setLength(DataValidationService.parseInt(inputValues[1]));
            inputItem.setQuantity(DataValidationService.parseInt(inputValues[2]));
            inputItem.setItemWeight(DataValidationService.parseDouble(inputValues[3]));
        }
        return inputItem;
    }

    public static InputCondition populateInputCondition(String[] inputValues) {
        InputCondition inputCondition = new InputCondition();
        if (inputValues != null && inputValues.length == 3) {
            inputCondition.setSortingType(inputValues[0]);
            inputCondition.setMaxPieces(DataValidationService.parseInt(inputValues[1]));
            inputCondition.setMaxWeight(DataValidationService.parseDouble(inputValues[2]));
        }

        return inputCondition;
    }

    public static InputData prepareData(List<String> data) {
        InputData inputData = new InputData();

        for (int i = 0; i < data.size(); i++) {
            String[] inputValues = data.get(i).split(",");
            if (i == 0) {
                inputData.setInputCondition(populateInputCondition(inputValues));
            } else {
                inputData.getInputItems().add(populateItem(inputValues));
            }
        }
        return inputData;
    }
}
