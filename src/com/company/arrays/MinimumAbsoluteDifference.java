package com.company.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
//    static int[] arr = new int[]{4,2,1,3};
//    static int[] arr = new int[]{1,3,6,10,15};
    static int[] arr = new int[]{3,8,-10,23,19,-4,-14,27};
    public static void main(String[] args) {
        List<List<Integer>> listPairs = new ArrayList<>();
        listPairs = minimumAbsDifference(arr);
        System.out.println(listPairs);
    }

    private static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0 ; i < arr.length - 1; i++){
            for (int j = i + 1; j <= i+1; j++){
                int min = Math.abs(arr[i] - arr[j]);
                if(min < minDifference){
                    minDifference = min;
                    if(!ans.isEmpty()){
                        ans.clear();
                    }
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    ans.add(temp);
                }else if (min == minDifference){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }

}
