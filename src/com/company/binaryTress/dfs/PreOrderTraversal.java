package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

public class PreOrderTraversal {

    public static void main(String[] args) {
        Node root = Node.BinaryTree();

        preOrderTraversal(root);
    }

    private static void preOrderTraversal(Node root) {
        if (root == null) return;

        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
