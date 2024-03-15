package com.company.arrays;

public class HouseRobber {
//    static int[] nums = {1,2,3,1};
//    static int[] nums = {2,7,9,3,1};
    static int[] nums = {2,1,1,2};

    public static void main(String[] args) {
        int maxProfit = rob(nums);
        System.out.println(maxProfit);
    }

    private static int rob(int[] nums) {
        int maxProfitFromZero = 0;
        int maxProfitFromOne = 0;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0 ){
                maxProfitFromZero += nums[i];
            }else if(i < n){
                maxProfitFromOne +=  nums[i];
            }
        }
        return Math.max(maxProfitFromZero, maxProfitFromOne);
    }
}
