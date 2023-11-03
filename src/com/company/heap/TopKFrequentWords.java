package com.company.heap;

import java.util.*;
import java.util.stream.Collectors;

class Pair{
    private final int count;
    private final String word;

    public int getCount() {
        return count;
    }

    public Pair(int count, String word) {
        this.count = count;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "count=" + count +
                ", word='" + word + '\'' +
                '}';
    }
}

public class TopKFrequentWords {

//    Given an array of strings words and an integer k, return the k most frequent strings.
//    Return the answer sorted by the frequency from highest to lowest.
//    Sort the words with the same frequency by their lexicographical order.
    static String[] words = {"i","love","leetcode","i","love","coding"};
    static int k = 2;

//    Output: ["i","love"]
//    Explanation: "i" and "love" are the two most frequent words.
//    Note that "i" comes before "love" due to a lower alphabetical order.



    public static void main(String[] args) {
        List<String> ans = topKFrequentWords(words, k);
        for (String str: ans
             ) {
            System.out.println(str);
        }

    }

    private static List<String> topKFrequentWords(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String str :
                words) {
            if(map.containsKey(str)){
                int temp = map.get(str);
                map.put(str, temp + 1);
            }else {
                map.put(str, 1);
            }
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.getCount()==b.getCount()){
                    return a.getWord().compareTo(b.getWord());
                }
                return a.getCount() - b.getCount();
            }
        });
        for (Map.Entry<String, Integer> mp : map.entrySet()){
            minHeap.add(new Pair(mp.getValue(), mp.getKey()));
            if (minHeap.size()>k){
                minHeap.poll();
            }
        }
        List<Pair> ans = new ArrayList<>();
        while (!minHeap.isEmpty()){
            Pair pair = minHeap.poll();
            System.out.println(pair);
            ans.add(pair);
        }
        return ans.stream().
                sorted((a,b)-> a.getCount() == b.getCount()? a.getWord().compareTo(b.getWord())
                        : b.getCount()- a.getCount()).map(Pair::getWord).collect(Collectors.toList());
    }
}
