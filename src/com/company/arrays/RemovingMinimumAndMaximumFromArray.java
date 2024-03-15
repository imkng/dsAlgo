package com.company.arrays;

import java.util.Map;
import java.util.PriorityQueue;

public class RemovingMinimumAndMaximumFromArray {

    //static int[] nums = {0,1,-4,8,-2,-3,5,19};
    static int[] nums = {-1,-53,93,-42,37,94,97,82,46,42,-99,56,-76,-66,-67,-13,10,66,85,-28};

    public static void main(String[] args) {
        int minimumDeletions = minimumDeletions(nums);
        System.out.println(minimumDeletions);
    }

    private static int minimumDeletions(int[] nums) {
//        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> a[0] -b[0]);
//        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> b[0] -a[0]);

        int[] maxElement = new int[2];
        int[] minElement = new int[2];
        maxElement[0] = nums[0];
        maxElement[1] = 0;

        minElement[0] = nums[0];
        minElement[1] = 0;


        for (int i = 1; i < nums.length; i++) {
            if(maxElement[0] < nums[i]){
                maxElement[0] = nums[i];
                maxElement[1] = i;
            }
            if(minElement[0] > nums[i]){
                minElement[0] = nums[i];
                minElement[1] = i;
            }
        }
//        System.out.println(maxElement[0]);
//        System.out.println(maxElement[1]  + 1);
//        System.out.println(minElement[0]);
//        System.out.println(nums.length - minElement[1] );

        if (maxElement[1] <= nums.length/2 && minElement[1] <= nums.length/2){
            return Math.max(maxElement[1],minElement[1]) + 1;
        }else if(maxElement[1] >= nums.length/2 && minElement[1] >= nums.length/2){
            return nums.length - Math.min(maxElement[1],minElement[1]);
        }else if (maxElement[1] <= nums.length/2 && minElement[1] >= nums.length/2){
            return (maxElement[1]  + 1) + (nums.length - minElement[1] );
        }else if (maxElement[1] >= nums.length/2 && minElement[1] <= nums.length/2){
            return (minElement[1]  + 1) + (nums.length - maxElement[1] );
        }



        return 0;
    }
}
