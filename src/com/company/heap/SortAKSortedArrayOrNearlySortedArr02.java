package com.company.heap;

import java.util.PriorityQueue;

public class SortAKSortedArrayOrNearlySortedArr02 {
//    Given an array arr[] and a number k . The array is sorted in a way that every element
//    is at max k distance away from it sorted position. It means if we completely sort the array,
//    then the index of the element can go from i - k to i + k where i is index in the given array. O
//    ur task is to completely sort the array.
//
//    Examples:
//
//    Input: arr= [6, 5, 3, 2, 8, 10, 9], k = 3
//    Output: [2, 3, 5, 6, 8, 9, 10]
//
//    Input: arr[]= [1, 4, 5, 2, 3, 6, 7, 8, 9, 10], k = 2
//    Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    public static void main(String[] args) {
        int[] InputArr= {6, 5, 3, 2, 8, 10, 9};

        int k = 3;
        nearlySorted(InputArr, k);
        for (int e: InputArr){
            System.out.println(e);
        }

    }

    private static void nearlySorted(int[] inputArr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i =0;
        for(int e: inputArr){
            minHeap.add(e);
            if (minHeap.size() > k){
                inputArr[i] = minHeap.poll();
                i++;
            }
        }
        while (i < inputArr.length){
            inputArr[i] = minHeap.poll();
            i++;
        }
    }
}
