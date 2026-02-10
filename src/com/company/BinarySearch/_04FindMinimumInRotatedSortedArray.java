package com.company.BinarySearch;

public class _04FindMinimumInRotatedSortedArray {

    static int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};
    public static void main(String[] args) {
        int findMinIndex = findMinimumInRotatedSortedArray(arr);
        System.out.println(findMinIndex);
    }
    private static int findMinimumInRotatedSortedArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // for mid == arr.length - 1 next element will be at 0
            int next = (mid + 1) % arr.length;

            // for mid == 0 prev element will be last one, so (0 + 5 - 1) % 5 = 4
            int prev = (mid + arr.length - 1) % arr.length;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            }
            if (arr[start] <= arr[mid] && arr[mid] <= arr[end]) {
                return start;
            }
            // need to move toward unsorted arr
            if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            }
        }
        return 0;
    }
}
