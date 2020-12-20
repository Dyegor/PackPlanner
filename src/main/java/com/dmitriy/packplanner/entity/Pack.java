package com.dmitriy.packplanner.entity;

import java.util.List;

public class Pack implements Comparable<Pack> {
    private int packId;
    private List<Item> listOfItems;

    @Override
    public int compareTo(Pack pack) {
        return Integer.compare(this.getTotalLength(), pack.getTotalLength());
    }

    public int getPackId() {
        return packId;
    }

    public void setPackId(int packId) {
        this.packId = packId;
    }

    public List<Item> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<Item> stackOfItems) {
        this.listOfItems = stackOfItems;
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Item item : listOfItems) {
            totalWeight += item.getItemWeight() * item.getQuantity();
        }
        return totalWeight;
    }

    public int getTotalLength() {
        int packLength = 0;
        for (Item item : listOfItems) {
            packLength = Math.max(packLength, item.getLength());
        }
        return packLength;
    }
}
