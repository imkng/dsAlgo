package com.company.threads.multiThreading.threadCommunication.counterExample;

public class Counter {
    private int count = 0;

    public synchronized void increment(){
        count++;
        System.out.println(Thread.currentThread().getName() + " " + count);
    }
    public int getCount(){
        return this.count;
    }
}
