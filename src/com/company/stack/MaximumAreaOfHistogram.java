package com.company.stack;

import java.util.Stack;

public class MaximumAreaOfHistogram {
    static int[] arr = new int[]{6, 2, 5, 4, 5, 1, 6}; //height

    public static void main(String[] args) {
        int[] left = nearestSmallerToLeft(arr);
        int[] right = nearestSmallerToRight(arr);

        printArr(left);
        printArr(right);

        int[] width = new int[arr.length];
        for (int i = 0; i < width.length; i++) {
            width[i] = right[i] - left[i] - 1;
        }
        printArr(width);

        int maxArea = -1;
        for (int i = 0; i < width.length; i++) {
            int area = width[i] * arr[i];
            if (maxArea < area) {
                maxArea = area;
            }
        }
        System.out.println(maxArea);
    }

    private static void printArr(int[] left) {
        for (Integer element : left) {
            System.out.print(element + " ");
        }
        System.out.println();
    }


    private static int[] nearestSmallerToRight(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[arr.length];
        int pseudo = arr.length;

        for (int i = ans.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                ans[i] = pseudo;
            } else if (!stack.isEmpty() && stack.peek()[0] < arr[i]) {
                ans[i] = stack.peek()[1];
            } else if (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = pseudo;
                } else {
                    ans[i] = stack.peek()[1];
                }
            }
            stack.push(new int[]{arr[i], i});
        }
        return ans;
    }

    private static int[] nearestSmallerToLeft(int[] arr) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[arr.length];

        for (int i = 0; i < ans.length; i++) {
            if (stack.isEmpty()) {
                ans[i] = -1;
            } else if (!stack.isEmpty() && stack.peek()[0] < arr[i]) {
                ans[i] = stack.peek()[1];
            } else if (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans[i] = -1;
                } else {
                    ans[i] = stack.peek()[1];
                }
            }
            stack.push(new int[]{arr[i], i});
        }
        return ans;
    }
}
