package com.company.arrays;

import com.company.heap.SmallestDistancePair;

import java.util.PriorityQueue;

class VowelPair{
    private int asci;
    private char vowel;

    public VowelPair(int asci, char vowel) {
        this.asci = asci;
        this.vowel = vowel;
    }

    public int getAsci() {
        return asci;
    }

    public char getVowel() {
        return vowel;
    }
}

public class SortVowelsInAString {
    static String s = "lEetcOde";

    public static void main(String[] args) {
        String ans = sortVowels(s);
        System.out.println(ans);

    }

    private static String sortVowels(String s) {
        char[] charArr = s.toCharArray();
        char[] ans = new char[s.length()];

        PriorityQueue<VowelPair> maxHeap = new PriorityQueue<>((a,b)-> a.getAsci() - b.getAsci());

        for (char c : charArr) {
            if (checkVowel(c)){
                maxHeap.add(new VowelPair(c, c));
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (!checkVowel(charArr[i])){
                ans[i] = charArr[i];
            }else {
                char c = maxHeap.poll().getVowel();
                ans[i] = c;
            }
        }
        String ansString = "";
        for (int i = 0; i < ans.length; i++) {
            ansString += ans[i];
        }

        return ansString;
    }

    private static boolean checkVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        return false;
    }
}
