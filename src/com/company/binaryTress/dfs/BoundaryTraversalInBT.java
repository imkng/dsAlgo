package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversalInBT {
    private static List<Integer> boundaryTraversal(Node root){
        List<Integer> ans = new ArrayList<>();
        if (!isLeaf(root)) {
            ans.add(root.data);
           }
        //traverse left
        traverseLeft(root, ans);
        //traverseLeaf -> inorder
        traverseLeaf(root, ans);
        // traverseRight
        traverseRight(root, ans);


        return ans;
    }

    private static void traverseRight(Node root, List<Integer> ans) {
        List<Node> rightNode = new ArrayList<>();
        Node current = root.right;
        while (current != null){
            if (!isLeaf(current)) rightNode.add(current);
            if (current.right != null) current = current.right;
            else current = current.left;
        }
        for (int i = rightNode.size() - 1; i >=0; i--){
            ans.add(rightNode.get(i).data);
        }
    }

    private static void traverseLeaf(Node root, List<Integer> ans) {
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        };
        if (root.left != null) traverseLeaf(root.left, ans);
        if (root.right != null) traverseLeaf(root.right, ans);

    }

    private static void traverseLeft(Node root, List<Integer> ans) {
        Node current = root.left;

        while (current != null){
            if (!isLeaf(current)) ans.add(current.data);
            if (current.left != null) current = current.left;
            else current= current.right;
        }
    }



    private static boolean isLeaf(Node current) {
        return current.left == null && current.right == null;
    }

    public static void main(String[] args) {
        System.out.println(boundaryTraversal(Node.BinaryTree()));
    }
}
