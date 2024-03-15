package com.company.arrays;

public class LongestContinuousSequence {
    static int[] arr = {0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1};
    public static void main(String[] args) {
        int ans = longestContinuousSequence(arr);
        System.out.println(ans);
    }

    private static int longestContinuousSequence(int[] arr) {
        int ans = 0;
        int maxa = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                int j = i + 1;
                int temp = 0;
                while (j < arr.length && arr[j] == 1){
                    temp ++;
                    j++;
                }
                if(maxa <= temp){
                    maxa = temp;
                    ans = i;
                }
            }
        }
        return ans;
    }
}
