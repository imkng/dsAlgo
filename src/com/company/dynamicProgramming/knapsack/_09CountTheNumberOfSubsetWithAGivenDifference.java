package com.company.dynamicProgramming.knapsack;

public class _09CountTheNumberOfSubsetWithAGivenDifference {
    // static int[] arr = {1, 1, 2, 3};
    // static int diff = 1;
    // static int[] arr = {1};
    // static int diff = 2;
    static int[] arr = {0,0,0,0,0,0,0,0,1};
    static int diff = 1;
    //Problem Statement:
    // divide arr -> p1 & p2 with s1 and s2 sum
    // such that s1 - s2 = diff;

    // Solution Explanation:-
    // s1 - s2 = diff (given) ------(1)
    // s1 + s2 = Sum of All Elements in Array ----(2)
    // (1) + (2)
    // s1 = (diff + Sum of All Elements in Array) / 2

    // then count number of subset are possible for s1
    // i.e converted to:- Count of subset with given sum

    public static void main(String[] args) {
        int countNumberOfSubsets = countTheNumberOfSubsetWithAGivenDifference(arr, diff);
        System.out.println(countNumberOfSubsets);
    }

    private static int countTheNumberOfSubsetWithAGivenDifference(int[] arr, int diff) {
        int sumOfAllElementsInArray = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfAllElementsInArray += arr[i];
        }
        if(sumOfAllElementsInArray < diff){
            return 0;
        }
        int sum1  = (diff + sumOfAllElementsInArray)/2;

        return countSubsetWithAGivenSum(arr, sum1);
    }

    private static int countSubsetWithAGivenSum(int[] nums, int s1) {
        int n = nums.length;
        int[][] t = new int[n+1][s1 + 1];
        t[0][0] = 1;
        for(int i=1;i<s1+1;i++)
            t[0][i] = 0;
        for(int i=1;i<n+1;i++)
            for(int j=0;j<s1+1;j++){
                if(nums[i-1] > j)
                    t[i][j] = t[i-1][j];
                else
                    t[i][j] = t[i-1][j] + t[i-1][j-nums[i-1]];
            }

        return t[n][s1];
    }
}
