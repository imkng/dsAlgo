package com.company.dynamicProgramming.knapsack;

public class KnapSackRecursive {
    int[] wt = {1, 3, 4, 5};
    int[] val = {1, 4, 5, 7};

    public static void main(String[] args) {

    }

    static int knapSack(int[] wt, int[] val, int W, int n){
        //base condition:- if n == 0 || Wait of KN == 0
        if(n == 0 || W == 0){
            return 0;
        }
        if(wt[n-1] <= W){ // either we include or not include
            return Math.max( val[n-1] + knapSack(wt, val, W - wt[n-1], n-1), knapSack(wt, val, W, n-1));
        }else{
            return knapSack(wt, val, W, n - 1);
        }
    }
}
