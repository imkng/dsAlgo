package com.company.arrays;

public class SortArrayByParityII {
    static int[] nums = {4,2,5,7};

    public static void main(String[] args) {
        int[] ans = sortArrayByParityII(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    private static int[] sortArrayByParityII(int[] nums) {
        int[] even = new int[nums.length/2];
        int evenCount = 0;
        int[] odd = new int[nums.length/2];
        int oddCount = 0;
        int [] ans = new int[nums.length];
        for (int ele : nums) {
            if(ele % 2 == 0){
                even[evenCount] = ele;
                evenCount++;
            }else {
                odd[oddCount] = ele;
                oddCount++;
            }
        }
        evenCount = 0;
        oddCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0){
                ans[i] = even[evenCount];
                evenCount++;
            }else{
                ans[i] = odd[oddCount];
                oddCount++;
            }
        }
        return ans;
    }
}
