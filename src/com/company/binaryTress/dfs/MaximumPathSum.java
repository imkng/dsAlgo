package com.company.binaryTress.dfs;

import com.company.binaryTress.Node;

import java.util.Map;

public class MaximumPathSum {
    public int maxPathSum(Node root, int[] maxVal){
        if (root == null) return 0;
        int leftSum = maxPathSum(root.left, maxVal);
        int rightSum = maxPathSum(root.right, maxVal);
        maxVal[0] = Math.max(maxVal[0], leftSum + rightSum + root.data);

        return Math.max(leftSum, rightSum) + root.data;
    }
}
