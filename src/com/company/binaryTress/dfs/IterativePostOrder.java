package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {



    public static void main(String[] args) {
        // left right root
        List<Integer> inorder = postOrderWay(Node.BinaryTree());
        System.out.println(inorder);
    }

    private static List<Integer> postOrderWay(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node temp = stack.pop();
            ans.add(temp.data);
            stack.push(temp.left);
            stack.push(temp.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}
