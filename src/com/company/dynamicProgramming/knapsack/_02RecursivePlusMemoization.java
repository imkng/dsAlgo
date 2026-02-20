package com.company.dynamicProgramming.knapsack;

public class _02RecursivePlusMemoization {
    int[] wt = {1, 3, 4, 5};
    int[] val = {1, 4, 5, 7};
    int[][] t = new int[102][1002];

    public int recursivePlusMemoization(int[] wt, int[] val, int W, int n){
        if(n == 0 || W == 0) return 0;

        if(wt[n-1] <= W){
            return t[n][W] = Math.max(val[n-1] + recursivePlusMemoization(wt, val, W - wt[n-1], n-1),
                    recursivePlusMemoization(wt, val, W , n-1));
        }else{
            return t[n][W] = recursivePlusMemoization(wt, val, W , n-1);
        }
    }
}
