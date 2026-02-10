package com.company.BinarySearch;

public class _05SearchInRotatedSortedArray {

    static int[] arr = new int[]{4, 5, 6, 7, 0, 1, 2};

    public static void main(String[] args) {
//        int target = 6;
        int target = 1;
        int findMinIndex = findMinimumInRotatedSortedArray(arr);
        int searchInLeft = binarySearch(arr, target, 0, findMinIndex - 1);
        int searchInRight = binarySearch(arr, target, findMinIndex, arr.length - 1);
        if (searchInRight == -1 && searchInLeft == -1) {
            System.out.println("Element is not found");
        }
        if (searchInLeft != -1) {
            System.out.println("Element founded in left at index: " + searchInLeft);
        } else {
            System.out.println("Element founded in right at index: " + searchInRight);
        }

    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            }
        }
        return -1;
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
            if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            }
        }
        return 0;
    }
}
