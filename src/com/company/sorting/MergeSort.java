package com.company.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    static int[] list = {1,3,5,2,3,6,7,8,9,10};

    public static void main(String[] args) {
        mergeSortArray(list);
        for (int qi = 0; qi < list.length; qi++) {
            System.out.println(list[qi]);
        }
    }

    private static void mergeSortArray(int[] list) {
        mS(list, 0, list.length-1);
    }

    private static void mS(int[] list, int low, int high) {
        if (low == high){
            return;
        }
        int mid = (low+high)/2;
        mS(list, low, mid);
        mS(list, mid+1, high);
        merge(list, low, mid, high);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
