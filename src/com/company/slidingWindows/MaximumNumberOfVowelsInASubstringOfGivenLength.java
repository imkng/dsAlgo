package com.company.slidingWindows;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    static String s = "rhythms";
    static int k = 4;
    public static void main(String[] args) {
        int ans = maxVowels(s, k);
        System.out.println(ans);
    }

    private static int maxVowels(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1);
        map.put('e', 1);
        map.put('i', 1);
        map.put('o', 1);
        map.put('u', 1);
        int i = 0, j = 0;
        int ans = 0;
        Queue<Character> queue = new LinkedList<>();
        while (j < s.length()){
            if (map.containsKey(s.charAt(j))){
                queue.add(s.charAt(j));
            }
            if (j-i + 1 < k){
                j++;
            }else if (j-i+1 == k){
                ans = Math.max(ans, queue.size());
                if (!queue.isEmpty() && queue.peek() == s.charAt(i)){
                    queue.poll();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
