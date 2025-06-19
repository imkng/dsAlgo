package com.company.threads.multiThreading.lock;

class SharedResource {
    int data;
    private boolean hasData;

    public synchronized void produce(int data){
        while (hasData) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        data = data;
        hasData = true;
        System.out.println("Produced " + data);
        notify();
    }

    public synchronized int consume(){
        while (!hasData) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify();
        
        return data;
    }
    
}

class Producer implements Runnable{

    private SharedResource sharedResource;

    public Producer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {
            sharedResource.produce(i);
            
        }
    }

    
}

class Consumer implements Runnable{

    private SharedResource sharedResource;

    public Consumer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 10; i++) {
            int t = sharedResource.consume();
        }
    }

    
}

public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producer = new Thread(new Producer(sharedResource));
        Thread consumer = new Thread(new Consumer(sharedResource));

        producer.start();
        consumer.start();

    }
}

