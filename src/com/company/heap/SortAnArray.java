package com.company.heap;

import java.util.PriorityQueue;

public class SortAnArray {
    static int[] mat = {5,2,3,1};

    public static void main(String[] args) {
        int[] ans = sortAnArray(mat);
        for (int element :
                ans) {
            System.out.print(element + " ");
        }
    }

    private static int[] sortAnArray(int[] mat) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int element :
                mat) {
            priorityQueue.add(element);
        }
        int[] ans = new int[mat.length];
        int i = 0;
        while (!priorityQueue.isEmpty()){
            ans[i] = priorityQueue.peek();
            priorityQueue.remove();
            i++;
        }
        return ans;
    }
}
