package com.company.arrays;


public class MaximumNestingDepthOfTheParentheses {
    static String s = "(1+(2*3)+((8)/4))+1";

//    A string is a valid parentheses string (denoted VPS) if it meets one of the following:
//
//    It is an empty string "", or a single character not equal to "(" or ")",
//    It can be written as AB (A concatenated with B), where A and B are VPS's, or
//    It can be written as (A), where A is a VPS.
//    We can similarly define the nesting depth depth(S) of any VPS S as follows:
//
//    depth("") = 0
//    depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
//    depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
//    depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
//    For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.
//
//    Given a VPS represented as string s, return the nesting depth of s.
//
//
//
//            Example 1:
//
//    Input: s = "(1+(2*3)+((8)/4))+1"
//    Output: 3
//    Explanation: Digit 8 is inside of 3 nested parentheses in the string.
//            Example 2:
//
//    Input: s = "(1)+((2))+(((3)))"
//    Output: 3


    public static void main(String[] args) {
        int ans = maxDepth(s);
        System.out.println(ans);
    }

    private static int maxDepth(String s) {
//        Stack<Character> stack = new Stack<>();
        if (s.isEmpty() || s.length() == 1) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
//                stack.push(s.charAt(i));
                temp++;
                res = Math.max(temp, res);
            } else if (s.charAt(i) == ')') {
                temp--;
            }
        }
        return res;
    }
}
