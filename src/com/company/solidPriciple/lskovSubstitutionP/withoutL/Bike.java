package com.company.solidPriciple.lskovSubstitutionP.withoutL;

public interface Bike {
    void turnOnEngine();
    void accelerate();

}

class MotorCycle implements Bike{

    boolean isEngineOn;
    int speed;

    @Override
    public void turnOnEngine() {
        isEngineOn = true;
    }

    @Override
    public void accelerate() {
        speed = speed + 10;
    }
}

class ByCycle implements Bike{


    @Override
    public void turnOnEngine() {
        throw new RuntimeException("I don't have engine"); // here it's narrow down the principle
    }

    @Override
    public void accelerate() {
        // do something
    }
}
