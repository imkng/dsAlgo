package com.company.arrays;

import java.util.*;

public class RearrangeArrayElementsBySign {
    //static int[] nums = {3,1,-2,-5,2,-4};
    static int[] nums = {-1, 1};
    public static void main(String[] args) {
        int[] ans = rearrangeArray(nums);
        for (int element : ans) {
            System.out.println(element);
        }
    }

    private static int[] rearrangeArray(int[] nums) {
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                neg.add(nums[i]);
            }else {
                pos.add(nums[i]);
            }
        }
        int[] ans = new int[nums.length];
        ans[0] = pos.poll();
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0){
                ans[i] = pos.poll();
            }else {
                ans[i] = neg.poll();
            }
        }
        return ans;
    }
}
