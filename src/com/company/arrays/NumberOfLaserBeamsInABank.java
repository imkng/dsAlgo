package com.company.arrays;

public class NumberOfLaserBeamsInABank {
    static String[] bank = {"011001", "000000", "010100", "001000"};

    //Input: bank = ["011001","000000","010100","001000"]
    //Output: 8
    //Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
    //        * bank[0][1] -- bank[2][1]
    //        * bank[0][1] -- bank[2][3]
    //        * bank[0][2] -- bank[2][1]
    //        * bank[0][2] -- bank[2][3]
    //        * bank[0][5] -- bank[2][1]
    //        * bank[0][5] -- bank[2][3]
    //        * bank[2][1] -- bank[3][2]
    //        * bank[2][3] -- bank[3][2]
    //Note that there is no beam between any device on the 0th row with any on the 3rd row.
    //This is because the 2nd row contains security devices, which breaks the second condition

    public static void main(String[] args) {
        int ans = numberOfBeams(bank);
        System.out.println(ans);
    }

    private static int numberOfBeams(String[] bank) {
        int prevCount = 0;
        int total = 0;
        for (int i = 0; i < bank.length; i++) {
            int currentCount = countOnes(bank[i]);
            if (currentCount == 0) {
                continue;
            }
            total += prevCount * currentCount;
            prevCount = currentCount;
        }
        return total;
    }

    private static int countOnes(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
