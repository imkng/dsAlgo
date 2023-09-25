package com.company.stack;

import java.util.Stack;

public class StockSpanProblem {
    static int[] stock = new int[]{100, 80, 60, 70, 75, 85};
    // output: 1 ,1 ,1 ,2 ,3 ,5

    public static void main(String[] args) {
        int[] output = stockSpan(stock);
        for (Integer element : output
        ) {
            System.out.print(element + " ");
        }
    }

    private static int[] stockSpan(int[] stock) {
        int[] ans = new int[stock.length];
        int[] temp = new int[stock.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < stock.length; i++) {
            if (stack.isEmpty()) {
                temp[i] = -1;
            } else if (!stack.isEmpty() && stack.peek()[0] > stock[i]) {
                temp[i] = stack.peek()[1];
            } else if (!stack.isEmpty() && stack.peek()[0] <= stock[i]) {
                while (!stack.isEmpty() && stack.peek()[0] <= stock[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    temp[i] = -1;
                } else {
                    temp[i] = stack.peek()[1];
                }
            }
            stack.push(new int[]{stock[i], i});
        }
        for (int i = 0; i < stock.length; i++) {
            ans[i] = i - temp[i];
        }
        return ans;
    }
}
