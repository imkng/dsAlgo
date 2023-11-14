package com.company.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SumInAMatrix {
    static int[][] nums = {
            {7, 2, 1},
            {6, 4, 2},
            {6, 5, 3},
            {3, 2, 1}
    };

    public static void main(String[] args) {
        int ans = matrixSum(nums);
        System.out.println(ans);
    }

    private static int matrixSum(int[][] nums) {
        int ans = 0;
        int k = nums.length;
        for (int[] ints : nums) {
            Arrays.sort(ints);
        }
        for (int i = 0; i < nums[0].length; i++) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
            for (int[] num : nums) {
                maxHeap.add(num[i]);
            }
            ans += maxHeap.poll();
        }

        return ans;
    }
}
