package com.dmitriy.packplanner.entity;

public class Item {
    private int itemId;
    private int length;
    private int quantity;
    private double itemWeight;

    public static Item copy(Item item) {
        Item newItem = new Item();
        newItem.itemId = item.itemId;
        newItem.length = item.length;
        newItem.quantity = item.quantity;
        newItem.itemWeight = item.itemWeight;

        return newItem;
    }

    public int getId() {
        return itemId;
    }

    public void setId(int id) {
        this.itemId = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(double weight) {
        this.itemWeight = weight;
    }
}
