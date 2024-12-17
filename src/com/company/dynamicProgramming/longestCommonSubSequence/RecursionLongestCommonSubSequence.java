package com.company.dynamicProgramming.longestCommonSubSequence;

public class RecursionLongestCommonSubSequence {

    public static void main(String[] args) {
        // Input: s1 = “AGGTAB”, s2 = “GXTXAYB”
        // Output: 4
        // Explanation: The longest common subsequence is “GTAB”.

        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int ans = longestCommonSubSequence(s1, s2, s1.length(), s2.length());
        System.out.print(ans);
    }

    private static int longestCommonSubSequence(String X, String Y, int n, int m) {
        // base condition
        if (n == 0 || m == 0) return 0;
        // choice diagram
        if (X.charAt(n - 1) == Y.charAt(m - 1)){
            return 1 + longestCommonSubSequence(X, Y, n-1, m-1);
        }else{
            return Math.max(longestCommonSubSequence(X, Y, n-1, m), longestCommonSubSequence(X, Y, n, m-1));
        }
    }
}
