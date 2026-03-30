package com.company.leetCode;

public class MinimumMovesToReachTargetScore {
    public static void main(String[] args) {
        int target = 19;
        int maxDoubles = 2;
        System.out.println(minMoves(target, maxDoubles));
    }

    private static int minMoves(int target, int maxDoubles) {
        int count = 0;
        while (target != 1){
            if (maxDoubles > 0 && target%2 == 0){
                maxDoubles -= 1;
                target /=2;
                count++;
            }else {
                target -= 1;
                count++;
            }
            if (maxDoubles == 0){
                count += target - 1;
                break;
            }
        }
        return count;
    }
}
