package com.company.threads.multiThreading.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

//    public synchronized void withDrawAmount(int amount){
        public void withDrawAmount(int amount){
        System.out.println(Thread.currentThread().getName() + " " + "attempting to withdraw " + amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)){
                if (balance >= amount){
                    System.out.println(Thread.currentThread().getName() + " " + "proceeding with withdrawal ");
                    try {
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " " + "completed with withdrawal ");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }finally {
                        lock.unlock();
                    }
                }else {
                    System.out.println(Thread.currentThread().getName() + "Insufficinent amount");
                }
            }else {
                System.out.println(Thread.currentThread().getName()  + " not able to accuires the lock!. Please try again later");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
