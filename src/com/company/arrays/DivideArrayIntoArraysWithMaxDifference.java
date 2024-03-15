package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideArrayIntoArraysWithMaxDifference {
    //static int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
    static int[] nums = {1,3,3,2,7,3};
    //static int k = 2;
    static int k = 3;

    public static void main(String[] args) {

        int[][] ans = divideArray(nums, k);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] divideArray(int[] nums, int k) {
        int[][] result = new int[0][0];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i = i +3) {
            if ((i + 2 < nums.length) && (nums[i+2] - nums[i] <= k)){
                int[] triplet = {nums[i], nums[i+1], nums[i+2]};
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length-1] = triplet;
            }else {
                return new int[0][0];
            }
        }
        return result;
    }
}
