package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

public class CheckedBalancedBT {
    // naive solutions -> O(n^2)
    public static boolean  naiveCheck(Node node){
        if (node == null) return true;
        int lh = MaximumDepthInBT.maxDepth(node.left);
        int rh = MaximumDepthInBT.maxDepth(node.right);

        if(Math.abs(lh-rh)>1) return false;

        boolean left = naiveCheck(node.left);
        boolean right = naiveCheck(node.right);

        return left && right;
    }

    // O(n)
    private static int check(Node node){
        if (node == null) return 0;
        int lh = check(node.left);
        int rh = check(node.right);

        if (Math.abs(lh-rh) > 1) return -1;

        return 1 + Math.max(lh,rh);
    }


    public static void main(String[] args) {
        boolean ans = naiveCheck(Node.BinaryTree());
        boolean ans1 = naiveCheck(Node.BalancedBinaryTree());
        System.out.println(ans);
        System.out.println(ans1);

        int ans2 = check(Node.BalancedBinaryTree());
        int ans3 = check(Node.BinaryTree());

        System.out.println(ans2 + " " + ans3);
    }
}
