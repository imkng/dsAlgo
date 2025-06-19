package com.company.BinarySearch;

public class CountElementInSortedArr {

    public static void main(String[] args) {
        int arr[] = new int[]{2, 4, 10, 10, 10, 18, 20};
        int ans = findFirstAndLastIndex(arr, 10);
        System.out.println(ans);
    }

    private static int findFirstAndLastIndex(int[] arr, int target) {
        int firstIndex = findFirstIndex(arr, target);
        int lastIndex = findLastIndex(arr, target);

        return lastIndex - firstIndex + 1;
    }

    private static int findLastIndex(int[] arr, int target) {
        int res = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                res = mid;
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return res;
    }

    private static int findFirstIndex(int[] arr, int target) {
        int res = -1;
        int start = 0;
        int end = arr.length - 1;

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
}
