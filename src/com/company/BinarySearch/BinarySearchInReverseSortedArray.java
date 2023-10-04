package com.company.BinarySearch;

public class BinarySearchInReverseSortedArray {
    static int[] arr = new int[]{12, 10, 8, 6, 4, 2, 1};

    //output: 6 if targeted: 1;

    public static void main(String[] args) {
        int target = 1;
        int find = binarySearchOnReverseSortedArray(arr,  target);
        System.out.println(find);
    }

    private static int binarySearchOnReverseSortedArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target){
                end = mid -1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
