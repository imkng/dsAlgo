package com.company.javaeight.functionalInterfaces.consumerFunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionalInterfaceDemo  {

    public static void main(String[] args) {
        Consumer<Integer> consumer = (Integer integer) -> {
            System.out.println("Printing from consumer: " + integer);
        };
        consumer.accept(90);

        List<Integer> list = Arrays.asList(1,2, 3,4,5);
        // 1.
        // list.stream().forEach(consumer);
        // 2.
        list.stream().forEach((Integer integer) -> {
            System.out.println("Printing from consumer: " + integer);
        });

    }
}
