package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {
    public static void main(String[] args) {
        // left root right;
        List<Integer> inorder = inOrderWay(Node.BinaryTree());
        for (int ele :
                inorder) {
            System.out.println(ele);
        }
        System.out.println("===========================");

        List<Integer> inorder1 = inOrder(Node.BinaryTree());
        for (int ele :
                inorder1) {
            System.out.println(ele);
        }
    }

    private static List<Integer> inOrder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        Stack<Node> stack = new Stack<>();
        Node temp = root;
        while (true){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                temp = stack.pop();
                ans.add(temp.data);
                temp = temp.right;
            }

        }
        return ans;
    }
    private static List<Integer> inOrderWay(Node root){
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node current = root;
       while (!stack.isEmpty()){
           while (current != null){
               stack.push(current);
               current = current.left;
           }
           current = stack.pop();
           ans.add(current.data);
           current = current.right;
       }
        return ans;
    }
}
