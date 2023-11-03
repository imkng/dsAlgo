package com.company.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class PairSum{
    private int sum;
    private int num1;
    private int num2;

    public PairSum(int sum, int num1, int num2) {
        this.sum = sum;
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getSum() {
        return sum;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}

public class FindKPairsWithSmallestSums {
    static int[] num1 = {1,2};
    static int[] num2 = {3};
    static int k = 3;
    public static void main(String[] args) {
        List<List<Integer>> miniPairSum = findKPairsWithSmallestSums(num1, num2, k);
        for (List<Integer> integers : miniPairSum) {
            System.out.println(integers);
        }
    }

    private static List<List<Integer>> findKPairsWithSmallestSums(int[] num1, int[] num2, int k) {
        PriorityQueue<PairSum> maxHeap = new PriorityQueue<>((a,b) -> b.getSum() - a.getSum());
        int count = 0;
        for (int value : num1) {
            for (int i : num2) {
                int sum = value + i;
                if(count < k){
                    maxHeap.add(new PairSum(sum, value, i));
                    count++;
                }else {
                    if(!maxHeap.isEmpty() && maxHeap.peek().getSum() > sum){
                        maxHeap.poll();
                        maxHeap.add(new PairSum(sum, value, i));
                    }else {
                        break;
                    }
                }

                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!maxHeap.isEmpty()){
            PairSum pairSum = maxHeap.remove();
            List<Integer> temp = new ArrayList<>(Arrays.asList(pairSum.getNum1(),pairSum.getNum2()));
            ans.add(temp);
        }
        return ans;
    }
}
