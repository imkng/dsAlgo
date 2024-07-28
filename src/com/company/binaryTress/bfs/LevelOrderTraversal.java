package com.company.binaryTress.bfs;

import com.company.binaryTress.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);

        List<List<Integer>> ans= levelOrderTraveral(root);
        System.out.println(ans);
    }

    private static List<List<Integer>> levelOrderTraveral(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        if (root == null){
            return null;
        }
        List<List<Integer>> ans = new ArrayList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()){
            int levelSize = nodeQueue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (nodeQueue.peek().left != null) nodeQueue.offer(nodeQueue.peek().left);
                if (nodeQueue.peek().right != null) nodeQueue.offer(nodeQueue.peek().right);
                subList.add(nodeQueue.poll().data);
            }
            ans.add(subList);
        }
        return ans;

    }
}
