package com.company.arrays;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

class PairIntChar{
    int timeNeeded;
    char balloon;

    public PairIntChar(int timeNeeded, char balloon) {
        this.timeNeeded = timeNeeded;
        this.balloon = balloon;
    }
}

public class MinimumTimeToMakeRopeColorful {
    //static String colors = "abaac";
    //static int[] neededTime = {1,2,3,4,5};

    //static String colors = "abc";
    //static int[] neededTime = {1,2,3};
    //static String colors = "aabaa";
    //static int[] neededTime = {1,2,3,4,1};
    static String colors = "aaabbbabbbb";
    static int[] neededTime = {3,5,10,7,5,3,5,5,4,8,1};

    public static void main(String[] args) {
        int ans = minCost(colors, neededTime);
        System.out.println(ans);
    }

    private static int minCost(String colors, int[] neededTime) {
        int ans = 0;
        Stack<PairIntChar> stack = new Stack<>();
        for (int i = 0; i < colors.length(); i++) {
            PairIntChar pairIntChar  = new PairIntChar(neededTime[i], colors.charAt(i));
            if (!stack.isEmpty() && stack.peek().balloon == colors.charAt(i)){
               if (pairIntChar.timeNeeded <= stack.peek().timeNeeded){
                   ans += pairIntChar.timeNeeded;
               }else {
                   PairIntChar temp = stack.pop();
                   ans += temp.timeNeeded;
                   stack.push(pairIntChar);
               }
            }else {
                stack.push(pairIntChar);
            }
        }
        return ans;
    }
}
