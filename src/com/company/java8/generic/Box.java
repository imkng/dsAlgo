package com.company.java8.generic;

public class Box <T>{
//    Object container;
    T container;
    public Box(T container){
        this.container = container;
    }

    public T getContainer(){
        return this.container;
    }
}
