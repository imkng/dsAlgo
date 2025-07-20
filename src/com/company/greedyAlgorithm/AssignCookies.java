package com.company.greedyAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AssignCookies {
//    Assume you are an awesome parent and want to give your children some cookies.
//    But, you should give each child at most one cookie.
//
//    Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be
//    content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and
//    the child i will be content. Your goal is to maximize the number of your content children and
//    output the maximum number.
//
//
//
//    Example 1:
//
//    Input: g = [1,2,3], s = [1,1]
//    Output: 1
//    Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
//    And even though you have 2 cookies, since their size is both 1, you could
//    only make the child whose greed factor is 1 content.
//    You need to output 1.
//    Example 2:
//
//    Input: g = [1,2], s = [1,2,3]
//    Output: 2
//    Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
//    You have 3 cookies and their sizes are big enough to gratify all of the children,
//    You need to output 2.

    public static void main(String[] args) {
//        int[] g = {1,2,3}, s = {1,1};
        int[] g = {1,2}, s = {1,2,3};
        int maxCookiesDistribution = maxCookiesDistribution(g, s);
        int maxCookiesDistribution1 = maxCookiesDistributionSolution2(g, s);
        System.out.println(maxCookiesDistribution);
        System.out.println(maxCookiesDistribution1);
    }

    private static int maxCookiesDistribution(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int r = 0;
        while (l < s.length && r < g.length){
            if (s[l] >= g[r]){
                r++;
            }
            l++;
        }
        return r;
    }
    private static int maxCookiesDistributionSolution2(int[]g, int [] s){
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        for (int e1 : g) {
            q1.offer(e1);
        }
        for (int e : s) {
            q2.offer(e);
        }

        while (!q1.isEmpty() && !q2.isEmpty()){
            if (q2.peek() >= q1.peek()){
                q2.poll();
            }
            q1.poll();
        }
        return s.length - q2.size();
    }
}
