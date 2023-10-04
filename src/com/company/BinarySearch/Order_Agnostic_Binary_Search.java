package com.company.BinarySearch;

public class Order_Agnostic_Binary_Search {
    //    static int[] arr = new int[]{1,2,3,4,5,6,7,8};
    static int[] arr = new int[]{8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        int target = 4;
        int output = orderAgnosticBinarySearch(arr, target);
        System.out.println(output);
    }

    private static int orderAgnosticBinarySearch(int[] arr, int target) {
        if (arr.length == 1) {
            if (arr[0] == target) {
                return 0;
            }
        }

        if (arr[0] > arr[1]) {
            return binarySearchForDescendingOrder(arr, target);
        } else {
            return binarySearchForAscendingOrder(arr, target);
        }
    }

    private static int binarySearchForDescendingOrder(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return target;
            }
            //8,7,6,5,4,3,2,1
            if (arr[mid] < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchForAscendingOrder(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            // 1,2,3,4,5,6,7,8
            if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
