package com.company.binaryTress;

public class LowestCommonAncestor {
    private static Node lowestCommonAncestor(Node root, int a, int b) {
        if (root == null || root.data == a || root.data == b){
            return root;
        }
        Node left = lowestCommonAncestor(root.left, a, b);
        Node right = lowestCommonAncestor(root.right, a, b);

        if (left == null){
            return right;
        } else if (right == null) {
            return left;
        }else {
            return root;
        }
    }

    public static void main(String[] args) {
        Node root = Node.BinaryTree();
        Node ans = lowestCommonAncestor(root, 7, 8);
        System.out.println(ans.data);
    }



}
