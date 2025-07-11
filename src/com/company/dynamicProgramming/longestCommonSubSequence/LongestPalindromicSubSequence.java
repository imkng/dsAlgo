package com.company.dynamicProgramming.longestCommonSubSequence;

public class LongestPalindromicSubSequence {
//    Given a string s, find the longest palindromic subsequence's length in s.
//
//    A subsequence is a sequence that can be derived from another sequence by deleting
//    some or no elements without changing the order of the remaining elements.
//
//
//
//    Example 1:
//
//    Input: s = "bbbab"
//    Output: 4
//    Explanation: One possible longest palindromic subsequence is "bbbb".
//      solution:- If we take reverse of s "babbb", then apply LCS(s, reverse(s)
//    Example 2:
//
//    Input: s = "cbbd"
//    Output: 2
//    Explanation: One possible longest palindromic subsequence is "bb".

    public static void main(String[] args) {
//        String s = "bbbab";
        String s = "cbbd";
        int ans = longestPalindromeSubseq(s);
        System.out.println(ans);
    }

    private static int longestPalindromeSubseq(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int ans = longestCommonSubSequence(s1, s2, s1.length(), s2.length());
        return ans;
    }

    private static int longestCommonSubSequence(String s1, String s2, int n, int m) {
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < m+1; i++){
            dp[0][i] = 0;
        }
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m + 1 ; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];

    }

}
