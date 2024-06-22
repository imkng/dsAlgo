package com.company.linkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(12);
        node = ListNode.insertViaHEad(node, 2);
        node = ListNode.insertViaHEad(node, 3);
        node = ListNode.insertViaHEad(node, 4);
        node = ListNode.insertViaHEad(node, 5);
        node = ListNode.insertViaHEad(node, 6);
        node = ListNode.insertViaHEad(node, 7);

        ListNode.printList(node);

        ListNode ans = reverseLinkedList(node);

        ListNode.printList(ans);
    }

    private static ListNode reverseLinkedList(ListNode node) {
        ListNode prev = null;
        ListNode temp = node;
        while (temp != null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

}
