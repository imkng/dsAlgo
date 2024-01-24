package com.company.BinarySearch;

public class FindPeakElementInArray {

    static int[] arr = new int[]{5, 10, 20, 15};
    public static void main(String[] args) {
        int peakElement = findPeekElement(arr);
        System.out.println(peakElement);
    }

    private static int findPeekElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(mid > 0 && mid < arr.length - 1){
                if (arr[mid] > arr[mid-1] && arr[mid]>arr[mid+1]){
                    return arr[mid];
                } else if (arr[mid] < arr[mid+1]) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            } else if (mid == 0) {
                if (arr[0] > arr[1]){
                    return arr[0];
                }else {
                    return  arr[1];
                }
            } else if (mid == arr.length - 1) {
                if (arr[arr.length - 1] > arr[arr.length - 2]){
                    return arr[arr.length - 1];
                }else {
                    return arr[arr.length - 2];
                }
            }
        }
        return 0;
    }
}
