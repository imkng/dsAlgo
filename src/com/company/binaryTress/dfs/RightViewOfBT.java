package com.company.binaryTress.dfs;



import com.company.binaryTress.BinaryTree;
import com.company.binaryTress.Node;

import java.util.ArrayList;
import java.util.List;

public class RightViewOfBT {
    // reverse Preorder
    // root right left
    public static List<Integer> rightViewOfBT(Node root){
        List<Integer> ans = new ArrayList<>();
        viewOfBt(root, ans, 0);
        return ans;
    }

    private static void viewOfBt(Node root, List<Integer> ans, int level) {
        if (root == null) return;

        if (ans.size() == level){
            ans.add(root.data);
        }
        viewOfBt(root.right, ans, level + 1);
        viewOfBt(root.left, ans, level + 1);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertInBT(12);
        binaryTree.insertInBT(10);
        binaryTree.insertInBT(14);
        binaryTree.insertInBT(9);
        binaryTree.insertInBT(10);

        System.out.println(rightViewOfBT(binaryTree.getRoot()));

    }
}
