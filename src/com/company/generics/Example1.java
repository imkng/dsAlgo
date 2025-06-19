package com.company.generics;

import java.util.ArrayList;

public class Example1 {
    public static void main(String[] args) {
//        ArrayList list = new ArrayList(); // will store objects
//        list.add("Hello");
//        list.add(123);
//        list.add(3.14);
//
//        String str = (String) list.get(0); // need to do the manual typecasting
//        String str1 = (String) list.get(1); // here will get runtimeException
        //Above code has 3 major issues

        // No Type safety
        // Manual casting
        // No Compile Time checking

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("World");
        String s = list1.get(0);
        String s1 = list1.get(1);

//        Box box = new Box();
//        box.setObject("123");
//        String s2 = (String) box.getObject(); // need to do the manual typecasting
//        Integer ele = (Integer) box.getObject(); // here will get runtimeException
//
        Box<Integer> box = new Box<>();
        box.setObject(1);
        Integer ele = box.getObject();

        Pair<String, Integer> pair = new Pair<>("Age: ", 26);
        System.out.println(pair.getValue());

    }
}
