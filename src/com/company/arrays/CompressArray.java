package com.company.arrays;

import java.util.Stack;

public class CompressArray {
    static int arr[] = new int[]{1, 3, 2, 5,4};
    static int k = 6;

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        if (arr[0] <= k){
            stack.push(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] * stack.peek() <= k){
                    int temp = stack.pop();
                    stack.push(arr[i] * temp);
                }else {
                    stack.push(arr[i]);
                }
            }
            System.out.println(stack.size());
        }else {
            stack.push(arr[0]);
            stack.push(arr[1]);
            for (int i = 2; i < arr.length; i++) {
                if(arr[i] * stack.peek() <= k){
                    int temp = stack.pop();
                    stack.push(arr[i] * temp);
                }else {
                    stack.push(arr[i]);
                }
            }
            System.out.println(stack.size());
        }
    }
}
