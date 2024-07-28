package com.company.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;

    // Push
    //1. Follow the below steps to implement the push(s, x) operation:
    //Enqueue x to q1 (assuming the size of q1 is unlimited).
    //Follow the below steps to implement the pop(s) operation:
    //One by one dequeue everything except the last element from q1 and enqueue to q2.
    //Dequeue the last item of q1, the dequeued item is the result, store it.
    //Swap the names of q1 and q2
    //Return the item stored in step 2.

    public StackImplUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int i){
        q2.add(i);
        while (!q1.isEmpty()){
            q2.add(q1.peek());
            q1.poll();
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop(){
        if (!q1.isEmpty()){
            return q1.poll();
        }else {
            return -1;
        }

    }

    public static void main(String[] args) {
        StackImplUsingQueue stackImplUsingQueue = new StackImplUsingQueue();

        stackImplUsingQueue.push(1);
        stackImplUsingQueue.push(2);
        stackImplUsingQueue.push(3);

        System.out.println(stackImplUsingQueue.pop());
        System.out.println(stackImplUsingQueue.pop());
        System.out.println(stackImplUsingQueue.pop());
    }
}
