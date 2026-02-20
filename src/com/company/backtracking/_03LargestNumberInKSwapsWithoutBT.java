package com.company.backtracking;

public class _03LargestNumberInKSwapsWithoutBT {
    public static void main(String[] args) {
        int number = 1234567;
        String ans = findLarget(number, 4);
        System.out.println(ans);
    }

    private static String findLarget(int number, int k) {
        char[] str = Integer.toString(number).toCharArray();
        int i = 0;
        while (k != 0){
            int largetIndexSwap = findLargest(str, i);
            swap(str, i, largetIndexSwap);
            i++;
            k--;
        }
        return str.toString();
    }

    private static void swap(char[] str, int i, int largetIndexSwap) {
        char temp = str[i];
        str[i] = str[largetIndexSwap];
        str[largetIndexSwap] = temp;
    }

    private static int findLargest(char[] str, int index) {
        int ans = -1;
        int compareIntger = str[index-1] - '0';
        for (int i = index; i < str.length; i++) {
            if (compareIntger < str[i] - '0'){
                ans = i;
            }
        }
        return ans;
    }
}
