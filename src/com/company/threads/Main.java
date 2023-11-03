package com.company.threads;


public class Main {

    public static void main(String[] args) {
        //By Implementing Runnable functional interface
        MyThread1 myThread1 = new MyThread1();
        // start -> java.lang.Thread
        Thread thread = new Thread(myThread1);
        thread.start();

        //By Extending Thread class
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

//        for (int i = 0; i < 10; i++) {
//            System.out.println("Main i : "  + i);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }


        //By using lambda function
        Runnable runnable = ()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnnable i : "  + i);
                Thread currentThread  = Thread.currentThread();

                System.out.println("Thread Name: " + currentThread.getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.start();



    }
}
