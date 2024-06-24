package com.company.slidingWindows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeNumberInEveryWindowOfSizeK {
    //Given an array A[] of size N and a positive integer K, find the first negative integer for
    //each and every window(contiguous subarray) of size K.
    static int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
    static int k = 3;
    public static void main(String[] args) {
        List<Integer> ans = firstNegativeNumberInEveryWindowOfSizeK(arr, k);
        for (int ele : ans) {
            System.out.println(ele);
        }
    }

    private static List<Integer> firstNegativeNumberInEveryWindowOfSizeK(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int i= 0, j = 0;
        while (j < arr.length){
            if(arr[j] < 0){
                q.add(arr[j]);
            }
            if(j - i + 1 < k){
                j++;
            } else if (j-i+1 == k) {
                if(q.isEmpty()){
                    ans.add(0);
                }else{
                    ans.add(q.peek());
                    if(arr[i] == q.peek()){
                        q.poll();
                    }
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
