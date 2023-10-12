package com.company.BinarySearch;

public class FloorOfAnElementInSortedArray {
    static int[] arr = new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19};
    static int target = 19;

    // floor will be The Greatest number which is smaller than target. i.e. 4;
    public static void main(String[] args) {
        int floor = floorOfAnElementInSortedArray(arr, target);
        System.out.println(floor);
    }

    private static int floorOfAnElementInSortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return target;
            }
            if (arr[mid] < target) {
                ans = arr[mid];
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            }
        }
        return ans;
    }
}
