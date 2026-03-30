package com.company.javaeight.streamApi;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindAllDuplicatesInAnArray {

    static int[] nums = {4,3,2,7,8,2,3,1};

    public static void main(String[] args) {
        List<Integer> ans = findDuplicates(nums);
        System.out.println(ans);
    }

    private static List<Integer> findDuplicates(int [] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        List<String> temp = Arrays.asList("abc", "a");
        Optional<String> reduce1 = temp.stream().reduce((a, b) -> a.length() > b.length() ? a : b);
        System.out.println(reduce1.get());


        List<Long> collect = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .map(e -> e.getValue()).collect(Collectors.toList());
        System.out.println(collect);

        Long reduce = collect.stream().reduce(0L, (a, b) -> a + b);
        double asDouble = collect.stream().mapToLong(i -> i).average().getAsDouble();
        System.out.println(asDouble);

        Arrays.stream(nums).boxed().collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());


        List<Integer> ans = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() > 1).map(e -> e.getKey()).collect(Collectors.toList());
        int count = 0;
        String s = "0110101";
        while (s.contains("01")){
            count++;
            s = s.replaceAll("01", "10");

        }
        System.out.println(count);
        return ans;

    }
}
