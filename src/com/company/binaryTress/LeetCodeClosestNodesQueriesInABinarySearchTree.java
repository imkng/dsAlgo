package com.company.binaryTress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCodeClosestNodesQueriesInABinarySearchTree {
//    You are given the root of a binary search tree and an array queries of size n consisting of positive integers.
//
//    Find a 2D array answer of size n where answer[i] = [mini, maxi]:
//
//    mini is the largest value in the tree that is smaller than or equal to queries[i].
//    If a such value does not exist, add -1 instead.
//    maxi is the smallest value in the tree that is greater than or equal to queries[i].
//    If a such value does not exist, add -1 instead.
//    Return the array answer.

//    Input: root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
//    Output: [[2,2],[4,6],[15,-1]]

    static List<Integer> temp = new ArrayList<>();

    public static void main(String[] args) {
//        Node root = new Node(6);
//        root.left = new Node(2);
//        root.left.left = new Node(1);
//        root.left.right = new Node(4);
//
//        root.right = new Node(13);
//        root.right.left = new Node(9);
//        root.right.right = new Node(15);
//        root.right.right.left = new Node(14);

        Node root = new Node(4);
        root.right = new Node(9);

//        List<Integer> queries = Arrays.asList(2,5,16);
        List<Integer> queries = Arrays.asList(3);
        List<List<Integer>> ans =  closestNodes(root, queries);
        List<List<Integer>> ans1 =  closestNodes1(root, queries);
        System.out.println(ans1);
    }

    private static List<List<Integer>> closestNodes1(Node root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        inorderTraversal(root);
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> temp1 = new ArrayList<>();
            temp1.add(floorElementInArray(temp, queries.get(i)));
            temp1.add(ceilElementInArray(temp, queries.get(i)));
            ans.add(temp1);
        }

        return ans;
    }

    private static Integer floorElementInArray(List<Integer> temp, Integer target) {
        int start = 0;
        int end = temp.size() - 1;
        int ans = -1;

        while (start <= end){
            int mid = start + (end - start)/2;
            if (temp.get(mid) == target){
                return temp.get(mid);
            }
            if (temp.get(mid) < target){
                ans = temp.get(mid);
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }

    private static Integer ceilElementInArray(List<Integer> temp, Integer input) {
        int start = 0;
        int end = temp.size() - 1;
        int ans = -1;

        while (start <= end){
            int mid = start + (end - start)/2;
            if (temp.get(mid) == input){
                return temp.get(mid);
            }
            if (temp.get(mid) < input){
                start = mid + 1;
            }else if (temp.get(mid) > input) {
                ans = temp.get(mid);
                end = mid - 1;
            }
        }
        return ans;
    }



    private static void inorderTraversal(Node root) {
        if (root == null){
            return;
        }
        inorderTraversal(root.left);
        temp.add(root.data);
        inorderTraversal(root.right);
    }

    private static List<List<Integer>> closestNodes(Node root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(findFloor(root, queries.get(i)));
            temp.add(findCeil(root, queries.get(i)));
            ans.add(temp);
        }
        return ans;
    }

    static int findCeil(Node root, int input){
        int ceil = -1;
        Node temp = root;
        while (temp != null){
            if (temp.data == input){
                return temp.data;
            }
            if (input < temp.data){
                ceil = temp.data;
                temp = temp.left;
            }else{
                temp = temp.right;
            }
        }
        return ceil;
    }

    static int findFloor(Node root, int input){
        int floor = -1;
        Node temp = root;

        while (temp != null){
            if (temp.data == input){
                return temp.data;
            }
            if (temp.data < input){
                floor = temp.data;
                temp = temp.right;
            }else {
                temp = temp.left;
            }
        }
        return floor;
    }
}
