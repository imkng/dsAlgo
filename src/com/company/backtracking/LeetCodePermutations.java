package com.company.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodePermutations {
//    Given an array nums of distinct integers, return all the possible permutations.
//    You can return the answer in any order.
//
//
//
//            Example 1:
//
//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//    Example 2:
//
//    Input: nums = [0,1]
//    Output: [[0,1],[1,0]]
//    Example 3:
//
//    Input: nums = [1]
//    Output: [[1]]

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = solve1(nums);
        System.out.println(ans);
    }




    // work fine with all +ve number
    private static List<List<Integer>> solve1(int[] nums) {

        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < nums.length; i++) {
            stringBuilder.append(nums[i]);
        }
        String s = stringBuilder.toString() ;
        System.out.println(stringBuilder);
        List<String> ans = new ArrayList<>();

        pemute1(s, "", ans);

        System.out.println(ans);
//        convert ans to List of List of Integer
        List<List<Integer>> finalAns = new ArrayList<>();
        for (String s1: ans){
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < s1.length(); i++) {
                temp.add(s1.charAt(i) - '0');
            }
            finalAns.add(temp);
        }
        return finalAns;
    }

    private static void pemute1(String input, String output, List<String> ans) {
        if (input.equals("")) {
            ans.add(output);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            String newInput = input.substring(0, i) + input.substring(i+1);
            String newOutput = output + input.charAt(i);
            pemute1(newInput, newOutput, ans);
        }
    }
}
