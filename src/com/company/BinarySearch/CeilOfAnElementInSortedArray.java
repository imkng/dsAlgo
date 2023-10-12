package com.company.BinarySearch;

public class CeilOfAnElementInSortedArray {
    static int[] arr = new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19};
    static int target = 9;
    // smallest number which are greater than target. i.e. 10

    public static void main(String[] args) {
        int ceil = ceilOfAnElementInSortedArray(arr, target);
        System.out.println(ceil);
    }

    private static int ceilOfAnElementInSortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return target;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                ans = arr[mid];
                end = mid - 1;
            }
        }
        return ans;
    }
}
