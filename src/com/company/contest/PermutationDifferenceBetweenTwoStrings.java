package com.company.contest;

import java.util.HashMap;
import java.util.Map;

public class PermutationDifferenceBetweenTwoStrings {
    static String s ="abcde", t = "edbac";
    public static void main(String[] args) {
        int ans = findPermutationDifference(s, t);
        System.out.println(ans);
    }

    private static int findPermutationDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int ans = 0;
        for (int i = 0; i < t.length(); i++) {
            ans += Math.abs(map.get(t.charAt(i)) - i);
        }
        return  ans;
    }
}
