package com.company.dynamicProgramming.knapsack;

import java.util.Arrays;

public class MinimumSubsetSumDifference {
    static int[] arr =  {1, 6, 11, 5};

    public static void main(String[] args) {
        int ans = minDifference(arr);
        System.out.println(ans);
    }

    private static int minDifference(int[] arr) {
        int n = arr.length;
        int range = 0;
        for (int element :
                arr) {
            range += element;
        }
        // initialize table with first row false and first colm true
        boolean [][] t = new boolean[n+1][range+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < range + 1; j++) {
                if (i == 0){
                    t[i][j] = false;
                }
                if(j == 0){
                    t[i][j] = true;
                }
            }
        }
        //subset exit?
        subsetSum(arr, t, n, range);

        //extract value of sum based on true from t
        int [] v = new int[(int)range/2+1];
        Arrays.fill(v, -1);
        for (int i = 0; i <= range/2; i++) {
            if (t[n][i]){
                v[i] = i;
            }
        }
        int minDif = Integer.MAX_VALUE;
        for (int j : v) {
            if (j != -1) {
                minDif = Math.min(minDif, range - 2 * j);
            }
        }
        return  minDif;
    }

    private static void subsetSum(int [] arr, boolean[][] t, int n, int range) {
        for (int i = 1; i < n + 1; i++) {
             for (int j = 1; j < range + 1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
    }
}
