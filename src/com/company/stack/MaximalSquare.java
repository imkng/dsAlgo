package com.company.stack;

import java.util.Stack;

public class MaximalSquare {

    static char[][] matrix = {
            {'1', '0', '1', '0', '1'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
    };

    public static void main(String[] args) {
        int[][] arr = convertMatrixToInt(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int max_area_rectangle = maximalSquare(matrix);
        System.out.println(max_area_rectangle);
    }
    public static int maximalSquare(char[][] matrix) {
        int[][] arr = convertMatrixToInt(matrix);
        int max_area_rectangle =  maxAreaRectangle(arr);
        return max_area_rectangle;
    }

    private static int maxAreaRectangle(int[][] arr) {
        int[] v = new int[arr[0].length];
        for (int j = 0; j < arr[0].length; j++) {
            v[j] = arr[0][j];
        }
        int maxArea = maximumAreaOfHistogram(v);

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0){
                    v[j] = 0;
                }else {
                    v[j] = v[j] + arr[i][j];
                }
            }
            int area = maximumAreaOfHistogram(v);
            if (area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
    private static int maximumAreaOfHistogram(int[] v) {
        int[] left = nearestSmallerToLeft(v);
        int[] right = nearestSmallerToRight(v);

        int[] width = new int[v.length];
        for (int i = 0; i < v.length; i++) {
            width[i] = right[i] - left[i] - 1;
        }
        int maxArea = 0;
        for (int i = 0; i < v.length; i++) {
            if(width[i] == v[i]){
                int area = width[i] * v[i];
                if(area > maxArea){
                    maxArea = area;
                }
            }

        }
        return maxArea;
    }
    private static int[] nearestSmallerToRight(int[] v) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[v.length];
        int pseudo = v.length;
        for (int i = v.length - 1; i >=0; i--) {
            if(stack.isEmpty()){
                ans[i] = pseudo;
            } else if (!stack.isEmpty() && stack.peek()[0] < v[i]) {
                ans[i] = stack.peek()[1];
            }else if (!stack.isEmpty() && stack.peek()[0] >= v[i]){
                while (!stack.isEmpty() && stack.peek()[0] >= v[i]){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    ans[i] = pseudo;
                }else {
                    ans[i] = stack.peek()[1];
                }
            }
            stack.push(new int[]{v[i], i});
        }
        return ans;
    }

    private static int[] nearestSmallerToLeft(int[] v) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[v.length];
        int pseudo = -1;
        for (int i = 0; i < v.length; i++) {
            if(stack.isEmpty()){
                ans[i] = pseudo;
            } else if (!stack.isEmpty() && stack.peek()[0] < v[i]) {
                ans[i] = stack.peek()[1];
            }else if (!stack.isEmpty() && stack.peek()[0] >= v[i]){
                while (!stack.isEmpty() && stack.peek()[0] >= v[i]){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    ans[i] = pseudo;
                }else {
                    ans[i] = stack.peek()[1];
                }
            }
            stack.push(new int[]{v[i], i});
        }
        return ans;
    }
    private static int[][] convertMatrixToInt(char[][] matrix) {
        int[][] arr = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int a = matrix[i][j] - '0';
                arr[i][j] = a;
            }
        }
        return arr;
    }
}
