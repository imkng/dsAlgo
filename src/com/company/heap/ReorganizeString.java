package com.company.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    static String s = "aab";

    // Given a string s, rearrange the characters of s so that any two adjacent
    // characters are not the same.
    // Return any possible rearrangement of s or return "" if not possible.
    // Example 1:
    // Input: s = "aab"
    // Output: "aba"

    public static void main(String[] args) {
        String ans = reorganizeString(s);
        System.out.println(ans);
    }

    private static String reorganizeString(String s) {
        PriorityQueue<PairChar> maxHeap = new PriorityQueue<>((e1, e2) -> e2.freq - e1.freq);
        StringBuilder ans = new StringBuilder();
        int maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                int temp = map.get(s.charAt(i));
                map.put(s.charAt(i), ++temp);
            }
            if (maxCount < map.get(s.charAt(i))) {
                maxCount = map.get(s.charAt(i));
            }
        }
        if (maxCount > (s.length() + 1) / 2) {
            return "";
        }
        for (Map.Entry<Character, Integer> mp : map.entrySet()) {
            maxHeap.add(new PairChar(mp.getValue(), mp.getKey()));
        }
        while (!maxHeap.isEmpty()) {
            PairChar previousPair = maxHeap.poll();
            int n = ans.length();
            if (n >= 1 && ans.charAt(n - 1) == previousPair.character) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                PairChar nextPairChar = maxHeap.poll();
                ans.append(nextPairChar.character);
                nextPairChar.freq--;
                if (nextPairChar.freq != 0) {
                    maxHeap.add(nextPairChar);
                }
            } else {
                ans.append(previousPair.character);
                previousPair.freq--;
            }
            if (previousPair.freq != 0) {
                maxHeap.add(previousPair);
            }
        }

        return ans.toString();
    }
}
