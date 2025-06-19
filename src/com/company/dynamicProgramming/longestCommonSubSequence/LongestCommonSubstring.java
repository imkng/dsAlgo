package com.company.dynamicProgramming.longestCommonSubSequence;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";

        int ans = longestCommonSubString(s1, s2, s1.length(), s2.length());
        System.out.print(ans);
    }

    private static int longestCommonSubString(String s1, String s2, int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n+1; i++) {
            dp[0][i] = 0;
        }
//        for (int i = 0; i < m + 1; i++) {
//            for (int j = 0; j < n + 1; j++) {
//                if (i == 0 || j == 0) {
//                    dp[i][j] = 0;
//                }
//            }
//        }

        for (int i = 1; i < m + 1; i++){
            for (int j = 1; j < n+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n+1; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
