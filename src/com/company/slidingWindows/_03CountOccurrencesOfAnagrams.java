package com.company.slidingWindows;

import java.util.HashMap;
import java.util.Map;

public class _03CountOccurrencesOfAnagrams {
    static String str = "aabaabaa";
    static String ptr = "aaba";

//    static String str = "eaylnlfdxf";
//    static String ptr = "irc";

    public static void main(String[] args) {
        int ans = countOccurrencesOfAnagrams(str, ptr);
        System.out.println(ans);
    }

    private static int countOccurrencesOfAnagrams(String str, String ptr) {
        int ans = 0;
        int i = 0;
        int j = 0;
        int k = ptr.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int l = 0; l < ptr.length(); l++) {
            map.put(ptr.charAt(l), map.getOrDefault(ptr.charAt(l), 0) + 1);
        }
        int count = map.size();
        int n = str.length();
        while (j < n) {
            // calculation
            if (map.containsKey(str.charAt(j))) {
                map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) - 1);
                if (map.get(str.charAt(j)) == 0) {
                    count--;
                }
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (count == 0) {
                    ans++;
                }
                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
                    if (map.get(str.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
