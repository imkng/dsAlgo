package com.company.linkedList;

import java.util.Stack;

public class RemoveNodesFromLinkedList {

    //You are given the head of a linked list.
    //Remove every node which has a node with a greater value anywhere to the right side of it.
    //Return the head of the modified linked list.


    // Input: head = [5,2,13,3,8]
    // Output: [13,8]
    // Explanation: The nodes that should be removed are 5, 2 and 3.
    //        - Node 13 is to the right of node 5.
    //        - Node 13 is to the right of node 2.
    //        - Node 8 is to the right of node 3.
    public static ListNode linkedList(){
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = linkedList();
        ListNode ans = removeNodes(head);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode removeNodes(ListNode head) {
        ListNode reverseHead = reverseList(head);
        // ListNode temp = reverseHead;
        //while (temp != null){
        //    System.out.println(temp.val);
        //    temp = temp.next;
        //}

        Stack<Integer> stack = new Stack<>();

        ListNode temp = reverseHead;
        while (temp != null){
            if (stack.isEmpty() || stack.peek() < temp.val){
                stack.push(temp.val);
            }
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        while (!stack.isEmpty()){
            dummy.next = new ListNode(stack.pop());
            dummy = dummy.next;
        }
        return ans.next;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}
