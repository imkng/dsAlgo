package com.company.java8.methodReference.RefDemo;

public class ReferenceDemo {
    public static void main(String[] args) {
        //providing implementation of WorkInterface

//        WorkInter workInter = () -> {
//            System.out.println("THis is new method");
//        };

        WorkInter workInter = Stuff::doStuff;
        int result = workInter.toTask(2, 5);

        Runnable runnable = Stuff::threadTask;

        Thread thread = new Thread(runnable, "odd");
        thread.start();


//        ==========================================IN\STANCE REFERENCE
        Stuff stuff = new Stuff();

        Runnable runnable1 = stuff::printNumberTHundred;

        Thread thread1 = new Thread(runnable1, "Even");
        thread1.start();
    }
}
