package com.company.threads.multiThreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {
    // ReentrantReadWriteLock: -allow multiple threads to read the resources concurrently as long as no thread is writing to it.
    private int count = 0;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public void increment(){
        writeLock.lock();
        try {
            count++;
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public int readCounter(){
        readLock.lock();
        try {
            Thread.sleep(10);
            return count;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter readWriteCounter = new ReadWriteCounter();
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    System.out.println(Thread.currentThread().getName() + " read: " + readWriteCounter.readCounter());
                }
            }
        };
        Runnable writeTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    readWriteCounter.increment();
                    System.out.println(Thread.currentThread().getName() + " incremented!!: ");
                }
            }
        };

        Thread write1 = new Thread(writeTask);
        Thread  read1 = new Thread(readTask);
        Thread read2 = new Thread(readTask);


        read1.start();
        read2.start();
        write1.start();

        write1.join();
        read1.join();
        read2.join();

    }
}
