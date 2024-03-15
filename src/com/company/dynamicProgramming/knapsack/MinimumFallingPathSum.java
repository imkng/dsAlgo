package com.company.dynamicProgramming.knapsack;

import java.util.Arrays;

public class MinimumFallingPathSum {
    static int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

    public static void main(String[] args) {
        int ans = minFallingPathSum(matrix);
        System.out.println(ans);
    }

    private static int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int[] row :
                dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int col = 0; col < matrix[0].length; col++) {
            ans = Math.min(ans, findMinimumFallingPath(matrix, 0, col, dp));
        }
        return ans;
    }

    private static int findMinimumFallingPath(int[][] matrix, int row, int col, int[][] dp) {
        int n = matrix.length;
        int m = matrix[0].length;

        if (dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }
        if (row == n - 1){
            return dp[row][col] = matrix[row][col];
        }
        int leftDiagonal = Integer.MAX_VALUE;
        int rightDiagonal = Integer.MAX_VALUE;
        int straight = Integer.MAX_VALUE;

        if (col > 0){
            leftDiagonal = findMinimumFallingPath(matrix, row + 1, col -1, dp);
        }
        straight = findMinimumFallingPath(matrix, row+1, col, dp);

        if(col < m-1) {
            rightDiagonal = findMinimumFallingPath(matrix, row + 1, col + 1, dp);
        }

        return dp[row][col] = Math.min(leftDiagonal, Math.min(straight, rightDiagonal)) + matrix[row][col];
    }
}
