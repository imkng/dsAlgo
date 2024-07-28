package com.company.arrays;

import java.util.Arrays;

public class AppendKIntegersWithMinimalSum {

     //static int[] nums = {1,4,25,10,25};
     //static int k = 2;
//    static int[] nums = {23767857,21565918,85047221,44602805,11800671,35095294,970673,88859293,73171470,37153084,87889470,72219057,79109884,38623962,62878542,58062287,99994523,3107671};
//    static int k = 970673;
     static int[] nums = {5,6};
     static int k = 6;
    public static void main(String[] args) {
        var minSum = minimalKSum(nums, k);
//        System.out.println(minSum);

        var ans = minimal(nums, k);
        System.out.println(ans);
    }

    private static long minimal(int[] nums, int k) {
        long ans = 0;
        Arrays.sort(nums);
        if (nums[0] == 1){
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i-1]){
                    int diff = nums[i] - (nums[i-1] + 1);
                    for (int j = 1; j <= diff && k > 0; j++) {
                        ans += nums[i-1] + j;
                        k--;
                    }
                    if (k == 0){
                        return ans;
                    }
                }
            }
        }else{
            int diff = nums[0] -1;
            for (int i = 1; i <= diff && k>0; i++) {
                ans+=i;
                k--;
            }
            if (k == 0){
                return ans;
            }
            for (int i = 1; i < nums.length; i++) {
                int diff1 = nums[i] - (nums[i-1] + 1);
                for (int j = 1; j <= diff1 && k > 0; j++) {
                    ans += nums[i-1] + j;
                    k--;
                }
                if (k == 0){
                    return ans;
                }
            }
        }
        while (k!= 0){
            ans += (nums[nums.length-1] + k);
            k--;
        }

        return ans;
    }

    private static long minimalKSum(int[] nums, int k) {
        int maxElement = -1;
        for (int i = 0; i < nums.length; i++) {
            if (maxElement < nums[i]){
                maxElement = nums[i];
            }
        }
        int [] temp = new int[maxElement + 1];
        temp[0] = -1;
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]] ++;
        }
        long minSum = 0;
        for (int i = 1; i < temp.length && k > 0; i++) {
            if (temp[i] == 0){
                minSum += i;
                k--;
            }
        }
        while (k!= 0){
            minSum += (maxElement + k);
            k--;
        }
        return minSum;

        // ?? leads Memory Limit Exceeded
    }



}
