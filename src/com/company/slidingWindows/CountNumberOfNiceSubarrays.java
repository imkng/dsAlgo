package com.company.slidingWindows;

public class CountNumberOfNiceSubarrays {
     static int[] nums = {1,1,2,1,1};
     static int k = 3;
//    static int[] nums = {2,2,2,1,2,2,1,2,2,2};
//    static int k = 2;
    public static void main(String[] args) {
        int ans = numberOfSubarrays(nums, k);
        System.out.println(ans);
    }

    private static int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int i =0, j = 0;
        int oddCount = 0;
        while (j < nums.length){
            if (nums[j] % 2 != 0){
                oddCount++;
            }
            if (oddCount < k){
                j++;
            }else if (oddCount == k){
                ans++;
                while (nums[i] %2 == 0){
                    i++;
                }

                i++;
                j++;
            }

        }
        return ans;
    }
}
