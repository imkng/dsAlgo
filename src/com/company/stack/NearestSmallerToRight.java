package com.company.stack;

import java.util.Stack;

public class NearestSmallerToRight {
    static int[] array = new int[]{4, 5, 2, 10, 8};

    static int[] nearestSmallerToRight(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for(int i = arr.length - 1; i >=0; i--){
            if(stack.isEmpty()){
                ans[i] = -1;
            } else if (stack.peek() < arr[i]) {
                ans[i] = stack.peek();
            } else if (!stack.isEmpty() && stack.peek() >= arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    ans[i] = -1;
                }else {
                    ans[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] output = nearestSmallerToRight(array);
        //output : 2 2 -1 8 -1
        for (Integer element : output) {
            System.out.print(element + " ");
        }
    }
}
