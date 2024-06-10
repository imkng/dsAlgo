package com.company.slidingWindows.variableSize;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {

    //static String S = "aabacbebebe";
    //static int K = 3;
    static String S = "aaaa";
    static int K = 2;
    //Input: Str = “aabbcc”, k = 1
    //Output: 2
    // Explanation: Max substring can be any one from {“aa” , “bb” , “cc”}.

    // Input: Str = “aabbcc”, k = 2
    // Output: 4
    // Explanation: Max substring can be any one from {“aabb” , “bbcc”}.

    // Input: Str = “aabbcc”, k = 3
    // Output: 6
    // Explanation:
    // There are substrings with exactly 3 unique characters
    // {“aabbcc” , “abbcc” , “aabbc” , “abbc” }
    // Max is “aabbcc” with length 6.

    // Input: Str = “aaabbb”, k = 3
    // Output: Not enough unique characters

    public static void main(String[] args) {
        int ans = longestkSubstr(S, K);
        System.out.println(ans);
    }

    private static int longestkSubstr(String s, int k) {
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();
        int longLength = Integer.MIN_VALUE;
        while (j < s.length()) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                longLength = Math.max(longLength, j - i + 1);
                j++;
            } else if (map.size() > k) {
                while (map.size() > k) {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                    if (map.get(s.charAt(i)) == 0) {
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
                if (map.size() == k) {
                    longLength = Math.max(longLength, j - i + 1);
                }
                j++;
            }
        }
        return longLength == Integer.MIN_VALUE ? -1 : longLength;
    }
}
