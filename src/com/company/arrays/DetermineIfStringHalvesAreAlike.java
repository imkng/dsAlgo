package com.company.arrays;

public class DetermineIfStringHalvesAreAlike {
    static String s = "textbook";
    public static void main(String[] args) {
        System.out.println(determineIfStringHalvesAreAlike(s));
    }

    private static boolean determineIfStringHalvesAreAlike(String s) {
        if ((s.length()%2 != 0)){
            return false;
        }
        return stringHalvesAreAlike(s.substring(0,s.length()/2), s.substring(s.length()/2));
    }

    private static boolean stringHalvesAreAlike(String substring, String substring1) {
        return countVowel(substring) == countVowel(substring1);
    }

    private static int countVowel(String substring) {
        String str = substring.toLowerCase();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u'){
                count++;
            }
        }
        return count;
    }
}
