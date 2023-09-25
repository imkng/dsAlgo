package com.company.stack;

import java.util.Stack;

public class DailyTemperature {
    //    Given an array of integers temperatures represents the daily temperatures
    //    , return an array answer such that answer[i] is the number of days you have to
    //    wait after the ith day to get a warmer temperature. If there is no future
    //    day for which this is possible, keep answer[i] == 0 instead

    public static int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

    //    output :{1,1,4,2,1,1,0,0}
    public static void main(String[] args) {
        int[] output = dailyTemperatures(temperatures);
        for (Integer element : output
        ) {
            System.out.print(element + " ");
        }
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] temp = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                temp[i] = 0;
            } else if (!stack.isEmpty() && stack.peek()[0] > temperatures[i]) {
                temp[i] = stack.peek()[1] - i;
            } else if (!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) {
                while (!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    temp[i] = 0;
                } else {
                    temp[i] = stack.peek()[1] - i;
                }
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return temp;
    }
}
