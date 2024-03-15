package com.company.arrays;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    // A string s is called good if there are no two different characters in s
    // that have the same frequency.

    //Given a string s, return the minimum number of characters you need to delete to make s good.

    //The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.



    // Example 1:

    // Input: s = "aab"
    // Output: 0
    // Explanation: s is already good.

    static String s = "aaabbbcc";

    //op: 2;
    //Explanation: You can delete two 'b's resulting in the good string "aaabcc".
    //Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".

    public static void main(String[] args) {
        int ans = minDeletions(s);
        System.out.println(ans);
    }

    private static int minDeletions(String s) {
        int[] charStore = new int[26];


        for (char c : s.toCharArray()) {
            charStore[c - 'a']++;
        }
        Set<Integer> integerSet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < 26; i++) {
            int freq = charStore[i];
            while (freq > 0 && integerSet.contains(freq)){
                freq--;
                count++;
            }
            integerSet.add(freq);
        }
        return count;
    }
}
