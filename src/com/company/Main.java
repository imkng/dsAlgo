package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> per = new HashSet<>();
        permute(input.toCharArray(), 0, per);

        List<Integer> nums = new ArrayList<>();
        for (String pre : per){
            nums.add(Integer.parseInt(pre));
        }
        Collections.sort(nums, Collections.reverseOrder());
        for (int num : nums) {
            if (isPrime(num)){
                System.out.println(num);
                return;
            }
        }
        System.out.println(-1);
    }
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num<= 3) return true;
        if (num %2 == 0 || num %3 == 0) return false;
        for (int i = 5; i*i < num ; i+=6) {
            if (num%i == 0 || num % (i+2) == 0) return false;
        }
        return true;
    }

    private static void permute(char[] charArray, int index, Set<String> per) {
        if (index == charArray.length - 1){
            per.add(new String(charArray));
            return;
        }
        for (int i = index; i < charArray.length; i++) {
            swap(charArray, index, i);
            permute(charArray, index + 1, per);
            swap(charArray, index, i);
        }
    }

    private static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
