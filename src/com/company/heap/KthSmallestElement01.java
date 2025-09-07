package com.company.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement01 {
    static int[] arr = {7, 10, 4, 3, 20, 15};
    static int k = 3;

    public static void main(String[] args) {
        int kthSmallestElement = findKthSmallestElement(arr, k);
        System.out.println(kthSmallestElement);
    }

    private static int findKthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int element : arr) {
            maxHeap.add(element);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
