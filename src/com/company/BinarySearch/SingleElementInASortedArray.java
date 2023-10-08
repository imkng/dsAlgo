package com.company.BinarySearch;

public class SingleElementInASortedArray {
//    static int[] arr = new int[]{1,1,2};

//    You are given a sorted array consisting of only integers
//    where every element appears exactly twice, except for one element
//    which appears exactly once.
//
//    Return the single element that appears only once.
//
//    Your solution must run in O(log n) time and O(1) space.
//            Example 1:
//
//    Input: nums = [1,1,2,3,3,4,4,8,8]
//    Output: 2
    static int[] arr = new int[]{3,3,7,7,10,11,11};
    public static void main(String[] args) {
        int singleElement = singleNonDuplicate(arr);
        System.out.println(singleElement);
    }

    private static int singleNonDuplicate(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }
        int start = 0;
        int end = arr.length - 1;
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(((mid - 1) >= 0 && (mid + 1) <= arr.length -1 && arr[mid] != arr[mid-1] && arr[mid] != arr[mid + 1])
                    || mid == arr.length-1 && arr[mid-1] != arr[mid]
            || mid == 0 && arr[mid + 1] != arr[mid]){
                ans =  arr[mid];
                break;
            }
            if((mid - 1) >= 0 && arr[mid] == arr[mid - 1]){
                if(mid%2 == 0){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else if((mid + 1) <= arr.length -1 && arr[mid] == arr[mid + 1]){
                if(mid%2 == 0){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return ans;
    }
}
