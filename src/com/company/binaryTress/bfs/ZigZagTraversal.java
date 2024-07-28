package com.company.binaryTress.bfs;

import com.company.binaryTress.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    //Given the root of a binary tree, return the zigzag level order traversal of its nodes'
    //values. (i.e., from left to right, then right to left for the next level
    //and alternate between).
    public static void main(String[] args) {
        List<List<Integer>> ans = zigZagTraversal(Node.BinaryTree());
        System.out.println(ans);
    }

    private static List<List<Integer>> zigZagTraversal(Node node) {
        List<List<Integer>> ans = new ArrayList<>();
        if (ans == null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        Boolean even = true;

        while (!queue.isEmpty()){
            int qSize = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < qSize; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                if(even){
                    list.addLast(queue.poll().data);
                }else {
                    list.addFirst(queue.poll().data);
                }
            }
            ans.add(list);
            even = !even;
        }
        return ans;
    }
}
