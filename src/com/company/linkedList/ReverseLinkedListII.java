package com.company.linkedList;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        LinkedList.ListNode head = new LinkedList.ListNode(1);
        head.next = new LinkedList.ListNode(2);
        head.next.next = new LinkedList.ListNode(3);
        head.next.next.next = new LinkedList.ListNode(4);
        head.next.next.next.next = new LinkedList.ListNode(5);

        LinkedList.ListNode temp = head;

        System.out.println("Before reverse: ");
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        LinkedList.ListNode ans = reverseBetween(head, 2, 4);
        System.out.println("After reverse: ");
        while (ans != null) {
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }

    }

    private static LinkedList.ListNode reverseBetween(LinkedList.ListNode head, int left, int right) {
        LinkedList.ListNode dummy = new LinkedList.ListNode(-1);
        dummy.next = head;
        LinkedList.ListNode it = dummy;
        LinkedList.ListNode prevIt = null;

        for (int i = 0; i < left; i++) {
            prevIt = it;
            it = it.next;
        }

        LinkedList.ListNode itR = it;
        LinkedList.ListNode prevItR = prevIt;

        for (int i = left; i <= right; i++) {
            LinkedList.ListNode forward = itR.next;
            itR.next = prevItR;
            prevItR = itR;
            itR = forward;
        }

        prevIt.next = prevItR;
        it.next = itR;

        return dummy.next;
    }
}
