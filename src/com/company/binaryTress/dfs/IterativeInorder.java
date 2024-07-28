package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {
    public static void main(String[] args) {
        // left root right;
        List<Integer> inorder = inOrder(Node.BinaryTree());
        for (int ele :
                inorder) {
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
}
