package com.company.stack;

import java.util.ArrayList;
import java.util.List;

public class RearrangeWordsInASentence {

    static class StringWithLength {
        String str;
        int len;

        public StringWithLength(String str, int len) {
            this.str = str;
            this.len = len;
        }
    }

    //    static String text = "To be or not to be";
    static String text = "Leetcode is cool";

    public static void main(String[] args) {
        String[] strings = text.split("\\s+");
        for (String str :
                strings) {
            System.out.println(str);
        }
        String rearrangedString = rearrangeWordsInASentence(strings);
        System.out.println(rearrangedString);
    }

    private static String rearrangeWordsInASentence(String[] strings) {
        List<StringWithLength> stringWithLengths = new ArrayList<>();
        for (String str :
                strings) {
            stringWithLengths.add(new StringWithLength(str, str.length()));
        }
        stringWithLengths.sort(((o1, o2) -> o1.len - o2.len));
        StringBuilder ans = new StringBuilder();
        int first = 0;
        for (StringWithLength stringWithLength : stringWithLengths
        ) {

            for (int i = 0; i < stringWithLength.str.length(); i++) {
                if (first == 0) {
                    ans.append(Character.toUpperCase(stringWithLength.str.charAt(i)));
                    first = 1;
                } else if (stringWithLength.str.charAt(i) >= 'A' && stringWithLength.str.charAt(i) <= 'Z') {
                    ans.append(Character.toLowerCase(stringWithLength.str.charAt(i)));
                } else {
                    ans.append(stringWithLength.str.charAt(i));
                }
            }
            ans.append(" ");
        }
        return ans.substring(0, ans.length() - 1);
    }
}
