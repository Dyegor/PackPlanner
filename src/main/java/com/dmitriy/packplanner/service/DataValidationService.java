package com.dmitriy.packplanner.service;

import com.dmitriy.packplanner.entity.Item;
import com.dmitriy.packplanner.entity.inputEntities.InputData;
import com.dmitriy.packplanner.exception.ValidationException;

import java.util.List;

public class DataValidationService {
    public static int parseInt(String inputValue) {
        int value = 0;
        try {
            value = Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static double parseDouble(String inputValue) {
        double value = 0;
        try {
            value = Double.parseDouble(inputValue);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static boolean sortingTypeValidation(String sortingType) {
        return sortingType.equals("NATURAL") || sortingType.equals("SHORT_TO_LONG") || sortingType.equals("LONG_TO_SHORT");
    }

    public static void validateInputData(InputData inputData) throws ValidationException {
        if (!sortingTypeValidation(inputData.getInputCondition().getSortingType())) {
            throw new ValidationException("Possible sort orders are: NATURAL, SHORT_TO_LONG, LONG_TO_SHORT");
        }

        if (inputData.getInputCondition().getMaxPieces() <= 0) {
            throw new ValidationException("Max pieces per pack must be greater than 0");
        }

        if (inputData.getInputCondition().getMaxWeight() <= 0) {
            throw new ValidationException("Max weight per pack must be greater than 0");
        }

        inputItemsValidation(inputData.getInputItems());
    }

    public static void inputItemsValidation(List<Item> items) throws ValidationException {
        for (Item item : items) {
            if (item.getQuantity() <= 0) {
                throw new ValidationException("Item quantity must be greater than 0");
            }

            if (item.getLength() <= 0) {
                throw new ValidationException("Item length must be greater than 0");
            }

            if (item.getItemWeight() <= 0) {
                throw new ValidationException("Item weight must be greater than 0");
            }
        }
    }
}
