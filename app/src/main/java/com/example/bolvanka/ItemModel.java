package com.example.bolvanka;

public class ItemModel {
    private String name;
    private int counter;
    private int imageResId;

    public ItemModel(String name, int counter, int imageResId) {
        this.name = name;
        this.counter = counter;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
    public int getImageResId() {
        return imageResId;
    }
}