package com.company.slidingWindows;

public class SumOfSubArrayMinimums {

    static int[] arr = {3,1,2,4};
    public static void main(String[] args) {
        int sum = sumSubarrayMins(arr);
        System.out.println(sum);
    }

    private static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int k = 1;
        int sum = 0;
        while ( k <= n){
            for (int i = 0; i < n - k + 1; i++) {
                int [] temp = new int[k];
                for (int j = 0; j < k; j++) {

//                    for (int l = 0; l < k; l++) {
//                        temp[l] = arr[i+j];
//                    }
                    temp[j] = arr[i+j];

                }
                sum += findMinimum(temp);
            }
            k++;
        }
        return sum;
    }

    private static int findMinimum(int[] arr) {
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(ans > arr[i]){
                ans = arr[i];
            }
        }
        return ans;
    }
}
