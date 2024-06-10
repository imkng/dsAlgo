package com.company;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {
    static List<Double> nums = new ArrayList<>();
    public void addValue(){
        for (int i = 0; i < 1000000; i++) {
            nums.add(Math.random());
        }
        System.out.println("Value has been added");
    }
    public static void main(String[] args) {
        System.out.println("Line 1");
        new MemoryLeak().addValue();
        System.out.println("Line 3");
    }
}
