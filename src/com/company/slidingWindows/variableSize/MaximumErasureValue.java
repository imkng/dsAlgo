package com.company.slidingWindows.variableSize;

import java.util.HashMap;
import java.util.Map;

public class MaximumErasureValue {
//    You are given an array of positive integers nums and want to erase a subarray
//    containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
//
//    Return the maximum score you can get by erasing exactly one subarray.
//
//    An array b is called to be a subarray of a if it forms a contiguous
//    subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
//
//
//
//    Example 1:
//
//    Input: nums = [4,2,4,5,6]
//    Output: 17
//    Explanation: The optimal subarray here is [2,4,5,6].
//    Example 2:
//
//    Input: nums = [5,2,1,2,5,2,1,2,5]
//    Output: 8
//    Explanation: The optimal subarray here is [5,2,1] or [1,2,5].

    public static void main(String[] args) {
//        int[] nums = {4, 2, 4, 5, 6};
        int[] nums = {5,2,1,2,5,2,1,2,5};
        int ans = maximumUniqueSubarray(nums);
        System.out.println(ans);
    }

    private static int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0, j = 0;
        int maximumScore = Integer.MIN_VALUE;
        while (j < nums.length) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
            if (mp.size() == j - i + 1) {
                maximumScore = Math.max(maximumScore, findSum(mp));
            } else if (mp.size() < j - i + 1) {
                while (mp.size() < j - i + 1) {
                    mp.put(nums[i], mp.getOrDefault(nums[i], 0) - 1);
                    if (mp.get(nums[i]) == 0) {
                        mp.remove(nums[i]);
                    }
                    i++;
                }
                if (mp.size() == j - i + 1) {
                    maximumScore = Math.max(maximumScore, findSum(mp));
                }
            }
            j++;
        }
        return maximumScore;
    }

    private static int findSum(Map<Integer, Integer> mp) {
        int ans = 0;
        for (Map.Entry<Integer, Integer> ele : mp.entrySet()) {
            ans += ele.getKey();
        }
        return ans;
    }
}
