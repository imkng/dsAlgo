package com.company.BinarySearch;

public class NumberOfTimeSortedArrayRotated {

    //initial arr: {2, 5, 6, 8, 11, 12, 15, 18}
    // after 4 times left rotation:
    //arr: {11, 12, 15, 18, 2, 5, 6, 8}

    static int[] arr = new int[]{11, 12, 15, 18, 2, 5, 6, 8};
    public static void main(String[] args) {
        int numberOfRotation = numberOfTimeSortedArrayRotated(arr);
        System.out.println(numberOfRotation);
    }

    private static int numberOfTimeSortedArrayRotated(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int numberOftimes = 0;
        while (start <= end){
            int mid = start + (end - start)/2;
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length -1) % arr.length;
            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]){
                numberOftimes = arr.length - mid;
                break;
            }
            if(arr[mid] >= arr[start] && arr[mid] <= arr[end]){
                numberOftimes = arr.length - start;
                break;
            }
            if(arr[start] < arr[mid]){
                start = mid + 1;
            } else if (arr[mid] < arr[end]) {
                end = mid - 1;
            }
        }
        return numberOftimes;
    }
}
