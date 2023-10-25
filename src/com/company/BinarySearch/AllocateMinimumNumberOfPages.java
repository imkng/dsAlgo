package com.company.BinarySearch;

import java.util.Arrays;

public class AllocateMinimumNumberOfPages {
    //    You have N books, each with A[i] number of pages. M students need to be allocated
//    contiguous books, with each student getting at least one book.
//    Out of all the permutations, the goal is to find the permutation where the
//    student with the most books allocated to him gets the minimum number of pages,
//    out of all possible permutations.
//
//            Note: Return -1 if a valid assignment is not possible, and allotment should be
//    in contiguous order (see the explanation for better understanding).
    static int[] arr = new int[]{13, 31, 37, 45, 46, 54, 55, 63, 73, 84, 85};
    static int numberOfStudent = 2;

    public static void main(String[] args) {
        int miniPages = findPages(arr, arr.length, numberOfStudent);
        System.out.println(miniPages);
    }

    private static int findPages(int[] arr, int length, int numberOfStudent) {
        if (length < numberOfStudent) {
            return -1;
        }
        int start = Arrays.stream(arr).max().getAsInt();
        int end = 0;
        int res = 0;
        for (int ele : arr) {
            end += ele;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValidScheme(arr, mid, numberOfStudent)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private static boolean isValidScheme(int[] arr, int mid, int numberOfStudent) {
        int student = 1;
        int pageCount = 0;
        for (int ele : arr) {
            pageCount += ele;
            if (pageCount > mid) {
                student++;
                pageCount = ele;
            }
            if (student > numberOfStudent) {
                return false;
            }
        }
        return true;
    }
}
