package com.company.slidingWindows;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfString {
//    Permutation in String
//            Medium
//    Topics
//    premium lock icon
//            Companies
//    Hint
//    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//
//    In other words, return true if one of s1's permutations is the substring of s2.
//
//
//
//    Example 1:
//
//    Input: s1 = "ab", s2 = "eidbaooo"
//    Output: true
//    Explanation: s2 contains one permutation of s1 ("ba").
//    Example 2:
//
//    Input: s1 = "ab", s2 = "eidboaoo"
//    Output: false
    public static void main(String[] args) {
//        boolean ans = checkInclusion("ab", "eidbaooo");
        boolean ans = checkInclusion("ab", "eidboaoo");
        System.out.println(ans);
    }

    private static boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int i = 0;
        int j = 0;
        Map<Character, Integer> mp = new HashMap<>();
        for(char c: s1.toCharArray()){
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        int count = mp.size();
        while (j < s2.length()){
            if (mp.containsKey(s2.charAt(j))){
               int temp = mp.get(s2.charAt(j));
               mp.put(s2.charAt(j), --temp);
               if (mp.get(s2.charAt(j)) == 0){
                   count--;
               }
            }
            if (j-i+1 < k){
                j++;
            } else if (j - i + 1 == k) {
                if (count == 0){
                    return true;
                }
                if (mp.containsKey(s2.charAt(i))) {
                    mp.put(s2.charAt(i), mp.getOrDefault(s2.charAt(i), 0) + 1);
                    if (mp.get(s2.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return false;
    }
}
