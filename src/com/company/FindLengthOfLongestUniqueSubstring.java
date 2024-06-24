package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindLengthOfLongestUniqueSubstring {
    static String str = "aaAbcBC";

    public static void main(String[] args) {
        int len = getValueString(str);
        System.out.println(len);
    }

    private static int getValueString(String str) {
//        int ans = 0;
        int maxLength = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (!map.containsKey(str.charAt(i))) {
//                map.put(str.charAt(i), 1);
//            } else {
//                maxLength = Math.max(map.size(), maxLength);
//                map.clear();
//                i--;
//            }
//        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        Map<Integer, Integer> mp = new HashMap<>();
//        for (int i = 0; i < str.length(); i++) {
//            if(mp.containsKey(str.charAt(i) - 'a') || mp.containsKey(str.charAt(i)- 'A')){
//                maxLength++;
//            }else {
//                if (str.charAt(i) <= 90 && str.charAt(i) >= 65){
//                    mp.put(str.charAt(i) - 'A', 1);
//                }else{
//                    mp.put(str.charAt(i) - 'a', 1);
//                }
//            }
//        }

        return maxLength;
    }
}
