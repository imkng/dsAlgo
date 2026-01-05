package com.company.stack;

import java.util.HashMap;
import java.util.Map;

class Node{
    int key; int value;
    Node next;
    Node prev;

//        public Node(int key, int value, Node next, Node prev) {
//            this.key = key;
//            this.value = value;
//            this.next = next;
//            this.prev = prev;
//        }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUImplementation {

        int capacity;
        Node head = new Node(-1, -1);
        Node tail = new Node(-1, -1);
        Map<Integer, Node> map;
        public LRUImplementation(int capacity) {
            this.capacity = capacity;
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>();
        }

        public void put(int key, int value){
            if (map.containsKey(key)){
                Node currNode = map.get(key);
                currNode.value = value;
                deleteNode(currNode);
                insertNodeAtHead(currNode);
            }else{
                if (map.size() == capacity){
                    Node node = tail.prev;
                    deleteNode(node);
                    map.remove(node.key);
                }
            }
            Node newNode = new Node(key, value);
            insertNodeAtHead(newNode);
            map.put(key, newNode);
        }

        private void insertNodeAtHead(Node currNode) {
            Node afterHead = head.next;
            head.next = currNode;
            currNode.prev = head;
            currNode.next = afterHead;
            afterHead.prev = currNode;
        }

        private void deleteNode(Node currNode) {
            Node prev = currNode.prev;
            Node nextNode = currNode.next;

            prev.next = nextNode;
            nextNode.prev = prev;
        }

        int get(int key){
            if (!map.containsKey(key)) return -1;
            Node node = map.get(key);
            deleteNode(node);
            insertNodeAtHead(node);
            return node.value;
        }

    public static void main(String[] args) {
        LRUImplementation lruImplementation = new LRUImplementation(2);
        lruImplementation.put(1,0);
        lruImplementation.put(2,2);
        System.out.println(lruImplementation.get(1));
        lruImplementation.put(3,3);
        System.out.println(lruImplementation.get(2));
        lruImplementation.put(4,4);
        System.out.println(lruImplementation.get(1));
        System.out.println(lruImplementation.get(3));
        System.out.println(lruImplementation.get(4));
//        LRUImplementation lruImplementation = new LRUImplementation(1);
//        lruImplementation.put(2,1);
//        System.out.println(lruImplementation.get(1));
    }


}
