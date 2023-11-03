package com.company.threads;

public class Producer extends Thread {

    Company company;

    public Producer(Company company) {
        this.company = company;
    }

    public void run() {
        int i = 1;
        while (true) {
            this.company.produce_item(i);
            try {
                Thread.sleep(2000);
            } catch (Exception ignored) {

            }
            i++;
        }
    }

}
