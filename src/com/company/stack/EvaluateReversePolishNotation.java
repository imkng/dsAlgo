package com.company.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    // static String[] tokens = {"2","1","+","3","*"};
    // static String[] tokens = {"4","13","5","/","+"};
    static String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

    public static void main(String[] args) {
        int ans = evalRPN(tokens);
        System.out.println(ans);
    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("*") || tokens[i].equals("+") ||
                    tokens[i].equals("/") || tokens[i].equals("-")) {
                if (tokens[i].equals("*")) {
                    if (!stack.isEmpty() && stack.size() > 1) {
                        int first = stack.pop();
                        int second = stack.pop();
                        int result = first * second;
                        stack.push(result);
                    }
                    //else me bhi kuch ho skta hai?
                } else if (tokens[i].equals("/")) {
                    if (!stack.isEmpty() && stack.size() > 1) {
                        int first = stack.pop();
                        int second = stack.pop();
                        int result = (int) second / first;
                        stack.push(result);
                    }
                } else if (tokens[i].equals("+")) {
                    if (!stack.isEmpty() && stack.size() > 1) {
                        int first = stack.pop();
                        int second = stack.pop();
                        int result = first + second;
                        stack.push(result);
                    }
                } else if (tokens[i].equals("-")) {
                    if (!stack.isEmpty() && stack.size() > 1) {
                        int first = stack.pop();
                        int second = stack.pop();
                        int result = first - second;
                        stack.push(result);
                    }
                }
            } else {
                Integer temp = Integer.parseInt(tokens[i]);
                stack.push(temp);
            }
        }
        return stack.peek();
    }
}
