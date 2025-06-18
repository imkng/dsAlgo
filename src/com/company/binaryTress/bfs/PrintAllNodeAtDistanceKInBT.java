package com.company.binaryTress.bfs;

import com.company.binaryTress.Node;

import java.util.*;

public class PrintAllNodeAtDistanceKInBT {

    public static void main(String[] args) {
        List<Node> ans = printAllNodeAtDistanceKInBT(Node.BinaryTree(), Node.BinaryTree().left, 1);
        System.out.println(ans.size());
    }

    public static List<Node> printAllNodeAtDistanceKInBT(Node root, Node target, int k) {
        Map<Node, Node> markAllParent = new HashMap<>();
        markAllParentOfEachNode(root, markAllParent);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(target);
        int curLevel = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            if (curLevel == k) break;
            curLevel++;
            for (int i = 0; i < qSize; i++) {
                Node current = queue.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if (markAllParent.get(current) != null && visited.get(markAllParent.get(current)) == null){
                    queue.offer(markAllParent.get(current));
                    visited.put(markAllParent.get(current), true);
                }
            }
        }
        List<Node> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            Node node = queue.poll();
            ans.add(node);
        }
        return ans;
    }

    private static void markAllParentOfEachNode(Node root, Map<Node, Node> markAllParent) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            if (current.left != null){
                markAllParent.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null){
                markAllParent.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
}
