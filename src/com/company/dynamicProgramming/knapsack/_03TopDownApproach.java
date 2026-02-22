package com.company.dynamicProgramming.knapsack;

public class _03TopDownApproach {
    static int[] wt = {1, 3, 4, 5};
    static int[] val = {1, 4, 5, 7};
    //knapsack_weight
    static int W = 7;
    public static void main(String[] args) {
        int[][] t = new int[wt.length + 1][W + 1];

        int n = wt.length;

        // initialize t:
        // for (int i = 0; i < n + 1; i++){
        //    for (int j = 0; j < W + 1; j++) {
        //        if(i == 0 || j == 0){
        //            t[i][j] = 0;
        //        }
        //    }
        // }
        int maxProfit = findMaxProfit(wt, val, t, n, W);
        System.out.println("maxProfit: " + maxProfit);
    }

    private static int findMaxProfit(int[] wt, int[] val, int[][] t, int n, int w) {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if(wt[i - 1] <= j){
                    t[i][j] = Math.max((val[i - 1] + t[i-1][j - wt[i-1]]), t[i-1][j]);
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][w];
    }


}
