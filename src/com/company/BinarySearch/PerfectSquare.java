package com.company.BinarySearch;

import java.util.Scanner;

public class PerfectSquare {
    Boolean check(long temp){
        long low = 1;
        long high = temp;
        while(low <= high){
            long mid = low + (high - low)/2;
            if(mid*mid == temp) {
                return true;
            }else if(mid*mid > temp){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        PerfectSquare ps = new PerfectSquare();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any number: ");

        long temp = sc.nextLong();


        System.out.println("Is Entered Number is perfect square? " + ps.check(temp));


    }
}
