package com.company.linkedList;

public class FindStartingPointOfCycle {
    public static void main(String[] args) {
        ListNode node = new ListNode(12);
        node = ListNode.insertViaHEad(node, 2);
        node = ListNode.insertViaHEad(node, 3);
        node = ListNode.insertViaHEad(node, 4);
        node = ListNode.insertViaHEad(node, 5);
        node = ListNode.insertViaHEad(node, 6);
        node = ListNode.insertViaHEad(node, 7);

        createCycle(node, 4);

        ListNode startNode = startingOfCycle(node);
        System.out.println(startNode.val);
    }

    private static ListNode startingOfCycle(ListNode node) {
        ListNode slow = node, fast = node;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return findStartingNode(node, slow, fast);
             }
        }
        return null;
    }

    private static ListNode findStartingNode(ListNode node, ListNode slow, ListNode fast) {
        slow = node;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void createCycle(ListNode head, int pos) {
        if (pos == -1) {
            return;
        }

        ListNode cycleNode = null;
        ListNode tail = head;
        int index = 0;

        while (tail.next != null) {
            if (index == pos) {
                cycleNode = tail;
            }
            tail = tail.next;
            index++;
        }

        tail.next = cycleNode;
    }
}
