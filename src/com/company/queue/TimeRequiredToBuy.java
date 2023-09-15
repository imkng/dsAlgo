package com.company.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TimeRequiredToBuy {
    static int[] tickets = new int[]{2,3,2};

    public static int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < tickets.length; i++){
            queue.add(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            tickets[queue.peek()]--;
            if(tickets[queue.peek()] == 0){
                queue.remove();
            }else if(tickets[queue.peek()] != 0){
                queue.add(queue.peek());
                queue.remove();
            }
            count++;
            if(tickets[k] == 0){
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int k = timeRequiredToBuy(tickets, 2);
    }
}
