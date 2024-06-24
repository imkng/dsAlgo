package com.company.java8.methodReference.RefDemo;

public class Stuff {
    public static int doStuff(int a, int b) {
        System.out.println("I am on this task");
        return a+b;
    }

    public static void threadTask(){
        for(int i = 1; i<=10; i++){
            System.out.println(i*2);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printNumberTHundred(){
        for(int i = 1; i<=10; i++){
            System.out.println(i*2);
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
