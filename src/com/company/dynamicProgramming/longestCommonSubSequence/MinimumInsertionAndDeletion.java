package com.company.dynamicProgramming.longestCommonSubSequence;

public class MinimumInsertionAndDeletion {
//    Input: s1 = "heap", s2 = "pea"
//    Output: 3
//    Explanation: Minimum Deletion = 2 and Minimum Insertion = 1
//    p and h are deleted from the heap, and then p is inserted at the beginning. One thing to note, though p was required it was removed/deleted first from its position and then it was inserted into some other position. Thus, p contributes one to the deletion count and one to the insertion count.
//
//            Input: s1 = "geeksforgeeks", s2 = "geeks"
//    Output: 8
//    Explanation: 8 deletions, i.e. remove all characters of the string "forgeeks".


    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int res = minOperations(s1, s2);
        System.out.println(res);
    }

    private static int minOperations(String s1, String s2) {
        int lcsLength = logestCommonSub(s1, s2, s1.length(), s2.length());
        int mindeletion = s1.length() - lcsLength;
        int minInsetion = s2.length() - lcsLength;
        return mindeletion + minInsetion;
    }

    private static int logestCommonSub(String s1, String s2, int m, int n) {
        int dp[][] = new int[m+1][n+1];
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
        return dp[m][n];
    }
}
