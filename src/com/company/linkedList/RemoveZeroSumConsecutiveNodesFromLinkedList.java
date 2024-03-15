package com.company.linkedList;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        ListNode ans = removeZeroSumSublists(head);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode removeZeroSumSublists(ListNode head) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            return head;
        }

        ListNode temp = head.next;
        ListNode dummy = head;

        while (temp != null){
            if(temp.next != null){
                if(dummy.val + temp.val == 0){
                    dummy = temp;
                    temp = temp.next;
                }
            }
        }
        return head;
    }
}
