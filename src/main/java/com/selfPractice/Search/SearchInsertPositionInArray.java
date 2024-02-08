package com.selfPractice.Search;

public class SearchInsertPositionInArray {
    public static void main(String[] args) {
        int[]arr = {0, 1, 2, 3, 5, 6};

        // Example 1
        System.out.println("Index to Insert " + "\"5\" is " + insertPosition(arr, 5));

        // Example 2
        System.out.println("Index to Insert " + "\"3\" is " + insertPosition(arr, 3));

        // Example 3
        System.out.println("Index to Insert " + "\"7\" is " + insertPosition(arr, 7));
    }

    private static int insertPosition(int[] arr, int target) {
        int arrSize = arr.length;
        
        if(arrSize < 1)
            return -1;
        
        int start = 0;
        int end = arrSize - 1;
        int mid;
        int pos = 0;
        
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(arr[mid] > target) {
                end = mid - 1;
                pos = mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
                pos = mid + 1;
            } else if(arr[mid] == target){
                return mid;
            }
        }
        return pos;
    }
}
