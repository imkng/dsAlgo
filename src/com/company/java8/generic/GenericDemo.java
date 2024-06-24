package com.company.java8.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        Box box= new Box("water");
        System.out.println(box.getContainer());

        Box<Integer> integerBox = new Box<>(1);
        System.out.println(integerBox.getContainer());
    }
}
