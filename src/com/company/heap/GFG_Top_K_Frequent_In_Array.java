package com.company.heap;

import java.util.*;

class GFGPair{
    int key;
    int value;

    public GFGPair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class GFG_Top_K_Frequent_In_Array {
//    Given a non-empty integer array arr[]. Your task is to find and return the top k elements
//    which have the highest frequency in the array.
//
//    Note: If two numbers have the same frequency, the larger number should be given the higher priority.
//
//            Examples:
//
//    Input: arr[] = [3, 1, 4, 4, 5, 2, 6, 1], k = 2
//    Output: [4, 1]
//    Explanation: Frequency of 4 is 2 and frequency of 1 is 2, these two have the maximum frequency and 4 is larger than 1.
//    Input: arr[] = [7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9], k = 4
//    Output: [5, 11, 7, 10]
//    Explanation: Frequency of 5 is 3, frequency of 11 is 2, frequency of 7 is 2, frequency of 10 is 1.

    public static void main(String[] args) {
//        int[] arr =  {3, 1, 4, 4, 5, 2, 6, 1};
//        int k = 2;

        int[] arr =  {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int k = 4;


        ArrayList<Integer> integers = topKFreq(arr, k);
        System.out.println(integers);
    }

    private static ArrayList<Integer> topKFreq(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0 ) + 1);
        }

        PriorityQueue<GFGPair> pairPriorityQueue = new PriorityQueue<>((a,b) -> {
            if (a.value != b.value) {
                return a.value - b.value; // lower frequency = lower priority
            } else {
                return b.key - a.key; // smaller number = lower priority
            }
        });

        for (Map.Entry<Integer, Integer> ele: mp.entrySet()){
            pairPriorityQueue.offer(new GFGPair(ele.getKey(), ele.getValue()));
            if (pairPriorityQueue.size() > k){
                pairPriorityQueue.poll();
            }
        }

        System.out.println(pairPriorityQueue);
        while (!pairPriorityQueue.isEmpty()){
            ans.add(pairPriorityQueue.peek().key);
            pairPriorityQueue.poll();
        }

        return ans;
    }
}
