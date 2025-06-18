package com.company.binaryTress;

import java.util.Scanner;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insertInBT(int value){
        root = insertRecusively(root, value);
    }

    private Node insertRecusively(Node root, int value) {
        if (root == null){
            root = new Node(value);
            return root;
        }
        if (root.data > value){
            root.left =  insertRecusively(root.left, value);
        }else {
            root.right = insertRecusively(root.right, value);
        }
        return root;
    }

    public void populate(Scanner scanner){
        System.out.println("Enter root Node");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node root) {
        System.out.println("Do you want to enter Enter left of Node: " + root.data);
        boolean left = scanner.nextBoolean();
        if (left){
            System.out.println("Enter the value");
            root.left = new Node(scanner.nextInt());
            populate(scanner, root.left);
        }
        System.out.println("Enter right of Node: " + root.data);
        boolean right = scanner.nextBoolean();
        if (right){
            System.out.println("Enter the value");
            root.right = new Node(scanner.nextInt());
            populate(scanner, root.right);
        }
    }

    public Node getRoot() {
        return root;
    }

    public void display(){
        display(root, "");
    }

    private void display(Node root, String s) {
        if (root == null) return;
        System.out.println(s + root.data);
        display(root.left, s + "\t");
        display(root.right, s + "\t");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryTree bt = new BinaryTree();
//        bt.populate(scanner);
//        bt.display();

        bt.insertInBT(12);
        bt.insertInBT(13);
        bt.insertInBT(11);
        bt.insertInBT(10);
        bt.display();
    }
}
