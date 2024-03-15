package com.company.dynamicProgramming.knapsack;

public class CountSubsetWithAGivenSum {

    static int[] arr = {2, 3, 5, 6, 7, 8, 10};
    static int sum = 10;
    public static void main(String[] args) {
        int countSubset = countSubsetWithAGivenSum(arr, sum);
        System.out.println(countSubset);
    }

    private static int countSubsetWithAGivenSum(int[] arr, int sum) {
        int n = arr.length;
        int ans = 0;
        //initialize the array
        int[][] table = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i == 0){
                    table[i][j] = 0;
                }
                if(j == 0){
                    table[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++){
                if (arr[i-1] <= j){
                    table[i][j] = table[i-1][j] + table[i-1][j - arr[i-1]];
                }else {
                    table[i][j] = table[i-1][j];
                }
            }
        }
        ans = table[n][sum];
        return ans;
    }
}
