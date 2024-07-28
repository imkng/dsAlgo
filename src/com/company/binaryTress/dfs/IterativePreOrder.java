package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrder {
    public static void main(String[] args) {
        // root left right
        List<Integer> ans = preOrder(Node.BinaryTree());
        for (Integer an : ans) {
            System.out.println(an);
        }
    }

    private static List<Integer> preOrder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            ans.add(temp.data);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return ans;
    }
}
