package com.company.arrays;

import java.util.*;

class PairChar{
    private char character;
    private int frequency;

    public PairChar(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}

public class SortCharactersByFrequency {

    //static String s = "tree";
    //static String s = "cccaaa";
    static String s = "Aabb";

    public static void main(String[] args) {
        String ans = frequencySort(s);
        System.out.println(ans);
    }


    private static String frequencySort(String s) {
        PriorityQueue<PairChar> heap = new PriorityQueue<>((a, b) ->{
           if(a.getFrequency() == b.getFrequency()){
               return a.getCharacter() - b.getCharacter();
           }else {
               return b.getFrequency() - a.getFrequency();
           }
        });
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                int temp = map.get(s.charAt(i));
                map.put(s.charAt(i), ++temp);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        for(Map.Entry<Character, Integer> itr: map.entrySet()){
            heap.add(new PairChar(itr.getKey(), itr.getValue()));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!heap.isEmpty()){
            PairChar pairChar = heap.poll();
            int freq = pairChar.getFrequency();
            for (int i = 0; i < freq; i++) {
                stringBuilder.append(pairChar.getCharacter());
            }
        }
        return stringBuilder.toString();
    }
}
