package com.company.leetCode;

public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }

    private static int numberOfSteps(int num) {
        int count = 0;
        while (num != 0){
            if (num%2 != 0){
                num = num - 1;
            }else {
                num = num / 2;
            }
            count++;

        }

        return count;
    }
}
