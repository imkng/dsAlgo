package com.company.dynamicProgramming.knapsack;


public class FibonacciNumber {
    static int[] t = new int[31];

    public static void main(String[] args) {
        int n = 4;
        int ans = fib(n);
        System.out.println(ans);
    }

    private static int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        if (t[n] != 0) {
            return t[n];
        }
        return t[n] = fib(n - 1) + fib(n - 2);
    }
}
