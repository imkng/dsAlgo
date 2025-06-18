package com.company.solidPriciple.solid.withoutS;

import com.company.solidPriciple.Marker;

public class Invoice {
    private Marker marker;
    int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int totalPrice(){
        return marker.getPrice() * quantity; // 1. in future u want to add logic
    }
    public void printInvoice(){
        // print the invoice // 2
    }
    public void saveToDb(){
        // save to db 3
    }
}
