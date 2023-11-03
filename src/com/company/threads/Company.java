package com.company.threads;

public class Company {

    int item;
    boolean buffer_is_empty = false;

    //false : chance of Producer
    //true: chance of Consumer
    synchronized public void produce_item(int item) {
        if (buffer_is_empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.item = item;
        notify();
        buffer_is_empty = true;
        System.out.println("Produced Item: " + item);
    }

    synchronized public int consume_item() {
        if (!buffer_is_empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Consumed Item: " + this.item);
        notify();
        buffer_is_empty = false;
        return this.item;
    }
}
