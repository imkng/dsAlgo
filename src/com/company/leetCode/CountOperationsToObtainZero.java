package com.company.leetCode;

public class CountOperationsToObtainZero {

    public static void main(String[] args) {
        int num1 = 2, num2 = 3;
        int ans = countOperations(num1, num2);
        System.out.println(ans);
    }

    private static int countOperations(int num1, int num2) {

        return returnFIndAns(num1, num2);
    }

    private static int returnFIndAns(int num1, int num2) {
        if (num1 == 0 || num2 == 0) return 0;
        if (num2 >= num1){
            return 1 + returnFIndAns(num1, num2-num1);
        }else{
            return 1 + returnFIndAns(num1-num2, num2);
        }

//        int count=0;
//        while(!(num1==0||num2==0)){
//            if(num1>=num2)num1-=num2;
//            else num2-=num1;
//            count++;
//        }
//        return count;
    }
}
