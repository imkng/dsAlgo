package com.company.slidingWindows.variableSize;

public class MinimumSizeSubarraySum {
    //static int[] arr = {2,3,1,2,4,3};
    //static int target = 7;
    static int[] arr = {1, 2, 3, 4, 5};
    static int target = 11;

    public static void main(String[] args) {
        int ans = minSubArrayLen(arr, target);
        System.out.println(ans);
    }

    private static int minSubArrayLen(int[] arr, int target) {
        int i = 0, j = 0;
        int minSize = 0;
        int find = 0;
        int sum = 0;
        while (j < arr.length) {
            sum += arr[j];
            if (sum < target) {
                j++;
            } else if (sum == target) {
                if (find == 0) {
                    minSize = j - i + 1;
                    find = 1;
                    System.out.println(0);
                } else {
                    minSize = Math.min(minSize, j - i + 1);
                    System.out.println(1);
                }
                j++;
            } else if (sum > target) {
                while (sum > target) {
                    sum -= arr[i];
                    i++;
                }
                if (sum == target) {
                    if (find == 0) {
                        minSize = j - i + 1;
                        find = 1;
                        System.out.println(0);
                    } else {
                        minSize = Math.min(minSize, j - i + 1);
                        System.out.println(1);
                    }
                }
                j++;
            }
        }
        return minSize;
    }
}
