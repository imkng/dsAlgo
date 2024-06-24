package com.company.linkedList;

public class FindMiddleElementOfLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(12);
        node = ListNode.insertViaHEad(node, 2);
        node = ListNode.insertViaHEad(node, 3);
        node = ListNode.insertViaHEad(node, 4);
        node = ListNode.insertViaHEad(node, 5);
        node = ListNode.insertViaHEad(node, 6);
        node = ListNode.insertViaHEad(node, 7);
        ListNode.printList(node);

        ListNode midNode = findMidNode(node);
        System.out.println(midNode.val);
    }

    private static ListNode findMidNode(ListNode node) {
        ListNode slow = node;
        ListNode fast  = node;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
