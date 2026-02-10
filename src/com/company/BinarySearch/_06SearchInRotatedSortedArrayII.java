package com.company.BinarySearch;

public class _06SearchInRotatedSortedArrayII {
    static int[] arr = new int[]{2,2,2,3,2,2,2};

    public static void main(String[] args) {
        int target = 3;
        int minElement = findMinElement(arr);
        int firstOccurrence = findFirstInSortedArr(arr, minElement);
        int lastOccurrence = findLastInSortedArr(arr, minElement);
        int searchInLeft = binarySearch(arr, target, 0, firstOccurrence -1);
        int searchInRight = binarySearch(arr, target, lastOccurrence, arr.length -1);
        if(searchInRight == -1 && searchInLeft == -1){
            System.out.println("Element is not found");
        }
        else if(searchInLeft != -1){
            System.out.println("Element founded in left at index: "+ searchInLeft);
        }else {
            System.out.println("Element founded in right at index: "+ searchInRight);
        }

    }
    private static int binarySearch(int[] arr, int target,  int start, int end) {
        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target){
                start = mid + 1;
            }else if (arr[mid] > target){
                end = mid - 1;
            }
        }
        return -1;
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

    private static int findMinElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length - 1)%arr.length;
            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]){
                return arr[mid];
            }
            if(arr[start] <= arr[mid] && arr[mid] <= arr[end]){
                return arr[start];
            }
            if(arr[start] <= arr[mid]){
                start = mid + 1;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
