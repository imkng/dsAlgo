package com.company.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    static int[] arr = {2,7,4,1,8,1};
//    static int[] arr = {1};

    public static void main(String[] args) {
        int lastStoneWeight = lastStoneWeight(arr);
        System.out.println(lastStoneWeight);
    }

    private static int lastStoneWeight(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2)-> o2 -o1);
        for (int ele : arr) {
            maxHeap.add(ele);
        }
        while (!maxHeap.isEmpty() && maxHeap.size() >= 2) {
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();
            int diff = max1 - max2;
            maxHeap.add(diff);
        }
        return maxHeap.peek();
    }
}
