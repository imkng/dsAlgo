package com.company.dynamicProgramming.knapsack;

public class SubSetSum {
    static int[] arr = {2, 8, 7, 3, 10};
    static int sum = 11;
    public static void main(String[] args) {
        boolean subset = subSetSumPossible(arr, sum);
        System.out.println(subset);
    }

    private static boolean subSetSumPossible(int[] arr, int sum) {
        int n = arr.length;
        int w = sum + 1;
        boolean[][] t = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
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
            for (int j = 1; j < sum + 1; j++){
                if (arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else {
                    t[i][j]= t[i-1][j];
                }
            }
        }
        return t[arr.length][sum];
    }
}
