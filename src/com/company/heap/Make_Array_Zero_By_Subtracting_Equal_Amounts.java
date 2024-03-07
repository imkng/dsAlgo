package com.company.heap;

import java.util.PriorityQueue;

public class Make_Array_Zero_By_Subtracting_Equal_Amounts {

    // You are given a non-negative integer array nums. In one operation, you must:

    //Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
    //Subtract x from every positive element in nums.
    //Return the minimum number of operations to make every element in nums equal to 0.



    //Example 1:

//    Input: nums = [1,5,0,3,5]
//    Output: 3
//    Explanation:
//    In the first operation, choose x = 1. Now, nums = [0,4,0,2,4].
//    In the second operation, choose x = 2. Now, nums = [0,2,0,0,2].
//    In the third operation, choose x = 2. Now, nums = [0,0,0,0,0].

    static int[] arr = {1,5,0,3,5};
    static int ans = 0;

    public static void main(String[] args) {
        int countMini = makeArrayZero(arr);
        System.out.println(countMini);
    }

    private static int makeArrayZero(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int ans = 0;
        while (true){
            for (int ele : arr) {
                if (ele != 0) {
                    minHeap.add(ele);
                }
            }
            if (minHeap.isEmpty()){
                break;
            }
            int minEle = minHeap.peek();
            for (int i = 0; i < arr.length; i++){
                if(arr[i] != 0){
                    arr[i] = arr[i] - minEle;
                }
            }
            ans++;
            if (!minHeap.isEmpty()){
                minHeap.clear();
            }
        }
        return ans;
    }
}
