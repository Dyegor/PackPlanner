package com.dmitriy.packplanner;

import com.dmitriy.packplanner.entity.inputEntities.InputData;
import com.dmitriy.packplanner.entity.Pack;
import com.dmitriy.packplanner.service.DataPreparationService;
import com.dmitriy.packplanner.service.DataValidationService;
import com.dmitriy.packplanner.service.PackPlannerService;
import com.dmitriy.packplanner.service.PackGeneratingService;
import com.dmitriy.packplanner.util.InputReader;
import com.dmitriy.packplanner.util.ResultsPrinter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> inputList = InputReader.readInput();
            InputData inputData = DataPreparationService.prepareData(inputList);
            DataValidationService.validateInputData(inputData);

            PackGeneratingService.sortItems(inputData.getInputCondition().getSortingType(), inputData.getInputItems());
            List<Pack> result = PackPlannerService.fillPacks(inputData);

            PackGeneratingService.sortPacks(inputData.getInputCondition().getSortingType(), result);

            ResultsPrinter.printResults(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
