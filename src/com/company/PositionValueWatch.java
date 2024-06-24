package com.company;

import java.util.Scanner;

public class PositionValueWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] nu = input.split(",");
        boolean found = false;
        for (int i = 0; i < nu.length; i++) {
            int value = Integer.parseInt(nu[i]);
            if (value == i+1){
                System.out.println(value);
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println(-1);
        }

    }
}
