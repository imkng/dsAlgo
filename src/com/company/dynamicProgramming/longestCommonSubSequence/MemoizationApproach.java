package com.company.dynamicProgramming.longestCommonSubSequence;

import java.util.Arrays;

public class MemoizationApproach {

    static int[][] dp = new int[100][100];
    static {
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int ans = longestCommonSubSequence(s1, s2, s1.length(), s2.length());
        System.out.print(ans);
    }


    private static int longestCommonSubSequence(String s1, String s2, int m, int n) {
        if (m== 0 || n == 0){
            return 0;
        }
        if (dp[m][n] != -1) return dp[m][n];
        if (s1.charAt(m-1) == s2.charAt(n-1)){
            return dp[m][n] = 1 + longestCommonSubSequence(s1, s2, m-1, n-1);
        }
        return dp[m][n] = Math.max(longestCommonSubSequence(s1, s2, m, n-1), longestCommonSubSequence(s1, s2, m-1, n));
    }
}
