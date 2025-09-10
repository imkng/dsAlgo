package com.company.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _02PermutationOfStringWithBackTracking {
    public static void main(String[] args) {
//        String s = new String("aabc");
        String s = new String("abc");
        List<String> v = new ArrayList<>();
        solve(s, v);
        System.out.println(v);
    }

    private static void solve(String s, List<String> v) {
        StringBuilder stringBuilder = new StringBuilder(s);
        permute(stringBuilder, 0, v);
    }

    private static void permute(StringBuilder s, int start, List<String> v) {
        if (start == s.length() - 1) {
            v.add(s.toString());
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = start; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                swaps(s, start, i);
                permute(s, start+1, v);
                swaps(s, start, i);
            }
        }
    }

    private static void swaps(StringBuilder s, int start, int i) {
        char temp = s.charAt(start);
        s.setCharAt(start, s.charAt(i));
        s.setCharAt(i, temp);
    }
}
