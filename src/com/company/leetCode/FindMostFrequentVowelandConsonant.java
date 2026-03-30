package com.company.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindMostFrequentVowelandConsonant {
//    You are given a string s consisting of lowercase English letters ('a' to 'z').
//
//    Your task is to:
//
//    Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
//    Find the consonant (all other letters excluding vowels) with the maximum frequency.
//    Return the sum of the two frequencies.
//
//            Note: If multiple vowels or consonants have the same maximum frequency, you may choose
//    any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.
//
//    The frequency of a letter x is the number of times it occurs in the string.
//
//
//    Example 1:
//
//    Input: s = "successes"
//
//    Output: 6
//
//    Explanation:
//
//    The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
//    The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
//    The output is 2 + 4 = 6.
//    Example 2:
//
//    Input: s = "aeiaeia"
//
//    Output: 3
//
//    Explanation:
//
//    The vowels are: 'a' (frequency 3), 'e' ( frequency 2), 'i' (frequency 2). The maximum frequency is 3.
//    There are no consonants in s. Hence, maximum consonant frequency = 0.
//    The output is 3 + 0 = 3.
    public static void main(String[] args) {
        int ans = maxFreqSum("successes");
        System.out.println(ans);
    }

    private static int maxFreqSum(String s) {
        int maxVowel = 0;
        int maxConsonant = 0;
//        Map<Character, Integer> mp = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//
//        }
        char[] charArr = s.toCharArray();
        Map<Character, Long> collect = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry<Character, Long> ele: collect.entrySet()){
            if (isVowel(ele.getKey())){
                maxVowel = Math.max(ele.getValue().intValue(), maxVowel);
            }else {
                maxConsonant =  Math.max(ele.getValue().intValue(), maxConsonant);
            }
        }
        return maxVowel + maxConsonant;
    }

    private static boolean isVowel(Character c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
