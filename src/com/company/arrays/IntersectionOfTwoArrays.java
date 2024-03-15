package com.company.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    //static int[] nums1 = {1, 2, 2, 1};
    //static int[] nums2 = {2, 2};

    static int[] nums1 = {4,9,5};
    static int[] nums2 = {9,4,9,8,4};

    public static void main(String[] args) {
        int [] ans = intersection(nums1, nums2);
        for (int element: ans){
            System.out.println(element);
        }
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        int[] ans = new int[0];
        Set<Integer> s1 = new HashSet<>();
        for (int element : nums1) {
            s1.add(element);
        }

        for (int element : nums2) {
            if (s1.contains(element)){
                ans = Arrays.copyOf(ans, ans.length + 1);
                ans[ans.length - 1] = element;
                s1.remove(element);
            }
        }
        return  ans;
    }
}
