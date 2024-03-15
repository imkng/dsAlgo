package com.company.BinarySearch;

public class Maximum_Count_Of_Positive_Integer_And_Negative_Integer {
    static int[] arr = new int[]{-3,-2,-1,0,0,1,2};
    public static void main(String[] args) {
        int maximumC = maximumCount(arr);
        System.out.println(maximumC);
    }

    private static int maximumCount(int[] nums) {
        int ceilOf = ceilOfZero(nums);
        int florOf = floorOfZero(nums);
        int actualPos = 0;
        if(ceilOf == -1 && florOf == -1){
            return 0;
        }
        if(ceilOf != -1){
            actualPos = nums.length - ceilOf;
        }
        int actualNeg = 0;
        if(florOf != -1){
            actualNeg = florOf + 1;
        }
        return Math.max(actualPos, actualNeg);
    }
    private static int ceilOfZero(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int ceil = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == 0){
                start =  mid + 1;
            }
            else if(arr[mid] < 0){
                start = mid + 1;
            }else if(arr[mid]>0){
                ceil = mid;
                end = mid - 1;
            }
        }
        return ceil;
    }
    private static int floorOfZero(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        int floor = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == 0){
                end = mid -1 ;
            }
            else if(arr[mid] < 0){
                floor = mid;
                start = mid + 1;
            }
            else if(arr[mid]>0){
                end = mid - 1;
            }
        }
        return floor;
    }
}
