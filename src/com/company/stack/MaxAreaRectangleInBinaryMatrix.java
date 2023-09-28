package com.company.stack;

import java.util.Stack;

public class MaxAreaRectangleInBinaryMatrix {
    static int[][] arr = {
            {0, 1, 1, 0},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0}
    };

    public static void main(String[] args) {
        int max_area_rectangle = maxAreaRectangle(arr);
        System.out.println(max_area_rectangle);
    }

    private static int maxAreaRectangle(int[][] arr) {
        int[] v = new int[arr[0].length];
        System.arraycopy(arr[0], 0, v, 0, arr[0].length);
        for (int value : v) {
            System.out.print(value + " ");
        }
        System.out.println();
        int maxArea = maximumAreaOfHistogram(v);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    v[j] = 0;
                } else {
                    v[j] = v[j] + arr[i][j];
                }

            }
            System.out.println();
            int area = maximumAreaOfHistogram(v);
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    private static int maximumAreaOfHistogram(int[] v) {
        int[] left = nearestSmallerToLeft(v);
        int[] right = nearestSmallerToRight(v);

        int[] width = new int[v.length];
        for (int i = 0; i < width.length; i++) {
            width[i] = right[i] - left[i] - 1;
        }
        int maxArea = -1;
        for (int i = 0; i < width.length; i++) {
            int area = width[i] * v[i];
            if (maxArea < area) {
                maxArea = area;
            }
        }
        return maxArea;
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
