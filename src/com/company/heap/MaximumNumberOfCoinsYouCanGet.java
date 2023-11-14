package com.company.heap;

import java.util.PriorityQueue;

public class MaximumNumberOfCoinsYouCanGet {
    //There are 3n piles of coins of varying size, you and your friends will take piles
    //of coins as follows:

    //In each step, you will choose any 3 piles of coins (not necessarily consecutive).
    //Of your choice, Alice will pick the pile with the maximum number of coins.
    //You will pick the next pile with the maximum number of coins.
    //Your friend Bob will pick the last pile.
    //Repeat until there are no more piles of coins.
    static int[] piles = {2,4,1,2,7,8};

    //Output: 9
    //Explanation: Choose the triplet (2, 7, 8), Alice Pick the pile with 8 coins, you the pile with 7 coins and Bob the last one.
    //Choose the triplet (1, 2, 4), Alice Pick the pile with 4 coins, you the pile with 2 coins and Bob the last one.
    //The maximum number of coins which you can have are: 7 + 2 = 9.
    //On the other hand if we choose this arrangement (1, 2, 8), (2, 4, 7) you only get 2 + 4 = 6 coins which is not optimal.


    public static void main(String[] args) {
        int maxCoins = findMaximumCoinYouHave(piles);
        System.out.println(maxCoins);
    }

    private static int findMaximumCoinYouHave(int[] piles) {
        int  n = piles.length / 3;
        int ans = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int q = 0; q < piles.length; q++) {
            minHeap.add(piles[q]);
            if (minHeap.size() > 2*n){
                minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()){
            ans += minHeap.poll();
            minHeap.poll();
        }
        return ans;
    }
}
