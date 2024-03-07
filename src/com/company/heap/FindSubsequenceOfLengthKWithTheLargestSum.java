package com.company.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindSubsequenceOfLengthKWithTheLargestSum {

    static int[] arr = {2, 1, 3, 3};
    static int k = 2;

    public static void main(String[] args) {
        int[] ans = findSubsequenceOfLengthKWithTheLargestSum(arr);
        for (int ele :
                ans) {
            System.out.println(ele);
        }
    }

    private static int[] findSubsequenceOfLengthKWithTheLargestSum(int[] arr) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(new int[]{arr[i], i});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<Integer> indexes = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            indexes.add(minHeap.poll()[1]);
        }
        int[] ans = new int[k];

        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (indexes.contains(i)) {
                ans[p] = arr[i];
                p++;
            }
        }
        return ans;
    }
}
