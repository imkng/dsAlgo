package com.company.hashMap;

import java.util.*;

public class MaxSumOfAPairWithEqualSumOfDigits {
//    static int[] arr = {18,43,36,13,7};
    static int[] arr = {10,12,19,14};

    public static void main(String[] args) {
        int ans = maxSumOfAPairWithEqualSumOfDigits(arr);
        System.out.println(ans);
    }

    private static int maxSumOfAPairWithEqualSumOfDigits(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;
        for (int ele : arr) {
            int digitSum = sumOfDigit(ele);
            if (!map.containsKey(digitSum)){
                map.put(digitSum, ele);
            }else{
                ans = Math.max(ans, map.get(digitSum) + ele);
                map.put(digitSum, Math.max(map.get(digitSum), ele));
            }
        }
        return  ans;
    }

    private static int sumOfDigit(int i) {
        int sum = 0;
        while (i != 0){
            int temp = i % 10;
            sum += temp;
            i = i/10;
        }
        return sum;
    }
}
