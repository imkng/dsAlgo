package com.company.slidingWindows;

import java.util.*;

public class _04MaximumOfAllSubArraysOfSizeK {
    //static int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
    //static int k = 3;

    static int[] arr = {1,3,1,2,0,5};
    static int k = 3;

    public static void main(String[] args) {
        int[] ans = maximumOfAllSubArraysOfSizeK(arr, k);
        for (int ele :
                ans) {
            System.out.println(ele);
        }
    }

    private static int[] maximumOfAllSubArraysOfSizeK(int[] arr, int k) {
        List<Integer> tempAns = new ArrayList<>();
        int i = 0, j = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        while (j < arr.length) {
            while (!queue.isEmpty() && queue.getLast() < arr[j]) {
                queue.removeLast();
            }
            queue.offerLast(arr[j]);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                tempAns.add(queue.getFirst());
                if (queue.getFirst() == arr[i]) {
                    queue.removeFirst();
                }
                i++;
                j++;
            }
        }
        int[] ans = new int[tempAns.size()];
        for (int l = 0; l < tempAns.size(); l++) {
            ans[l] = tempAns.get(l);
        }
        return ans;
    }
}

