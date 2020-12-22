package com.dmitriy.packplanner;

import com.dmitriy.packplanner.entity.Item;
import com.dmitriy.packplanner.entity.inputEntities.InputData;
import com.dmitriy.packplanner.entity.Pack;
import com.dmitriy.packplanner.service.DataPreparationService;
import com.dmitriy.packplanner.service.DataValidationService;
import com.dmitriy.packplanner.service.PackPlannerService;
import com.dmitriy.packplanner.service.PackGenerationService;
import com.dmitriy.packplanner.util.InputReader;
import com.dmitriy.packplanner.util.ResultsPrinter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> inputList = InputReader.readInput();
            InputData inputData = DataPreparationService.prepareData(inputList);
            DataValidationService.validateInputData(inputData);

            PackGenerationService.sortOutputData(inputData.getInputCondition().getSortingType(), inputData.getInputItems(), Item::getLength);
            List<Pack> result = PackPlannerService.fillPacks(inputData);

            PackGenerationService.sortOutputData(inputData.getInputCondition().getSortingType(), result, Pack::getTotalLength);

            ResultsPrinter.printResults(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
