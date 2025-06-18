package com.company.binaryTress.bfs;

import com.company.binaryTress.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinimumTimeTakenToBurnBT {
    private static int minimumTimeTakenToBurnBT(Node root, Node target){
        Map<Node, Node> parentMap = new HashMap<>();
        markAllParentOfEachNode(root, parentMap);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(target);
        Map<Node, Integer> visited = new HashMap<>();
        int minTimeTOBurnTree = 0;
        while (!queue.isEmpty()){
            int qSize = queue.size();
            int flag = 0;
            for (int i = 0; i < qSize; i++){
                Node current = queue.poll();
                if (current.left != null && visited.get(current.left)== null){
                    flag = 1;
                    visited.put(current.left, 1);
                    queue.offer(current.left);
                }
                if (current.right != null && visited.get(current.right)== null){
                    flag = 1;
                    visited.put(current.right, 1);
                    queue.offer(current.right);
                }
                if (parentMap.get(current) != null && visited.get(parentMap.get(current))== null){
                    flag = 1;
                    queue.offer(parentMap.get(current));
                    visited.put(parentMap.get(current), 1);
                }
                if (flag == 1) minTimeTOBurnTree++;
            }
        }
        return minTimeTOBurnTree;
    }

    private static void markAllParentOfEachNode(Node root, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            if (current.left != null){
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null){
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        int ans = minimumTimeTakenToBurnBT(Node.BinaryTree(), Node.BinaryTree().left);
        System.out.println(ans);
    }
}
