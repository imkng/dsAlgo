package com.company.heap;

import java.util.*;

public class TopKFrequentElements {
    static int[] arr = new int[]{1,1,1,2,2,3};
    static final int k = 2;

    public static void main(String[] args) {
        int[] ans = topKFrequentElements(arr);
        for (int i :
                ans) {
            System.out.print(i + " ");
        }
    }

    private static int[] topKFrequentElements(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele: arr) {
            if (map.containsKey(ele)){
                int temp = map.get(ele);
                map.put(ele, temp + 1);
            }else {
                map.put(ele, 1);
            }
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a,b)-> ((int[])a)[0] - ((int[])b)[0]);

        for (Map.Entry<Integer, Integer> mp :
                map.entrySet()) {
            priorityQueue.add(new int[]{mp.getValue(), mp.getKey()});
            if (priorityQueue.size() > TopKFrequentElements.k){
                priorityQueue.poll();
        }
        }
            List<Integer> ans = new ArrayList<>();
            while (!priorityQueue.isEmpty()){
                ans.add(priorityQueue.peek()[1]);
                priorityQueue.poll();
            }
        return ans.stream().mapToInt(i->i).toArray();

    }
}
