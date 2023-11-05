package com.company.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DeleteGreatestValueInEachRow {
    static int[][] grid = {
            {1, 2, 4},
            {3, 3, 1}
    };

    public static void main(String[] args) {
        int ans = deleteGreatestValueInEachRow(grid);
        System.out.println(ans);
    }

    private static int deleteGreatestValueInEachRow(int[][] grid) {
        int ans = 0;
        int rows = grid.length;
        List<PriorityQueue<Integer>> priorityQueueList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            priorityQueueList.add(new PriorityQueue<>(Comparator.reverseOrder()));
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                priorityQueueList.get(i).add(grid[i][j]);
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            int findMax = 0;
            for (int i = 0; i < grid.length; i++) {
                findMax = Math.max(findMax, priorityQueueList.get(i).peek());
                priorityQueueList.get(i).poll();
            }
            System.out.print(findMax + " ");
            ans += findMax;
        }
        return ans;
    }

}
