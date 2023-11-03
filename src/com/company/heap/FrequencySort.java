package com.company.heap;

import java.util.*;

class CountPair {
    private int count;
    private int element;

    public CountPair(int count, int element) {
        this.count = count;
        this.element = element;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }
}

public class FrequencySort {
    static int[] arr = new int[]{5, 5, 4, 6, 4};

    //output: 4 4 5 5 6

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        while (testCase != 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int temp = scanner.nextInt();
                arr[i] = temp;
            }
            int[] ans = frequencySort(arr);
            for (int an : ans) {
                System.out.print(an + " ");
            }
            System.out.println();
            testCase--;
        }
    }

    private static int[] frequencySort(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele :
                arr) {
            if (map.containsKey(ele)) {
                int temp = map.get(ele);
                map.put(ele, temp + 1);
            } else {
                map.put(ele, 1);
            }
        }
        PriorityQueue<CountPair> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.getCount() == o2.getCount()) {
                return o1.getElement() - o2.getElement();
            } else {
                return o2.getCount() - o1.getCount();
            }
        }
        );
        for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
            maxHeap.add(new CountPair(mp.getValue(), mp.getKey()));
        }
        int[] ans = new int[arr.length];
        int i = 0;
        while (!maxHeap.isEmpty()) {
            int ele = maxHeap.peek().getElement();
            int count = maxHeap.peek().getCount();
            for (int j = 0; j < count; j++) {
                ans[i] = ele;
                i++;
            }
            maxHeap.poll();
        }
        return ans;
    }
}
