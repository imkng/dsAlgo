package com.company.dynamicProgramming.longestCommonSubSequence;

public class PrintLongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";

        String ans = printLongestCommonSubsequence(s1, s2, s1.length(), s2.length());
        System.out.print(ans);
    }

    private static String printLongestCommonSubsequence(String s1, String s2, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return findSubsequence(s1, s2, dp, m, n);
    }

    private static String findSubsequence(String s1, String s2, int[][] dp, int m, int n) {
        int i = m, j = n;
        StringBuilder stringBuilder = new StringBuilder("");
        
        while (i > 0 && j > 0){
            if (s1.charAt(i-1) == s2.charAt(j-1)){
                stringBuilder.append(s1.charAt(i-1));
                i--;
                j--;
            }else{
                if (dp[i-1][j] > dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        return stringBuilder.toString();
    }


}
