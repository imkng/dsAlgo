package com.company.stack;

import java.util.Stack;

public class RemoveKDigits {
    static String num = "1432219";
    static int k = 3;

    public static void main(String[] args) {
        String minValue = removeKdigits(num, k);
        System.out.println(minValue);
    }

    private static String removeKdigits(String num, int k) {
        if (num.length() == k){
            return "0";
        }
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < num.length()){
            while ( k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();
        while (stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0'){
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }
}
