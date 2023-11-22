package com.company.heap;

import java.util.PriorityQueue;

class PairChar{
    int freq;
    Character character;
    public PairChar(int freq, Character character){
        this.freq = freq;
        this.character = character;
    }
}
public class LongestHappyString {

//    A string s is called happy if it satisfies the following conditions:

//    s only contains the letters 'a', 'b', and 'c'.
//    s does not contain any of "aaa", "bbb", or "ccc" as a substring.
//    s contains at most a occurrences of the letter 'a'.
//    s contains at most b occurrences of the letter 'b'.
//    s contains at most c occurrences of the letter 'c'.
//    Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

//    A substring is a contiguous sequence of characters within a string.
    // Example 1:

    // Input: a = 1, b = 1, c = 7
    // Output: "ccaccbcc"
    // Explanation: "ccbccacc" would also be a correct answer.
    static int a = 7;
    static int b= 1;
    static int c = 1;

    public static void main(String[] args) {
        String ans = longestDiverseString(a, b, c);
        System.out.println(ans);
    }

    private static String longestDiverseString(int a, int b, int c) {
        PriorityQueue<PairChar> maxHeap = new PriorityQueue<>((e1, e2)-> e2.freq - e1.freq);
        StringBuilder stringBuffer = new StringBuilder();
        if (a != 0){
            maxHeap.add(new PairChar(a, 'a'));
        }
        if(b != 0){
            maxHeap.add(new PairChar(b, 'b'));
        }
        if (c != 0){
            maxHeap.add(new PairChar(c, 'c'));
        }
        while (!maxHeap.isEmpty()){
            PairChar pairChar = maxHeap.poll();
            int n = stringBuffer.length();
            if(n>1 && stringBuffer.charAt(n-1) == stringBuffer.charAt(n-2)
                    && stringBuffer.charAt(n-1) == pairChar.character){
                if(maxHeap.isEmpty()){
                    break;
                }
                PairChar nextPairChar = maxHeap.poll();
                stringBuffer.append(nextPairChar.character);
                nextPairChar.freq--;
                if (nextPairChar.freq != 0){
                    maxHeap.add(nextPairChar);
                }
            }else {
                stringBuffer.append(pairChar.character);
                pairChar.freq--;
            }
            if (pairChar.freq != 0){
                maxHeap.add(pairChar);
            }
        }
        return stringBuffer.toString();
    }
}
