package com.company.dynamicProgramming.knapsack;

public class Partition_Equal_Subset_Sum {
    static int[] nums = {1,5,11,5, 2};

    public static void main(String[] args) {
        boolean ans = canPartition();
        System.out.println(ans);
    }

    private static boolean canPartition() {
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
        }
        if (sum % 2 != 0){
            return false;
        }
        boolean ans = subSetSumPossible(nums, sum/2);
        return ans;
    }

    private static boolean subSetSumPossible(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i == 0){
                    t[i][j] = false;
                }
                if (j == 0){
                    t[i][j] = true;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j){
                    t[i][j] = t[i-1][j - nums[i-1]] || t[i-1][j];
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
