package com.company.linkedList;

public class SwappingNodesInALinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode ans = swapNodes(head, 2);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    private static ListNode swapNodes(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            len++;
            temp = temp.next;
        }
        int kthVal = 0;
        int j = 1;
        ListNode tempk = head;
        while (j < k){
            tempk = tempk.next;
            j++;
        }
        kthVal = tempk.val;

        j= 1;
        ListNode tempk1 = head;
        while (j <= len-k){
            tempk1 = tempk1.next;
            j++;
        }
        int kth = tempk1.val;
        tempk1.val = kthVal;
        tempk.val = kth;

        return head;

    }
}
