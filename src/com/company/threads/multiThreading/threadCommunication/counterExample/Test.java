package com.company.threads.multiThreading.threadCommunication.counterExample;

public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread myThread1 = new MyThread(counter);
        myThread1.setName("t1");
        MyThread myThread2 = new MyThread(counter);
        myThread2.setName("t2");
        myThread1.start();
        myThread2.start();


        try {
            myThread1.join();
            myThread2.join();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(counter.getCount());

    }
}
