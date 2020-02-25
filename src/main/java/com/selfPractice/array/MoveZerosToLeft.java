package com.selfPractice.array;

import java.util.Arrays;

public class MoveZerosToLeft {
    public static void main(String[] args) {
        int[] v = new int[]{1, 10, 20, 0, 59, 63, 0, 88, 0};
        System.out.println("Original Array: " + Arrays.toString(v));

        moveZerosToLeft(v);

        System.out.println("After Moving Zeroes to Left: " + Arrays.toString(v));
    }

    public static void moveZerosToLeft(int[] arr) {
        int read = arr.length - 1;
        int write = arr.length - 1;

        while(read >= 0) {
            if(arr[read] > 0) {
                arr[write] = arr[read];
                read--;
                write--;
            } else {
                read--;
            }
        }

        while(write >= 0) {
            arr[write] = 0;
            write--;
        }
    }
}
