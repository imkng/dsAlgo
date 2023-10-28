package com.company.heap;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    static int k = 2;
    static int [][] arr = {
            {3,3},
            {5,-1},
            {-2,4}
    };

    public static void main(String[] args) {
        int[][] ans = kClosestPointsToOrigin(arr, k);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

    private static int[][] kClosestPointsToOrigin(int[][] arr, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> ((int[])b)[0] - ((int[])a)[0]);
        for (int i = 0; i < arr.length; i++){
            int dis = arr[i][0] * arr[i][0] + arr[i][1]* arr[i][1];
            maxHeap.add(new int[]{dis, i});
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[][] ans = new int[k][2];
        int l = 0;
        while (!maxHeap.isEmpty()){
            int i = maxHeap.poll()[1];
            ans[l][0] = arr[i][0];
            ans[l][1] = arr[i][1];
            l++;
        }
        return ans;
    }
}
