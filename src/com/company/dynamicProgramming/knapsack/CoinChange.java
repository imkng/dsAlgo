package com.company.dynamicProgramming.knapsack;

public class CoinChange {
    // You are given an integer array coins representing coins of different denominations and
    // an integer amount representing a total amount of money.

    // Return the fewest number of coins that you need to make up that amount.
    // If that amount of money cannot be made up by any combination of the coins, return -1.

    static int[] coins =  {2,5,10,1};
    static int amount = 27;
    public static void main(String[] args) {
        int ans = coinChange(coins, amount);
        System.out.println(ans);
    }

    private static int coinChange(int[] coins, int amount) {
        int[][] t = new int[coins.length + 1][amount + 1];

        for (int i = 0; i < amount + 1; i++) {
            t[0][i] = - 1;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            t[i][0] = 0;
        }
        // Second Row initialization
        for (int i = 1; i < amount + 1; i++) {
            if (i%coins[0] == 0){
                t[1][i] = i/coins[0];
            }else {
                t[1][i] = - 1;
            }
        }

        for (int i = 2; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i-1] <= j){
                    t[i][j] = Math.min(1 + t[i][j - coins[i-1]], t[i-1][j]);
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
//        return t[coins.length][amount];
        int ans;
        ans  = t[coins.length][amount] == Integer.MAX_VALUE-1 ? -1 : t[coins.length][amount];
        return ans;

    }
}
