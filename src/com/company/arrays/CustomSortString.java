package com.company.arrays;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    static String order = "cba";
    static String s = "abcd";

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c: order.toCharArray()) {
            if (map.containsKey(c)){
                result.append(String.valueOf(c).repeat(Math.max(0, map.get(c))));
                map.remove(c);
            }
        }
        for (char c: map.keySet()){
            result.append(String.valueOf(c).repeat(Math.max(0, map.get(c))));
        }
        System.out.println(result);
    }
}
