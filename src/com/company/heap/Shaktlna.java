package com.company.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Shaktlna {
    static int[] arr = {6, 1, 3,10, 7, 0, 8};

    public static void main(String[] args) {
        floorEle(arr, 6, "DN");

    }

    private static void floorEle(int[] arr, int flor, String dir) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int ele : arr) {
            if(ele > flor){
                minHeap.add(ele);
            }else if(ele == flor) {
                continue;
            }else {
                    maxHeap.add(ele);
                }
        }
        if (dir.equals("UP")){
            while (!minHeap.isEmpty()){
                System.out.println(minHeap.poll());
            }
            while (!maxHeap.isEmpty()){
                System.out.println(maxHeap.poll());
            }
        }
        else if(dir.equals("DN")){
            while (!maxHeap.isEmpty()){
                System.out.println(maxHeap.poll());
            }
            while (!minHeap.isEmpty()){
                System.out.println(minHeap.poll());
            }
        }
    }
}
