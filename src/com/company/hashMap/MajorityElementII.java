package com.company.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElementII {
//    static int[] arr = new int[]{3,2,3};
    static int[] arr = new int[]{1,2};
    public static void main(String[] args) {
        List<Integer> ans = majorityElement(arr);
        ans.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(ans);
    }
    private static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            if (mp.containsKey(num)) {
                int count = mp.get(num);
                count++;
                mp.put(num, count);
            } else {
                mp.put(num, 1);
            }
        }
        return mp.entrySet().stream().filter(e ->e.getValue() > nums.length/3).map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
