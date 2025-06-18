package com.company.dynamicProgramming.longestCommonSubSequence;

public class TopDownApproach {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int ans = longestCommonSubSequence(s1, s2, s1.length(), s2.length());
        System.out.print(ans);
    }

    private static int longestCommonSubSequence(String x, String y, int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {

            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j ==0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (x.charAt(i-1) == y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }
}
