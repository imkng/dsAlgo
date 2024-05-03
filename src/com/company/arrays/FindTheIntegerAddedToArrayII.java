package com.company.arrays;

import java.util.Arrays;

public class FindTheIntegerAddedToArrayII {
    static int [] nums1 = {4, 7, 5};
    static int [] nums2 = {5};
//    static int [] nums1 = {4,6,3,1,4,2,10,9,5};
//    static int [] nums2 = {5,10,3,2,6,1,9};
//    static int [] nums1 = {4,20,16,12,8};
//    static int [] nums2 = {14,18,10};
    public static void main(String[] args) {
        int[] nearestSmall = new int[nums2.length];
        int[] nearestLarge = new int[nums2.length];
        for(int i = 0; i < nums2.length; i++){
            int small = Integer.MAX_VALUE;
            int large = Integer.MIN_VALUE;
            for(int j = 0; j < nums1.length; j++){
                if(nums2[i] <= nums1[j]){
                    if(small > nums1[j]){
                        nearestSmall[i] = nums1[j];
                        small =  nums1[j];
                    }
                }
                if(nums2[i] >= nums1[j]){
                    if(large < nums1[j]){
                        nearestLarge[i] = nums1[j];
                        large =  nums1[j];
                    }
                }
            }
        }
        System.out.println(nearestSmall[0]);
        System.out.println(nearestLarge[0]);

        int findMinSmallArr = getMin(nearestSmall);
        int findLargeMin = getMin(nearestLarge);
        int findMin = getMin(nums2);

        int x = findMin - findLargeMin;
        int y = findMin - findMinSmallArr;
        System.out.println(x > y ? y : x);

    }

    private static int getMin(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++)
            res = Math.min(res, arr[i]);
        return res;
    }
}
