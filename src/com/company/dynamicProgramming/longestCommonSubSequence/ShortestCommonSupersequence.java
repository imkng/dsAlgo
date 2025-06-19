package com.company.dynamicProgramming.longestCommonSubSequence;

public class ShortestCommonSupersequence {
//    Input: s1 = "geek", s2 = "eke"
//    Output: 5
//    Explanation: String "geeke" has both string "geek" and "eke" as subsequences.
//
//    Input: s1 = "AGGTAB", s2 = "GXTXAYB"
//    Output:  9
//    Explanation: String "AGXGTXAYB" has both string "AGGTAB" and "GXTXAYB" as subsequences.
    public static void main(String[] args) {

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int ans = shortestCommonSupersequence(s1, s2);
        System.out.println(ans);
    }

    private static int shortestCommonSupersequence(String s1, String s2) {
        return s1.length() + s2.length() - longestCommonSub(s1, s2, s1.length(), s2.length());
    }

    private static int longestCommonSub(String x, String y, int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n+1; i++) {
            dp[0][i] = 0;
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
