package com.company.BinarySearch;

public class SearchInNearlySortedArray {
//    Given a sorted array arr[] of size N, some elements of array are
//    moved to either of the adjacent positions, i.e., arr[i] may be present at
//    arr[i+1] or arr[i-1] i.e. arr[i] can only be swapped with either
//    arr[i+1] or arr[i-1]. The task is to search for an element in this array.

//    static int[] arr = new int[]{5, 10, 30, 20, 40};
    static int[] arr = new int[]{10, 3, 40, 20, 50, 80, 70};
    public static void main(String[] args) {
        int target = 70;
        int indexFoundAt = searchInNearlySortedArray(arr, target);
        System.out.println("Element found at index: " + indexFoundAt);
    }

    private static int searchInNearlySortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (arr[mid] == target){
                return mid;
            }
            if(mid - 1 >= start && arr[mid - 1] == target){
                return mid - 1;
            }
            if (mid + 1 <= end && arr[mid + 1] == target){
                return mid + 1;
            }
            if (arr[mid] < target){
                start = mid + 2;
            }else if (arr[mid] > target){
                end = mid - 2;
            }
        }
        return -1;
    }
}
