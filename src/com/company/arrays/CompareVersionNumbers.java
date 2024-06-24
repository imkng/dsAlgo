package com.company.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class CompareVersionNumbers {
//    static String version1 = "7.5.2.4", version2 = "7.5.3";
    static String version1 = "1.01", version2 = "1.001";
    public static void main(String[] args) {
        int ans = compareVersion(version1, version2);
        System.out.println(ans);
    }

    private static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        Queue<String> stack1 = new LinkedList<>();
        for (int i = 0; i < v1.length ; i++) {
            stack1.add(v1[i]);
        }
        Queue<String> stack2 = new LinkedList<>();
        for (int i = 0; i < v2.length ; i++) {
            stack2.add(v2[i]);
        }
        int n = stack1.size();
        int m = stack2.size();
        if (n < m){
            for (int i = 0; i < m - n; i++) {
                stack1.add("0");
            }
        }else if (n > m){
            for (int i = 0; i < n - m; i++) {
                stack2.add("0");
            }
        }
        while (!stack2.isEmpty() && !stack1.isEmpty()){
            if (stack1.peek().equals(stack2.peek()) || Integer.parseInt(stack1.peek()) == Integer.parseInt(stack2.peek())){
                stack2.poll();
                stack1.poll();
            } else if (Integer.parseInt(stack1.peek()) < Integer.parseInt(stack2.peek())) {
                return -1;
            }else {
                return 1;
            }
        }
        return 0;
    }
}
