package com.example.listviewcustomlayout;

public class Fruit {
    private String name;
    private int calories;
    private int imageResourceId;

    public Fruit(String name, int calories, int imageResourceId) {
        this.name = name;
        this.calories = calories;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
