package com.company.slidingWindows.variableSize;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    static String s = "abcabcbb";
    // static String s = "bbbbb";
    //static String s = "pwwkew";
    //static String s = "au";
    public static void main(String[] args) {
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);
    }

    private static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() == j-i+1){
                maxLength = Math.max(maxLength, j-i+1);
            }else if (map.size() < j-i+1){
                while (map.size() < j-i+1){
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) -1);
                    if (map.get(s.charAt(i)) == 0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                if (map.size() == j - i + 1){
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
            j++;
        }
        return maxLength;
    }
}
