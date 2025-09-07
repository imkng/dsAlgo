package com.company.slidingWindows;

public class _01MaximumSumSubArrayOfSizeK {
    static int[] arr = {1,5,4,2,9};
    static int k = 3;

    public static void main(String[] args) {
        int ans = maximumSubArraySum(arr, k);
        System.out.println(ans);
    }

    private static int maximumSubArraySum(int[] arr, int k) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        int i = 0, j = 0;
        while (j < arr.length){
            sum += arr[j];
            if (j - i + 1 < k){
                j++;
            }else if (j - i + 1 == k){
                ans = Math.max(sum, ans);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        return ans;
    }

}
