package com.company.binaryTress;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Node left;
    public Node right;
    public int data;

    public Node() {
    }

    public Node(int data){
        this.data = data;
        left = right = null;
    }

    public static Node BinaryTree(){
        //   2
        //  / \
//         3    4
//        / \
//      5     6
//     / \
//    7   8

        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(8);

        return root;
    }

    public static void main(String[] args) {
        Node root = BinaryTree();
        List<Integer> path = pathFormRootToNode(root, 8);
        System.out.println(path);
        System.out.println("====================");


    }



    private static List<Integer> pathFormRootToNode(Node root, int i) {
        List<Integer> ans = new ArrayList<>();
        getPath(ans, root, i);
        return ans;
    }

    private static boolean getPath(List<Integer> ans, Node root, int i) {
        if(root == null){
            return false;
        }
        ans.add(root.data);
        if (root.data == i){
            return true;
        }
        if (getPath(ans, root.left, i) || getPath(ans, root.right, i)){
            return true;
        }
        ans.remove(ans.size() - 1);
        return false;
    }




}
