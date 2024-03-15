package com.company.heap;

import java.util.*;

public class SmallestDistancePair {
    // The distance of a pair of integers a and b is defined as the absolute difference
    // between a and b.

    // Given an integer array nums and an integer k, return the kth smallest
    // distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.

    // Example :
    // Input: nums = [1,3,1], k = 1
    // Output: 0
    // Explanation: Here are all the pairs:
    //         (1,3) -> 2
    //         (1,1) -> 0
    //         (3,1) -> 2
    // Then the 1st smallest distance pair is (1,1), and its distance is 0.

    //static int[] arr = {1,3,1};
    // static int k = 1;
    // output = 0
    static int[] arr = {1,6,1};
    static int k = 3;
    public static void main(String[] args) {
        int ans = smallestDistancePair(arr, k);
        System.out.println(ans);
    }

    private static int smallestDistancePair(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int absDis = Math.abs(arr[i] - arr[j]);
                maxHeap.add(absDis);
                if (maxHeap.size() > k){
                    maxHeap.poll();
                }
            }

        }
        return maxHeap.peek();
    }


}
