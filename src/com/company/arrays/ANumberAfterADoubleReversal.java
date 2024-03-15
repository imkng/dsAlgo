package com.company.arrays;

public class ANumberAfterADoubleReversal {
    static int num = 1800;

    public static void main(String[] args) {
        boolean ans = isSameAfterReversals(num);
    }

    private static boolean isSameAfterReversals(int num) {
        int firstReverse = reverseNum(num);
        System.out.println(firstReverse);
        int secondReverse = reverseNum(firstReverse);
        System.out.println(secondReverse);
        return secondReverse == num;
    }
    private static int reverseNum(int num){
        int res  = 0;
        while(num != 0){
            int rem = num % 10;
            res = res * 10 + rem;
            num = num/10;
        }
        return res;
    }
}
