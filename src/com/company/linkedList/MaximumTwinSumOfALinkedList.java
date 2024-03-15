package com.company.linkedList;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSumOfALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        int ans = pairSum(head);
        System.out.println(ans);
    }

    private static int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int ans = Integer.MIN_VALUE;
        int i = 0;
        int n = list.size();
        while (i < list.size() / 2) {
            ans = Math.max(ans, list.get(i) + list.get(n - i - 1));
            i++;
        }
        return ans;
    }
}
