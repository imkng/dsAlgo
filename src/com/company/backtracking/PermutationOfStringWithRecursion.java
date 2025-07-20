package com.company.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfStringWithRecursion {

    public static void main(String[] args) {
        String s = "abc";
        List<String> ans = solve(s);
        System.out.println(ans);
    }

    private static List<String> solve(String s) {
        List<String> ans = new ArrayList<>();

        permute(s,"", ans);
        return ans;
    }

    private static void permute(String input, String output, List<String> ans) {
        if (input.equals("")){
            ans.add(output);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            String newInput = input.substring(0, i) + input.substring(i+1);
            String newOutput = output + input.charAt(i);
            permute(newInput, newOutput, ans);
        }
        
    }
}
