package com.company.arrays;

public class LatestTimeYouCanObtainAfterReplacingCharacters {
    public static void main(String[] args) {
        String ans = findLatestTime("?3:12");
        System.out.println(ans);
    }
    public static String findLatestTime(String s) {
        StringBuilder part1 = new StringBuilder(s.substring(0, s.indexOf(':')));
        StringBuilder part2 = new StringBuilder(s.substring(s.lastIndexOf(':') + 1));
        System.out.println(part2);
        System.out.println(part1);
        if(part1.charAt(0) == '?' && part1.charAt(1) == '?'){
            part1 = new StringBuilder("11");
        } else if (part1.charAt(0) == '1' && part1.charAt(1) == '?') {
            part1 = new StringBuilder("11");
        }else if(part1.charAt(0) == '0' && part1.charAt(1) == '?'){
            part1 = new StringBuilder("09");
        } else if (part1.charAt(0) =='?' && part1.charAt(1) == '1') {
            part1 = new StringBuilder("11");
        }else if (part1.charAt(0) =='?' && part1.charAt(1)-'0' <= 9){
            char temp = part1.charAt(1);
            part1 = new StringBuilder();
            part1.append(0);
            part1.append(temp);
        }

        if (part2.charAt(0) == '?' && part2.charAt(1) == '?'){
            part2 = new StringBuilder("59");
        } else if (part2.charAt(0) == '?' && part2.charAt(1) - '0' <= 9) {
            char temp = part2.charAt(1);
            part2 = new StringBuilder("5");
            part2.append(temp);
        } else if (part2.charAt(0) - '0' <= 5 && part2.charAt(1) == '?') {
            char temp = part2.charAt(0);
            part2 = new StringBuilder();
            part2.append(temp);
            part2.append('9');
        }
        return part1 + ":" + part2;
    }
}
