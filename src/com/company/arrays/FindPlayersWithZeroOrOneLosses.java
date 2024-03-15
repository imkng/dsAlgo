package com.company.arrays;


import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    static int[][] matches = {{2,3},{1,3},{5,4},{6,4}};
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {

        List<List<Integer>> lists = findPlayersWithZeroOrOneLosses(matches);
        lists.forEach(System.out::println);
    }

    private static List<List<Integer>> findPlayersWithZeroOrOneLosses(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> numberOfPlayers = new ArrayList<>();
        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < matches[i].length; j++) {
                if (!numberOfPlayers.contains(matches[i][j])){
                    numberOfPlayers.add(matches[i][j]);
                }
            }
        }
        Map<Integer, Integer> losers = new HashMap<>();
        for (int i = 0; i < matches.length; i++) {
            if(losers.containsKey(matches[i][1])){
                int temp = losers.get(matches[i][1]);
                temp++;
                losers.put(matches[i][1], temp);
            }else{
                losers.put(matches[i][1], 1);
            }

        }
        List<Integer> oneTimeLoser = new ArrayList<>();
        for (Map.Entry<Integer, Integer> mp : losers.entrySet()) {
            if(mp.getValue() <= 1){
                oneTimeLoser.add(mp.getKey());
                numberOfPlayers.remove(mp.getKey());
            }else{
                numberOfPlayers.remove(mp.getKey());
            }
        }
        Collections.sort(numberOfPlayers);
        Collections.sort(oneTimeLoser);
        ans.add(numberOfPlayers);
        ans.add(oneTimeLoser);
        return ans;
    }
}
