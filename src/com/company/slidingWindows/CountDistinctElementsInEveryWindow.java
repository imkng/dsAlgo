package com.company.slidingWindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInEveryWindow {
    //Given an array of integers and a number K. Find the count of distinct elements
    //in every window of size K in the array.

    //Example 1:

    //Input:
    //N = 7, K = 4
    //A[] = {1,2,1,3,4,2,3}
    //Output: 3 4 4 3
    //Explanation: Window 1 of size k = 4 is
    //1 2 1 3. Number of distinct elements in
    //this window are 3.
    //Window 2 of size k = 4 is 2 1 3 4. Number
    //of distinct elements in this window are 4.
    //Window 3 of size k = 4 is 1 3 4 2. Number
    //of distinct elements in this window are 4.
    //Window 4 of size k = 4 is 3 4 2 3. Number
    //of distinct elements in this window are 3.

    static int[] arr = {1, 2, 1, 3, 4, 2, 3};
    static int k = 4;

    public static void main(String[] args) {
        ArrayList<Integer> ans = countDistinct(arr, k);
        for (int ele : ans) {
            System.out.println(ele);
        }
    }

    private static ArrayList<Integer> countDistinct(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (j < arr.length){
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            if(j-i+1 < k){
                j++;
            }else if(j-i +1 == k){
                ans.add(map.size());
                int temp = map.get(arr[i]);
                if(temp == 1){
                    map.remove(arr[i]);
                }else {
                    map.put(arr[i], --temp);
                }
                i++;
                j++;
            }

        }
        return ans;
    }
}
