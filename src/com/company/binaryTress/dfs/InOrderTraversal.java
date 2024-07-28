package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

public class InOrderTraversal {



    public static void main(String[] args) {
        Node root = Node.BinaryTree();
        // printInorder

        inOrder(root);
    }

    private static void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
}
