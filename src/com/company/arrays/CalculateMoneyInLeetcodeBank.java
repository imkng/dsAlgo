package com.company.arrays;

public class CalculateMoneyInLeetcodeBank {
    static int n = 20;

    public static void main(String[] args) {
        int ans = totalMoney(n);
        System.out.println((int)ans);
    }

    private static int totalMoney(int n) {
        int intial = 1;
        int totalSum = 0;
        if(n < 7){
            return (int) ((2*intial + n-1)*(float) n /2);
        }
        int totalWeek = n/7;
        int rem = n%7;
        for (int i = 0; i < totalWeek; i++) {
            int weeklySum = 0;
            for (int j = 0; j < 7; j++) {
                weeklySum += intial + j;
            }
            totalSum += weeklySum;
            intial++;
        }

        if (rem > 0){
             return totalSum + (int) ((2 * intial + rem - 1) * (float) rem / 2);
        }
        return totalSum;
    }
}
