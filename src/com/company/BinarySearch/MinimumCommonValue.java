package com.company.BinarySearch;

public class MinimumCommonValue {
    static int[] nums1 =new int[]{1,2,3};
    static int[] nums2 = new int[]{2,4};
    public static void main(String[] args) {
        int numberOfCommonElement = getCommon(nums1, nums2);
        System.out.println(numberOfCommonElement);
    }

    private static int getCommon(int[] nums1, int[] nums2) {
        int common = Integer.MAX_VALUE;
        for (int j : nums1) {
            if (binarySearch(nums2, j)) {
                if (common > j) {
                    common = j;
                }
            }
        }
        return common;
    }

    private static boolean binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}
