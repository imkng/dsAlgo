package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

public class MaximumDepthInBT {

    public static void main(String[] args) {
        int maxDepth = maxDepth(Node.BinaryTree());
        System.out.println(maxDepth);
    }

    public static int maxDepth(Node node) {
        if (node == null) return 0;
        int lh = maxDepth(node.left);
        int rh = maxDepth(node.right);
        return 1 + Math.max(lh, rh);
    }
}
