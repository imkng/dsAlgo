package com.company.stack;

import java.util.Stack;

public class CrawlerLogFolder {
    static String[] logs = new String[]{"d1/", "d2/", "../", "d21/", "./"};

    //    static  String[] logs = new String[]{"./","../","./"};
    static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        int ans = 0;
        for (String log : logs) {
            if (!stack.isEmpty() && log.equals("../")) {
                stack.pop();
            } else if (log.equals("./")) {
                continue;
            } else if (!log.equals("../")) {
                stack.push(log);
            }
        }
        ans = stack.size();
        return ans;
    }

    public static void main(String[] args) {
        int ans = minOperations(logs);
        System.out.println(ans);
    }
}
