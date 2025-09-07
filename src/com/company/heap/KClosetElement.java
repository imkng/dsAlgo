package com.company.heap;

import java.util.*;
import java.util.stream.Collectors;

class PairValue{
    int absDiff;
    int element;

    public PairValue(int absDiff, int element) {
        this.absDiff = absDiff;
        this.element = element;
    }

    public int getAbsDiff() {
        return absDiff;
    }

    public void setAbsDiff(int absDiff) {
        this.absDiff = absDiff;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }
}


//Given a sorted integer array arr, two integers k and x, return the k closest integers to
// x in the array. The result should also be sorted in ascending order.
//
//An integer a is closer to x than an integer b if:
//
//        |a - x| < |b - x|, or
//|a - x| == |b - x| and a < b
//
//
//Example 1:
//
//Input: arr = [1,2,3,4,5], k = 4, x = 3
//
//Output: [1,2,3,4]
public class KClosetElement {
    static int[] arr = {5, 6, 7, 8, 9};
    static int k = 3;
    static int x = 7;

    public static void main(String[] args) {
        List<Integer>  ans = kClosetElement(arr, k, x);
        ans = ans.stream().sorted((a,b)-> a - b).collect(Collectors.toList());
        for (int e :
                ans) {
            System.out.println(e);
        }
    }

    private static List<Integer> kClosetElement(int[] arr, int k, int x) {
        PriorityQueue<PairValue> priorityQueue = new PriorityQueue<>((p1, p2) ->{
            if (p2.absDiff > p1.absDiff){
                return p2.absDiff - p1.absDiff;
            }else return p2.element - p1.element;
        });
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> ((int[])b)[0] - ((int[])a)[0]
        );
        for (int element :
                arr) {
//            maxHeap.add(new int[]{Math.abs(element - x), element});
            priorityQueue.add(new PairValue(Math.abs(element - x), element));
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        int t = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        System.out.println(maxHeap);
        while(!priorityQueue.isEmpty()){
//            System.out.print("Key: " + maxHeap.poll()[0] + " " + "value: " + maxHeap.poll()[1]);
            PairValue pairValue = priorityQueue.remove();
//            System.out.print("Key: " + temp[0] + " " + "value: " + temp[1]);
//            System.out.println();
            ans.add(pairValue.element);

        }
        return ans.stream().sorted((a,b)-> a - b).collect(Collectors.toList());
    }

}
