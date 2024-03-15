package com.company.slidingWindows;

public class NumberOfSubstringsWithOnly1s {
    //static String s = "0110111";
    //static String s = "101";
    //static String s = "111111";
    static String s = "111111";
    public static void main(String[] args) {
        int ans = numSub(s);
        System.out.println(ans);
    }

    private static int numSub(String s) {
        int k = 1;
        int n = s.length();
        int count = 0;
        while (k <= n){
            for (int i = 0; i < n - k + 1; i++) {
                char[] temp = new char[k];
                for (int j = 0; j < k; j++) {
                    temp[j] = s.charAt(i+j);
                }
                if(containsAllOne(temp)){
                    count = (count + 1)%1000000007;
                }
            }
            k++;
        }
        return count;
    }

    private static boolean containsAllOne(char[] temp) {
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] != '1'){
                return false;
            }
        }
        return true;
    }
}
