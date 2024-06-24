package com.company.dynamicProgramming.unboundedKnapsack;

public class RodCuttingProblem {
    static int[] lengthSize = {1,2,3,4,5,6,7,8};

    static int lengthOfRod = 8;
    static int[] price = {1, 5, 8, 9, 10,17, 17, 20};
    // cut the rod such that get maximum profit
    // len of 5 + len of 3 = profit(10+80)
    // len of 2 * 4 times = profit(20)
    // len of 6 + len of 2 = profit(17+5)
    public static void main(String[] args) {

        int ans = maximumProfit(lengthSize, price, lengthOfRod);
        System.out.println(ans);

    }

    private static int maximumProfit(int[] lengthSize, int[] price, int lengthOfRod) {
        int N = lengthSize.length;
        int W = price.length;
        int [][] t = new int[N + 1][W+ 1];
        for (int i = 0; i < W; i++) {
            t[0][i] = 0;
        }
        t[0][0] = 0;
        for (int i = 1; i < N + 1; i++) {
            t[0][i] = 0;
            for (int j = 0; j < W + 1; j++) {
                if (lengthSize[i-1] <= j){
                    t[i][j] = Math.max(price[i-1] + t[i][j-lengthSize[i-1]], t[i-1][j]);
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[N][W];
    }
}
