package com.company.binaryTress;

public class CeilInBST {
//    Node root;

    int ceilIn(Node node , int input){
        if (node == null) {
            return -1;
        }

        // We found equal key
        if (node.data == input) {
            return node.data;
        }

        // If root's key is smaller,
        // ceil must be in right subtree
        if (node.data < input) {
            return ceilIn(node.right, input);
        }

        // Else, either left subtree or root
        // has the ceil value
        int ceil = ceilIn(node.left, input);

        return (ceil >= input) ? ceil : node.data;
    }

    public static void main(String[] args) {
        CeilInBST ceilInBST = new CeilInBST();
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        System.out.println("Ceil of 3 is: " + ceilInBST.ceilIn(root, 3));

    }
}
