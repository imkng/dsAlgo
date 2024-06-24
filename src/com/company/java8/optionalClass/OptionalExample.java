package com.company.java8.optionalClass;

import java.util.Optional;

public class OptionalExample {
    public static Optional<String> getName(){
        String name = "Krishna";
        return Optional.ofNullable(name);
    }
    public static void main(String[] args) {
        String str = "Java";
        if (str == null){
            System.out.println("string is null");
        }else {
            System.out.println("String length is " + str.length());
        }
        Optional<String> optional = Optional.ofNullable(str);
        System.out.println(optional.isPresent());
//        System.out.println(optional.get());
        System.out.println(optional.orElse("Empty String"));

        Optional<String> name = getName();
        System.out.println(name.orElse("Name is null"));
    }
}
