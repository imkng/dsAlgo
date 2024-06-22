package com.company.sorting;

import java.util.Arrays;

public class QuickSort {
    static int[] list = {1,3,5,2,3,6,7,8,9,10};

    public static void main(String[] args) {
        quickSortAlgo(list);
        for (int qi = 0; qi < list.length; qi++) {
            System.out.println(list[qi]);
        }
    }

    private static void quickSortAlgo(int[] list) {
        quickSort(list, 0, list.length -1);
    }

    private static void quickSort(int[] list, int p, int q) {
        if ( p < q){
            int partitionIndex = partition(list, p, q);
            quickSort(list, p, partitionIndex-1);
            quickSort(list, partitionIndex + 1, q);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
