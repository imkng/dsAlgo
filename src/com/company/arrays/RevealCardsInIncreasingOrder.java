package com.company.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RevealCardsInIncreasingOrder {
    static int[] deck = {17, 13, 11, 2, 3, 5, 7};

    public static void main(String[] args) {
        int[] ans = deckRevealedIncreasing(deck);

        for (int ele :
                ans) {
            System.out.println(ele);
        }

        Map<Integer, Long> map = Arrays.stream(ans).boxed()
                .map(e -> 2 * e)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.keySet().stream().forEach(System.out::println);
    }

    private static int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[q.poll()] = deck[i];
            q.add(q.poll());
        }
        return res;
    }
}
