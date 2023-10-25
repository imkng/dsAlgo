package com.company.BinarySearch;

public class CountNegativeNumbersInASortedMatrix {
    static int[][] grid = {
            {4, 3, 2, -1},
            {3, 2, 1, -1},
            {1, 1, -1, -2},
            {-1, -1, -2, -3}
    };
    // Output: 8
    // Explanation: There are 8 negatives number in the matrix.

    public static void main(String[] args) {
        int countNegativesInGrid = countNegatives(grid);
        System.out.println("# of Negative num are: " + countNegativesInGrid);
    }

    private static int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int start = 0;
            int end = grid[i].length - 1;
            int absFloor = 0;
            int floor = -1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (grid[i][mid] == 0) {
                    start = mid + 1;
                } else if (grid[i][mid] > 0) {
                    start = mid + 1;
                } else if (grid[i][mid] < 0) {
                    floor = mid;
                    end = mid - 1;
                }
            }
            if (floor != -1) {
                count += grid[i].length - floor;
            }
        }
        return count;
    }
}
