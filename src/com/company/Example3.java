package com.company;

import java.util.*;

public class Example3 {
    static int[] arr = {-5, 10, 5, -3};
    public static void main(String[] args) {
        int [] ans = fingMerge(arr);
        for (int t : ans) {
            System.out.println(t);
        }
    }

    private static int[] fingMerge(int[] arr) {
        List<Integer> ansT = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : arr) {
            if (map.containsKey(-ele)){
                ansT.remove(Integer.valueOf(-ele));
            }else{
                map.put(ele, 1);
                ansT.add(ele);
            }
        }
        int [] ans =  {Collections.max(ansT)};
        return ans;

    }
}
