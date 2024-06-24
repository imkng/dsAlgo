package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Foo ", "bar ", "Foo ", "Bar ");
        Stream<String> stream = list.stream()
                .sorted(Comparator.reverseOrder())
                .distinct();
        stream.forEach(System.out::print);
    }
}
