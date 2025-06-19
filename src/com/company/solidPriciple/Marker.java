package com.company.solidPriciple;

public class Marker {
    int price;
    String color;

    public Marker(int price, String color) {
        this.price = price;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
