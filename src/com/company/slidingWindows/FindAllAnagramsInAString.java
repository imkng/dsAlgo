package com.company.slidingWindows;

import java.util.*;

public class FindAllAnagramsInAString {
    static String  s = "cbaebabacd", p = "abc";

    public static void main(String[] args) {
        List<Integer> ans = findAnagrams(s, p);
        System.out.println(ans);
    }

    private static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        int count = map.size();
        int i = 0, j = 0, k = p.length();
//        StringBuilder stringBuilder = new StringBuilder("");
        Queue<Character> list = new LinkedList<>();
        while (j < s.length()){
            if (map.containsKey(s.charAt(j))){
                int temp = map.get(s.charAt(j));
                map.put(s.charAt(j), --temp);
                list.add(s.charAt(j));
                if(map.get(s.charAt(j)) == 0){
                    count--;
                }
            }
            if(j-i+1 < k){
                j++;
            } else if (j-i+1 == k) {
                if(count == 0){
                    ans.add(i);
                }
                if (map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
                    if (map.get(s.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }

    private static boolean isAnagrams(StringBuilder stringBuilder, String p) {
        if (stringBuilder.length() != p.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (!map.containsKey(stringBuilder.charAt(i))){
                return false;
            }
            int temp = map.get(stringBuilder.charAt(i));
            map.put(stringBuilder.charAt(i), --temp);
        }
        for (Map.Entry<Character, Integer> mp : map.entrySet()){
            if(mp.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
