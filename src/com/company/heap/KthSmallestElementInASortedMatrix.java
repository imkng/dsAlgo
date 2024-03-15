package com.company.heap;

import java.io.IOException;
import java.util.*;

public class KthSmallestElementInASortedMatrix {
//    static int[][] arr = {
//            {1, 5, 9},
//            {10, 11, 13},
//            {12, 13, 15}
//    };
    static int[][] arr = {{-5}};


    static int k = 1;

    public static void main(String[] args) {


    }

    private static int kthSmallestElementInASortedMatrix(int[][] arr) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        for (int[] ints : arr) {
            for (int ele : ints) {
                maxHeap.add(ele);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }
}
