package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    Node node;
    int num;

    public Pair(Node node, int num) {
        this.node = node;
        this.num = num;
    }
}
public class AllTraversalInOne {
    List<Integer> preOrder;
    List<Integer> inOrder;
    List<Integer> postOrder;

    public void allInOne(Node root) {
        this.preOrder = new ArrayList<>();
        this.inOrder = new ArrayList<>();
        this.postOrder = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()){
            Pair it = stack.pop();
            if (it.num == 1){
                preOrder.add(it.node.data);
                it.num++;
                stack.push(it);
                if(it.node.left != null){
                    stack.push(new Pair(it.node.left, 1));
                }
            }
            else if (it.num == 2){
                inOrder.add(it.node.data);
                it.num++;
                stack.push(it);
                if(it.node.right != null){
                    stack.push(new Pair(it.node.right, 1));
                }
            }
            else {
                postOrder.add(it.node.data);
            }
        }
    }


    public static void main(String[] args) {
        AllTraversalInOne allTraversalInOne = new AllTraversalInOne();
        allTraversalInOne.allInOne(Node.BinaryTree());
        System.out.println(allTraversalInOne.inOrder);
        System.out.println(allTraversalInOne.postOrder);
        System.out.println(allTraversalInOne.preOrder);
    }
}
