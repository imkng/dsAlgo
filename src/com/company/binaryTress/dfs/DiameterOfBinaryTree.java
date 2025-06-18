package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

public class DiameterOfBinaryTree {

    static int maxDiaMeter = 0;

    private static int diameterOfBinaryTree(Node node){
        if (node == null) return 0;
        int lh = diameterOfBinaryTree(node.left);
        int rh = diameterOfBinaryTree(node.right);

        maxDiaMeter = Math.max(maxDiaMeter, lh + rh);

        return 1 + Math.max(lh,rh);
    }
    public static void main(String[] args) {
        int dia = diameterOfBinaryTree(Node.BalancedBinaryTree());
        System.out.println(dia);
    }
}
