package com.company.threads;

public class Consumer extends Thread {

    Company company;

    public Consumer(Company company) {
        this.company = company;
    }

    public void run() {
        while (true) {
            this.company.consume_item();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
