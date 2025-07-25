package com.company.slidingWindows.variableSize;

import java.util.HashMap;
import java.util.Map;

public class MaximumUniqueSubarraySumAfterDeletion {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5};
//        int[] nums = {1,1,0,1,1};
        int[] nums = {1,2,-1,-2,1,0,5};
        System.out.println(maxSum(nums));
    }

    private static int maxSum(int[] nums) {
        int i =0, j = 0;
        int maxSum = Integer.MIN_VALUE;
        Map<Integer, Integer> mp = new HashMap<>();
        while (j < nums.length){
            mp.put(nums[j], mp.getOrDefault(nums[j], 0)+1);
            if (mp.size() == j - i + 1){
                maxSum = Math.max(maxSum, findSum(mp));
            }else if (mp.size() < j - i + 1){
                while (mp.size() < j - i + 1){
                    mp.put(nums[i], mp.getOrDefault(nums[i], 0) - 1);
                    i++;
                }
                if (mp.size() == j - i + 1){
                    maxSum = Math.max(maxSum, findSum(mp));
                }
            }
            j++;
        }
        return maxSum;
    }

    private static int findSum(Map<Integer, Integer> mp) {
        int ans = 0;
        for (Map.Entry<Integer, Integer> ele: mp.entrySet()){
            ans += ele.getKey();
        }
        return ans;
    }
}
