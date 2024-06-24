package com.company.hashMap;

import java.util.*;

public class RelativeSortArray {

    // static int [] arr1 = {2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};
    static int [] arr1 = {28,6,22,8,44,17}, arr2 = {22,28,8,6};
    public static void main(String[] args) {
        int [] ans = relativeSortArray(arr1, arr2);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    private static int[] relativeSortArray(int[] arr1, int[] arr2) {
//        int [] ans = new int[arr1.length];
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        int i = 0;
        for (; i < arr2.length; i++) {
            for (int j = 0; j < map.get(arr2[i]); j++) {
                ans.add(arr2[i]);
            }
            map.remove(arr2[i]);
        }
        for (Map.Entry<Integer, Integer> ele : map.entrySet()){
            for (int j = 0; j < ele.getValue(); j++) {
                 ans.add(ele.getKey());
            }
        }


        int[] temp = new int[arr1.length];
        for (int j = 0; j < ans.size(); j++) {
            temp[j] = ans.get(j);
        }

        return temp;
    }
}
