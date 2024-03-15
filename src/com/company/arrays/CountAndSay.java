package com.company.arrays;

public class CountAndSay {
    public static void main(String[] args) {
        int n = 4;
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = countAndStore(s);
        }
        System.out.println(s);
    }

    private static String countAndStore(String s) {
        StringBuilder ans = new StringBuilder();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == c) count++;
            else {
                ans.append(count);
                ans.append(c);
                c = s.charAt(i);
                count = 1;
            }
        }
        ans.append(count);
        ans.append(c);
        return ans.toString();
    }
}
