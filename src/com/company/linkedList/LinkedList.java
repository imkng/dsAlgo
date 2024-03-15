package com.company.linkedList;

import java.util.ArrayList;

public class LinkedList {

    static ListNode insertElement(ListNode root, int first, int second){
        ListNode firstNode = new ListNode(first);

        firstNode.next = new ListNode(second);

        if(root == null){
            root = firstNode;
        }else{
            ListNode temp = root;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = firstNode;
        }

        return root;
    }

    public void reorderList(ListNode head)  {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }
        // ListNode node = new ListNode(head.data);
//        List<Integer> arr = List.of(1,2,3,4,5);
        ListNode node = null;
        int i = 0;
        for( ; i < arr.size()/2; i++){
            node = insertElement(node, arr.get(i), arr.get(arr.size()-i-1));
        }
        if(arr.size() %2 != 0){
            node = insertOne(node, arr.get(i));
        }

        System.out.println(node.val);
        head = node;

        System.out.println(head.val);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        LinkedList linkedList = new LinkedList();
        linkedList.reorderList(head);
    }
    private static ListNode insertOne(ListNode root, Integer integer) {
        ListNode firstNode = new ListNode(integer);

        if(root == null){
            root = firstNode;
        }else{
            ListNode temp = root;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = firstNode;
        }

        return root;
    }
}
