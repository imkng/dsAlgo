package com.company.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddStrings {
    public static void main(String[] args) {
        String ans = addStrings("6994", "36");
        System.out.println(ans);
    }

    public static String addStrings(String num1, String num2) {
        List<Integer> ans = new ArrayList<>();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int t = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            carry = t / 10;
            int rem = t % 10;
            ans.add(rem);
            i--;
            j--;
        }
        if (i < 0 && j >= 0) {
            if (j > 0) {
                for (int k = j; k >= 0; k--) {
                    int t = num2.charAt(k) - '0' + carry;
                    carry = t / 10;
                    int rem = t % 10;
                    ans.add(rem);
                }
            } else {
                ans.add(num2.charAt(j) - '0' + carry);
                carry = 0;
            }
        } else if (i >= 0 && j < 0) {
            if (i > 0) {
                for (int k = i; k >= 0; k--) {
                    int t = num1.charAt(k) - '0' + carry;
                    carry = t / 10;
                    int rem = t % 10;
                    ans.add(rem);
                }
            } else {
                ans.add(num1.charAt(i) - '0' + carry);
                carry = 0;
            }
        }
        if (carry != 0) {
            ans.add(carry);
        }


        StringBuilder temp = new StringBuilder("");
        for (int k = ans.size() - 1; k >= 0; k--) {
            temp.append(ans.get(k));
        }
        return temp.toString();
    }
}
