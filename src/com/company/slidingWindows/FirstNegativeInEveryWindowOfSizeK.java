package com.company.slidingWindows;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInEveryWindowOfSizeK {
    static int[] A = {12, -1, -7, 8, -15, 30, 16, 28};
    static int k = 3;

    public static void main(String[] args) {
        List<Integer> ans = firstNegativeInEveryWindowOfSizeK(A, k);
        for (int e : ans) {
            System.out.println(e);
        }
    }

    private static List<Integer> firstNegativeInEveryWindowOfSizeK(int[] a, int k) {
        List<Integer> temp = new ArrayList<>();
        Queue<Integer> list = new LinkedList<>();
        int i = 0, j = 0;
        while (j < a.length) {
            if (a[j] < 0) {
                list.add(a[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (list.isEmpty()) {
                    temp.add(0);
                } else {
                    temp.add(list.peek());
                    if (a[i] == list.peek()) {
                        list.poll();
                    }
                }
                i++;
                j++;
            }
        }
        return temp;
    }
}
