package com.company.contest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumofDigitDifferencesOfAllPairs {
    static int[] nums = {10,10,10,10};

    public static void main(String[] args) {
        int ans = sumDigitDifferences(nums);
        System.out.println(ans);
    }

    private static int sumDigitDifferences(int[] nums) {

        int ans = 0;

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int count = countDiff(nums[i], nums[j]);
                ans += count;
            }
        }
        return ans;
    }

    private static int countDiff(int num, int num1) {
        int ans = 0;
        while (num!=0 && num1 != 0){
            int temp1 = num1%10;
            int temp2 = num%10;
            if (temp1 != temp2){
                ans++;
            }
            num = num/10;
            num1 = num1/10;
        }
        return ans;
    }
}
