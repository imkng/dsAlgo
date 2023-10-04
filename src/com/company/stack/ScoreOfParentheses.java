package com.company.stack;

import java.util.Stack;

public class ScoreOfParentheses {
    static String parentheses = "(())()(())((()))";

    public static void main(String[] args) {
        int score = scoreOfParentheses(parentheses);
        System.out.println(score);
    }

    private static int scoreOfParentheses(String parentheses) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);
            if (c == '('){
                stack.push(-1);
            }else {
                int cur = 0;
                while (stack.peek() != -1){
                    cur += stack.pop();
                }
                stack.pop();
                stack.push(cur == 0 ? 1 : 2*cur);
            }
        }
        int sore = 0;
        while (!stack.isEmpty()){
            sore += stack.peek();
            stack.pop();
        }
        return sore;
    }
}
