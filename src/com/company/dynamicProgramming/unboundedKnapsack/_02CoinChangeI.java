package com.company.dynamicProgramming.unboundedKnapsack;

public class _02CoinChangeI {
//    Given an integer array coins[ ] representing different denominations of currency and an integer sum.
//    We need to find the number of ways we can make sum by using different combinations from coins[ ].
//    Note: Assume that we have an infinite supply of each type of coin. Therefore, we can use any coin as
//    many times as we want.
//
//            Examples:
//
//    Input: sum = 4, coins[] = [1, 2, 3]
//    Output: 4
//    Explanation: There are four solutions: [1, 1, 1, 1], [1, 1, 2], [2, 2] and [1, 3]
//
//    Input: sum = 10, coins[] = [2, 5, 3, 6]
//    Output: 5
//    Explanation: There are five solutions:
//            [2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5]

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int sum = 4;
        int ans = count(arr, sum);
        System.out.println(ans);
    }

    private static int count(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j]+ dp[i][j - arr[i-1]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
