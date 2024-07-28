package com.company.arrays;

public class ScoreOfAString {
    static String s = "hello";
    public static void main(String[] args) {
        int ans = scoreOfString(s);
        System.out.println(ans);
        System.out.println(((char) ('a' + ans)));
    }

    private static int scoreOfString(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            ans += Math.abs(s.charAt(i) - s.charAt(i-1));
        }
        return ans;
    }
}
