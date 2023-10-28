package com.company.heap;

import java.util.*;
import java.util.stream.Collectors;


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
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> ((int[])b)[0] - ((int[])a)[0]
        );
        for (int element :
                arr) {
            maxHeap.add(new int[]{Math.abs(element - x), element});
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int t = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        System.out.println(maxHeap);
        while(!maxHeap.isEmpty()){
//            System.out.print("Key: " + maxHeap.poll()[0] + " " + "value: " + maxHeap.poll()[1]);
            int[] temp = maxHeap.remove();
            System.out.print("Key: " + temp[0] + " " + "value: " + temp[1]);
            System.out.println();
            ans.add(temp[1]);

        }
        return ans.stream().sorted((a,b)-> a - b).collect(Collectors.toList());
    }

}
