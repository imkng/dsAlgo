package com.company.binaryTress;

public class FloorInBST {

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int floorValue = floorInBST(root, 13);
        System.out.println(floorValue);
    }

    private static int floorInBST(Node root, int input) {
        int floor = -1;
        while (root != null){
            if (root.data == input) return root.data;

            if (root.data < input){
                floor = root.data;
                root = root.right;
            }else {
                root = root.left;
            }
        }
        return floor;
    }
}
