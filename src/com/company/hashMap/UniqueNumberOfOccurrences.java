package com.company.hashMap;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumberOfOccurrences {
//    static int[] arr = {1,2,2,1,1,3};
    static int[] arr = {1,2};

    public static void main(String[] args) {
        boolean ans = uniqueOccurrences(arr);
        System.out.println(ans);
    }

    private static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int ele :
                arr) {
            mp.put(ele, mp.getOrDefault(ele, 0) + 1);
        }
        Map<Integer, Integer> mapForOccuranceMap = new HashMap<>();
        for (Map.Entry<Integer, Integer> mpItr: mp.entrySet()){
            if (mapForOccuranceMap.containsKey(mpItr.getValue())){
                return false;
            }
            mapForOccuranceMap.put(mpItr.getValue(), 1);
        }
        return true;
    }
}
