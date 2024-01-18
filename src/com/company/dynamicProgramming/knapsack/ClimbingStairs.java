package com.company.dynamicProgramming.knapsack;

public class ClimbingStairs {
    static int[] dp = new int[46];

    public static void main(String[] args) {
        int numberOfPossibleWays = climbStairs(5);
        System.out.println(numberOfPossibleWays);
    }
    static private int climbStairs(int n) {
        for(int i = 0; i < 46; i++){
            dp[i] = -1;
        }
        return countPossible(n , dp);
    }

    static int countPossible(int n, int[] dp){
        if(n < 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        return dp[n] = countPossible(n-1, dp) + countPossible(n-2, dp);
    }
}
