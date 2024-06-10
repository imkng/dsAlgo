package com.company.slidingWindows;

public class SpecialArrayI {
    static int[] nums = {2,1,4};

    public static void main(String[] args) {
        boolean ans = isArraySpecial(nums);
        System.out.println(ans);
    }

    private static boolean isArraySpecial(int[] nums) {
        if (nums.length == 1){
            return true;
        }
        for (int i = 0; i < nums.length - 2 + 1; i++) {
            int[] temp = new int[2];
            for (int j = 0; j < 2; j++) {
                temp[j] = nums[i+j];
            }
            boolean parity = checkParity(temp);
            if (!parity){
                return false;
            }
        }
        return true;
    }

    private static boolean checkParity(int[] temp) {
        if ((temp[0]%2 == 0 && temp[1]%2 != 0) ||temp[1]%2 == 0 && temp[0]%2 != 0){
            return true;
        }else {
            return false;
        }
    }
}
