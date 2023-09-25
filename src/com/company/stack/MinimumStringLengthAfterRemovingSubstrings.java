package com.company.stack;

import java.util.Stack;

//Input: s = "ABFCACDB"
//        Output: 2
//        Explanation: We can do the following operations:
//        - Remove the substring "ABFCACDB", so s = "FCACDB".
//        - Remove the substring "FCACDB", so s = "FCAB".
//        - Remove the substring "FCAB", so s = "FC".
//        So the resulting length of the string is 2.
//        It can be shown that it is the minimum length that we can obtain.
public class MinimumStringLengthAfterRemovingSubstrings {
    static String str = "ABFCACDB";

    private static int minLength(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == 'B'){
                if(!stack.isEmpty() && stack.peek() == 'A'){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }else if (c == 'D'){
                if(!stack.isEmpty() && stack.peek() == 'C'){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }else {
                stack.push(c);
            }
        }
        String temp = "";
        while ( !stack.isEmpty()){
            temp = temp + stack.peek();
            stack.pop();
        }
        return temp.length();
    }

    public static void main(String[] args) {
        int minimumLength = minLength(str);
        System.out.println(minimumLength);
    }


}
