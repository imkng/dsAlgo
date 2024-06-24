package com.company.linkedList;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MergeNodesInBetweenZeros {

    static ListNode ans = null;

    public static void main(String[] args) {
        ListNode head= new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next= new ListNode(0);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);

        ListNode temp = mergeNodes(head);
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    private static ListNode mergeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();

        stack.push(head.val);
        ListNode temp = head.next;

        while (temp != null){
            if (temp.val != 0){
                stack.push(temp.val);
            }else {
                int sum = 0;
                while (stack.peek() != 0){
                    sum += stack.pop();
                }
                stack.push(sum);
                stack.push(temp.val);
            }
            temp = temp.next;
        }



        while (!stack.isEmpty()){
            int re = stack.pop();
            if (re != 0){
                insertIntoFront(re);
            }
        }
        return ans;
    }

    private static void insertIntoFront(int re) {
        ListNode node = new ListNode(re);
        node.next = ans;
        ans = node;
    }
}
