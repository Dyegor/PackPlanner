package com.dmitriy.packplanner.entity.inputEntities;

import com.dmitriy.packplanner.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class InputData {
    private InputCondition inputCondition;
    private List<Item> inputItems = new ArrayList<>();

    public InputCondition getInputCondition() {
        return inputCondition;
    }

    public void setInputCondition(InputCondition inputCondition) {
        this.inputCondition = inputCondition;
    }

    public List<Item> getInputItems() {
        return inputItems;
    }

    public void setInputItems(List<Item> inputItems) {
        this.inputItems = inputItems;
    }
}
