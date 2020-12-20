package com.dmitriy.packplanner.entity.inputEntities;

public class InputCondition {
    private String sortingType;
    private int maxPieces;
    private double maxWeight;

    public String getSortingType() {
        return sortingType;
    }

    public void setSortingType(String sortingType) {
        this.sortingType = sortingType;
    }

    public int getMaxPieces() {
        return maxPieces;
    }

    public void setMaxPieces(int maxPieces) {
        this.maxPieces = maxPieces;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
}
