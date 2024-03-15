package com.company.javaeight.functionalInterfaces.predicateFunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateFunctionalInterfaceDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate = (t)->{
            return t % 2 == 0;
        };

        System.out.println(predicate.test(6));

        List<Integer> list = Arrays.asList(1,2, 3,4,5);
//        List<Integer> integerStream = list.stream().filter(predicate).collect(Collectors.toList());
        List<Integer> integerStream = list.stream().filter((t)->t%2 ==0).collect(Collectors.toList());
        System.out.println(integerStream);
    }
}
