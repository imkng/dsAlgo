package com.company.binaryTress;

import java.util.Scanner;

public class BinaryTree {
    Node root;

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
        bt.populate(scanner);
        bt.display();
    }
}
