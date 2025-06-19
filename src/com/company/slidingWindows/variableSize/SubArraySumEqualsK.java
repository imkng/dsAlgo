package com.company.slidingWindows.variableSize;

public class SubArraySumEqualsK {
    //static int[] nums = {1,1,1};
    //static int k = 2;

    static int[] nums = {1,2,3};
    static int k = 3;
//    static int[] nums = {1};
//    static int k = 0;
    public static void main(String[] args) {
        int ans = findSubsetSumOfk(nums, k);
        System.out.println(ans);
    }

    private static int findSubsetSumOfk(int[] nums, int k) {
        int ans = 0;
        int i = 0, j = 0;
        int sum = 0;
        while (j < nums.length){
            sum += nums[j];
            if (sum < k){
                j++;
            }else if (sum == k){
                ans++;
                j++;
            }else if (sum > k){
                while (sum > k){
                    sum -= nums[i];
                    i++;
                }
                if (sum == k){
                    ans++;
                }
                j++;
            }
        }
        return ans;
    }
}
