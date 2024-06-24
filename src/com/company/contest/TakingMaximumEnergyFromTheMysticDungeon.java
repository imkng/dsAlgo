package com.company.contest;

public class TakingMaximumEnergyFromTheMysticDungeon {
    static int []energy = {-2,-3,-1
            };
    static int k = 2;
    public static void main(String[] args) {
        int ans = maximumEnergy(energy, k);
        System.out.println(ans);
        char c = 65;
        System.out.println(c);
    }

    private static int maximumEnergy(int[] energy, int k) {
        int maxEnergy = Integer.MIN_VALUE;
        for (int i = energy.length - 1; i >= energy.length - k; i--) {
            int ans = 0;
            for (int j = i; j >= 0; j= j - k) {
                ans += energy[j];
                maxEnergy = Math.max(ans, maxEnergy);

            }
//            maxEnergy = Math.max(ans, maxEnergy);
        }
        return maxEnergy;
    }

}
