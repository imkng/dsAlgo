package com.company.stack;

import java.util.Stack;

public class NearestSmallerToLeft {
    static int[] array = new int[]{4, 5, 2, 10, 8};

    static int[] nearestSmallerToLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else if (!stack.isEmpty() && stack.peek() < arr[i]) {
                ans[i] = stack.peek();
            } else if (!stack.isEmpty() && stack.peek() >= arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] output = nearestSmallerToLeft(array);
        //output : {-1, 4, -1, 2, 2 }
        for (int j : output) {
            System.out.print(j + " ");
        }
    }
}
