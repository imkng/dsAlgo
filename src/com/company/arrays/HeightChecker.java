package com.company.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HeightChecker {

    // static int [] heights = {1,1,4,2,1,3};
     static int [] heights = {5,1,2,3,4};
//    static int [] heights = {1,2,3,4,5};
    public static void main(String[] args) {
        int ans = heightChecker(heights);
        System.out.println(ans);
    }

    private static int heightChecker(int[] heights) {
        int[] expected = heights;
        int ans = 0;
        Arrays.sort(expected);
//        List<Integer> expected = Arrays.stream(heights).boxed().sorted().collect(Collectors.toList());
//        Arrays.sort(heights);
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != heights[i]){
                ans++;
            }
        }
        return ans;
    }
}
