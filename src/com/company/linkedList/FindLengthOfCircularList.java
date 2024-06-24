package com.company.linkedList;

import java.util.HashMap;
import java.util.Map;

public class FindLengthOfCircularList {
    public static void main(String[] args) {
        ListNode node = new ListNode(12);
        node = ListNode.insertViaHEad(node, 2);
        node = ListNode.insertViaHEad(node, 3);
        node = ListNode.insertViaHEad(node, 4);
        node = ListNode.insertViaHEad(node, 5);
        node = ListNode.insertViaHEad(node, 6);
        node = ListNode.insertViaHEad(node, 7);

        createCycle(node, 4);

        int lengthOfCycle = findlengthOfCycle(node);
        System.out.println(lengthOfCycle);
    }

    private static int findlengthOfCycle(ListNode node) {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode temp = node;
        int counter = 0;
        while (temp != null){
            if (!map.containsKey(temp)){
                map.put(temp, ++counter);
            } else {
                int value = map.get(temp);
                return counter - value;
            }
            temp = temp.next;
        }
        return 0;
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
