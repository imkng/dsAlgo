package com.company.solidPriciple.interfaceSegmentedPrinciple;

public interface ResturantEmployee {
    void washDishes();
    void serveCustomer();
    void cookFood();
}

class Waiter implements ResturantEmployee{

    @Override
    public void washDishes() {
        // i don't do
    }

    @Override
    public void serveCustomer() {
        // i will do
    }

    @Override
    public void cookFood() {
        // i don't do
    }
}
