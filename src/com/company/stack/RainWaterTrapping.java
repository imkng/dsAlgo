package com.company.stack;

public class RainWaterTrapping {
//    static int[] arr = new int[]{3, 0, 0, 2, 0 ,4};
    static int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    public static void main(String[] args) {
        int trap = rainWaterTrapping(arr);
        System.out.println(trap);
    }

    private static int rainWaterTrapping(int[] arr) {
        //try to find out extreme Maxi. to left and right for each building
        int[] maxLeft = new int[arr.length];
        int[] maxRight = new int[arr.length];

        maxLeft[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], arr[i]);
        }
        maxRight[arr.length-1] = arr[arr.length-1];
        for (int i = arr.length-2; i >= 0 ; i--) {
            maxRight[i] = Math.max(maxRight[i+1], arr[i]);
        }
        int[] water = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            water[i] = Math.min(maxLeft[i], maxRight[i]) - arr[i];
        }
        int trap = 0;
        for (int i = 0; i < water.length; i++) {
            trap += water[i];
        }
        return trap;
    }
}
