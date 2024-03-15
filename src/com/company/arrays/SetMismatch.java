package com.company.arrays;

import java.util.HashMap;
import java.util.Map;

public class SetMismatch {
    static int[] nums= {1,2,2,4};

    public static void main(String[] args) {
        int [] ans = findErrorNums(nums);
        for (int ele :
                ans) {
            System.out.println(ele);
        }
    }

    private static int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        int error = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int element :
                nums) {
            if (map.containsKey(element)) {
                error = element;
                ans[0] = element;
                break;
            } else {
                map.put(element, 1);
            }
        }
        ans[1] = ++error;
        return ans;
    }
}
