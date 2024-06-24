package com.company.BinarySearchTree;

public class BinarySearchTree {

    public static Node insert(Node root, int key){
        if(root == null){
            return new Node(key);
        }
        if (root.value < key){
            root.right = insert(root.right, key);
        }else if (root.value > key){
            root.left = insert(root.left, key);
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 50);
        insert(root, 20);
        insert(root, 30);
        insert(root, 40);
        insert(root, 60);
        insert(root, 70);

        displayOrder(root);
    }

    private static void displayOrder(Node root) {
        if (root != null){
            displayOrder(root.left);
            System.out.println(root.value);
            displayOrder(root.right);
        }
    }
}
