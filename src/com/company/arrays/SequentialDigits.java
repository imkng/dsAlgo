package com.company.arrays;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    // An integer has sequential digits if and only if each digit in the number is
    // one more than the previous digit.

    // Return a sorted list of all the integers in the range [low, high] inclusive
    // that have sequential digits.

    // Example 1:
    // Input: low = 100, high = 300
    // Output: [123,234]
    public static void main(String[] args) {
        List<Integer> ans = sequentialDigits(100, 300);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    private static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        String helper = "123456789";

        for (int i = 0; i < helper.length(); i++) {
            // j <= helper.length() -> substring(included, excluded)
            for (int j = i + 1; j <= helper.length(); j++) {
                int cur = Integer.parseInt(helper.substring(i, j));
                if(cur >= low && cur <= high){
                    ans.add(cur);
                }
            }
        }
        return ans;
    }
}
