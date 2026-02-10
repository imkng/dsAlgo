package com.company.BinarySearch;

public class _02FindFirstAndLastElement {

    static int[] arr = new int[]{3, 4, 5, 10, 10, 10, 10, 34, 56, 90};

    public static void main(String[] args) {
        int target = 10;
        int firstOccurrence = findFirstInSortedArr(arr, target);
        int lastOccurrence = findLastInSortedArr(arr, target);
        System.out.println("first Occurrence: " + firstOccurrence + " " + "last Occurrence: " + lastOccurrence);
    }

    private static int findLastInSortedArr(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                res = mid;
                start = mid + 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

    private static int findFirstInSortedArr(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                res = mid;
                // only change is here...
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }

}
