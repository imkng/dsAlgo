package com.company.linkedList;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode temp = head;

        System.out.println("Before reverse: ");
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }

        ListNode ans = reverseBetween(head, 2, 4);
        System.out.println("After reverse: ");
        while (ans != null) {
            System.out.print(ans.val + " -> ");
            ans = ans.next;
        }

    }

    private static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode it = dummy;
        ListNode prevIt = null;

        for (int i = 0; i < left; i++) {
            prevIt = it;
            it = it.next;
        }

        ListNode itR = it;
        ListNode prevItR = prevIt;

        for (int i = left; i <= right; i++) {
            ListNode forward = itR.next;
            itR.next = prevItR;
            prevItR = itR;
            itR = forward;
        }

        prevIt.next = prevItR;
        it.next = itR;

        return dummy.next;
    }
}
