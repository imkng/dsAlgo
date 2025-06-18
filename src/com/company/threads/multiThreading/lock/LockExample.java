package com.company.threads.multiThreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private final Lock lock = new ReentrantLock(true);

    public void accessResource(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }finally {
            System.out.println(Thread.currentThread().getName() + " released lock");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockExample example = new LockExample();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };
        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "Thread 3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
    // So synchronised keyword has following dis:
    // 1. Unfairness 2. Blocking 3. Interuptibility 4. Read/Write Locking
}
