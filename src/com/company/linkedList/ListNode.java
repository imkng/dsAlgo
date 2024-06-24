package com.company.linkedList;

public  class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static void main(String[] args) {
        ListNode node = new ListNode(1, null);

        node = insertViaHEad( node, 2);
        node = insertViaHEad(node, 3);
        printList(node);

        node = insertATail(node, 4);
        printList(node);
    }

    public static ListNode insertATail(ListNode node, int i) {
        if (node == null){
            return new ListNode(i);
        }
        if (node.next == null){
            node.next = new ListNode(i);
            return node;
        }
        ListNode temp = node;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new ListNode(i);
        return node;
    }

    public static void printList(ListNode node) {
        ListNode temp = node;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println("===============================");
    }

    public static ListNode insertViaHEad(ListNode node, int k) {
        return new ListNode(k, node);
    }


}
