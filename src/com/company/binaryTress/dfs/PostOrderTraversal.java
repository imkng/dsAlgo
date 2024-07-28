package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

public class PostOrderTraversal {
    public static void main(String[] args) {
        // left, right, root
        Node root= Node.BinaryTree();
        postOrderTraversal(root);
    }

    private static void postOrderTraversal(Node root) {
        if (root == null) return;

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }
}
