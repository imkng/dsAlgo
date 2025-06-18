package com.company.threads.multiThreading.threadCommunication;

class SharedCounter {
    int maxValue;
    boolean isEvenTurn;
    public SharedCounter(int maxValue) {
        this.maxValue = maxValue;
    }
    
    public synchronized void printEven(){
        for (int i = 0; i <= maxValue; i+=2) {
            while (!isEvenTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("Even: " + i);
            isEvenTurn = false;
            notify();
        }
    }

    public synchronized void printOdd(){
        for (int i = 1; i <= maxValue; i+=2) {
            while (isEvenTurn) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println("Odd: " + i);
            isEvenTurn = true;
            notify();
        }
    }

    
}

class InnerEven implements Runnable{
    SharedCounter sharedCounter;

    public InnerEven(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        sharedCounter.printEven();
    }
    
}

class InnerOdd implements Runnable{
    SharedCounter sharedCounter;

    public InnerOdd(SharedCounter sharedCounter) {
        this.sharedCounter = sharedCounter;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        sharedCounter.printOdd();
    }
    
}

public class EvenOdd {
    public static void main(String[] args) {
        SharedCounter sharedCounter = new SharedCounter(10);
        Thread eveThread = new Thread(new InnerEven(sharedCounter));
        Thread oddThread = new Thread(new InnerOdd(sharedCounter));

        eveThread.start();
        oddThread.start();
    }

}
