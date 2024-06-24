package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input  = scanner.nextLine();
        String [] part = input.split("#");

        String s1 = part[0];
        String s2 = part[1];
        String s3 = part[2];
        if (isValid(s1, s2, s3)){
            System.out.println("valid");
        }else {
            System.out.println("invalid");
        }
    }

    private static boolean isValid(String s1, String s2, String s3) {
        Map<Character, Integer> map1 = getFreq(s1);
        Map<Character, Integer> map2 = getFreq(s2);
        Map<Character, Integer> map3 = getFreq(s3);
        for (char c: map3.keySet()){
            int f3 = map3.get(c);
            int totalfreq = map1.getOrDefault(c, 0) + map2.getOrDefault(c, 0);
            if (f3 > totalfreq){
                return false;
            }
        }
        int prevIndex = -1;
        for (char c: s3.toCharArray()){
            int max1 = s1.lastIndexOf(c);
            int max2 = s2.lastIndexOf(c);
            int maxIndex = Math.max(max1, max2);

            if (maxIndex < prevIndex){
                return false;
            }
            prevIndex = maxIndex;
        }
        return true;
    }

    private static Map<Character, Integer> getFreq(String s1) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
