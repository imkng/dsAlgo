package com.company.threads.multiThreading.threadCommunication;

class SharedResource{
    private int data;
    private boolean hasData;

    public  synchronized void produce(int i){
        while (hasData){
            try {
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        data = i;
        System.out.println("Produced data: " + i);
        hasData = true;
        notify();
    }

    public synchronized int consume(){
        while (!hasData){
            try {
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        System.out.println("Consumed data: " + data);
        notify();
        return data;
    }
}

class Consumer implements Runnable{

    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.consume();
        }
    }
}

class Producer implements Runnable{
    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedResource.produce(i);
        }
    }
}
public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource sharedResource  = new SharedResource();
        Thread consumerThread = new Thread(new Consumer(sharedResource));
        Thread producerThread = new Thread(new Producer(sharedResource));

        consumerThread.start();
        producerThread.start();
    }
}
