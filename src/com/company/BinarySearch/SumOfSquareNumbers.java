package com.company.BinarySearch;

public class SumOfSquareNumbers {
    public static void main(String[] args) {
        boolean ans = judgeSquareSum(3);
        System.out.println(ans);
    }

    private static boolean judgeSquareSum(int i) {
        long left = 0;
        long right = (long) Math.sqrt(i);
        while (left <= right){
            long sum = left * left + right * right;
            if(sum == i){
                return true;
            }
            if (sum < i){
                left++;
            }else {
                right--;
            }
        }
        return false;
    }
}
