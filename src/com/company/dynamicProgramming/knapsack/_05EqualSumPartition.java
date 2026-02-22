package com.company.dynamicProgramming.knapsack;

public class _05EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {2, 8, 7, 2, 10};

        boolean ans = isEqualSumPossible(arr);
        System.out.println(ans);
    }

    private static boolean isEqualSumPossible(int[] arr) {
        int sum = 0; // for equal sum total sum should be even

        for(int ele: arr){
            sum += ele;
        }
        if (sum%2 != 0) return false;

        return subsetSum(arr, sum/2);
    }

    private static boolean subsetSum(int[] arr, int sum){
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if( i == 0) dp[i][j] = false;
                if (j == 0) dp[i][j] = true;
            }
        }

        for(int i = 1; i < arr.length + 1; i++){
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];

    }
}
