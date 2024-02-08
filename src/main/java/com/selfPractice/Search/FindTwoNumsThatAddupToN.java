package com.selfPractice.Search;

import java.util.HashMap;

public class FindTwoNumsThatAddupToN {

    public static void main(String[] arg){
        int n = 9;
        int[] arr = {2,4,5,7,8};
        int[] arr2 = findSumUsingHashmap(arr, n);
        int num1 = arr2[0];
        int num2 = arr2[1];

        if ((num1 + num2) != n)
            System.out.println("Results not found!");
        else
            System.out.println("Sum of " + n + " found: " + num1 + " and " + num2);
    }

    public static int[] findSumUsingHashmap(int[] arr, int n){
        int[] result = new int[2];
        HashMap<Integer, Boolean> hmap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(hmap.containsKey(arr[i])){
                result[0] = arr[i];
                result[1] = n - arr[i];
                return  result;
            } else {
                hmap.put(n - arr[i], true);
            }
        }

        return  result;
    }

    public static int[] findSumUsingQuickSort(int[] arr, int n) {
        int[] result = new int[2];
        Helper.quickSort(arr, 0, arr.length - 1);
        int pointer1 = 0;
        int pointer2 = arr.length - 1;

        while(pointer1 != pointer2) {
            int sum = arr[pointer1] + arr[pointer2];
            if(sum < n){
                pointer1++;
            } else if (sum > n) {
                pointer2--;
            } else {
                result[0] = arr[pointer1];
                result[1] = arr[pointer2];
                return result;
            }
        }

        return result;
    }

    public static int[] findSumUsingQuickSortAndBinarySearch(int[] arr, int n) {
        int[] result = new int[2];

        Helper.quickSort(arr, 0, arr.length - 1);
        for(int i = 0; i < arr.length; i++){
            int foundIndex = Helper.binarySearch(arr, arr.length, n - arr[i]);
            if (foundIndex != -1) {
                result[0] = arr[i];
                result[1] = arr[foundIndex];
            }
        }

        return result;
    }
}
