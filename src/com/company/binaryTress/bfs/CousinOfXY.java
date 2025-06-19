package com.company.binaryTress.bfs;

import com.company.binaryTress.Node;

import java.util.LinkedList;
import java.util.Queue;

public class CousinOfXY {
    static boolean isCousin(Node root, int x, int y){
        boolean foundX = false;
        boolean foundY = false;
        if (root == null) return false;
        Queue<Node> queue = new LinkedList<>();
        while (!queue.isEmpty()){
            Node current = queue.poll();
            if (current.left.data == x && current.right.data == y ||
                current.left.data == y && current.right.data == x
            ) return false;

            if (current.left != null){
                queue.add(current.left);
                if (current.left.data == x) foundX = true;
                if (current.left.data == y) foundY = true;
            }
            if (current.right != null){
                queue.add(current.right);
                if (current.right.data == x) foundX = true;
                if (current.right.data == y) foundY = true;
            }

            if (foundX && foundY) return true;
            if (foundX || foundY) return false;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
