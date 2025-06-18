package com.company.threads.multiThreading.threadCommunication.counterExample;

public class MyThread extends Thread{
    private Counter counter;
    public MyThread(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i =0; i < 2000; i++){
            counter.increment();
        }
    }
}
