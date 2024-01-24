package com.company.BinarySearch;

public class FindInMountainArray {
    static int[] mountainArr = new int[]{1, 2, 3, 4, 5, 3, 1};

    public static void main(String[] args) {
        int peekElement = findPeekElement(mountainArr);
        System.out.println(peekElement);
    }

    private static int findPeekElement(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start != end) {
            int mid = start + (end - start) / 2;

                if ( arr[mid] > arr[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid ;
                }

        }
        return start;
    }
}
