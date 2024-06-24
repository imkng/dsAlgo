package com.company.slidingWindows;

import java.util.ArrayList;
import java.util.List;

public class SpecialArrayII {
    //static int[] nums =  {4,3,1,6};
    //static int[][] queries = {{0,2},{2,3}};

    static int[] nums =  {3,4,1,2,6};
    static int[][] queries = {{0,4}};
    public static void main(String[] args) {
        boolean[] ans = isArraySpecial(nums, queries);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    private static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
//            int[] temp = new int[queries[i][1] - queries[i][0] + 1];
            List<Integer> temp = new ArrayList<>();
            for (int j = queries[i][0]; j<= queries[i][1]; j++){
                temp.add(nums[j]);
            }
            boolean parity = checkParity(temp);
            ans[i] = parity;
        }
        return ans;
    }

    private static boolean checkParity(List<Integer> temp) {
        int n =temp.size();
        if( n== 1){
            return true;
        }
        for (int i = 0; i < n-1; i++) {
            int temp1 = temp.get(i)%2;
            int temp2 = temp.get(i+1)%2;
            if (temp1 == temp2){
                return false;
            }
        }
        return true;
    }
}
