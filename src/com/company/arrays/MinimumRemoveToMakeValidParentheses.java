package com.company.arrays;

public class MinimumRemoveToMakeValidParentheses {
    //static String s = "lee(t(c)o)de)";
    static String s = "(a(b(c)d)";

    public static void main(String[] args) {
        String ans = minRemoveToMakeValid(s);
        System.out.println(ans);
    }

    private static String minRemoveToMakeValid(String s) {
        int open = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '('){
                open++;
            }else if(arr[i] == ')'){
                if (open == 0 ){
                    arr[i] = '*';
                }else{
                    open--;
                }
            }
        }
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (open >0 && arr[i] == '('){
                arr[i] = '*';
                open--;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
