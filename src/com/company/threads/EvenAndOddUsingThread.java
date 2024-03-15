package com.company.threads;

public class EvenAndOddUsingThread implements Runnable {

    static int count = 1;
    Object obj;

    public EvenAndOddUsingThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        while(count <= 100){
            if(count%2 == 0 && Thread.currentThread().getName().equals("even")){
                synchronized (obj){
                    System.out.println("Thread name: " + Thread.currentThread().getName() + " value: "+ count);
                    count++;
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }else if(count%2 != 0 && Thread.currentThread().getName().equals("odd")){
                synchronized (obj){
                    System.out.println("Thread name: " + Thread.currentThread().getName() + " value: "+ count);
                    count++;
                    obj.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Runnable r1 = new EvenAndOddUsingThread(lock);
        Runnable r2 = new EvenAndOddUsingThread(lock);

        new Thread(r1, "even").start();
        new Thread(r2, "odd").start();
    }
}
