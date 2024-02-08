package com.selfPractice.Search;

import java.util.Arrays;

public class DutchFlag {

    public static void main(String args[])
    {
        int[] arr = {2, 0, 0, 1, 2, 1};
        dutchNationalFlag(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void dutchNationalFlag(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int mid = 0;

        while(mid <= j) {
            if(arr[mid] == 0) {
                swap(arr, i++, mid++);
            } else if(arr[mid] == 2) {
                swap(arr, mid, j--);
            } else if(arr[mid] == 1) {
                mid++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
