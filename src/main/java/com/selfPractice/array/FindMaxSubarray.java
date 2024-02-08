package com.selfPractice.array;

import java.util.Arrays;

public class FindMaxSubarray {
    public static int findMaxSumSubArray(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }

        int currMax = arr[0];
        int globalMax = arr[0];
        int lengtharray = arr.length;
        for (int i = 1; i < lengtharray; i++) {
            if (currMax < 0) {
                currMax = arr[i];
            } else {
                currMax += arr[i];
            }

            if (globalMax < currMax) {
                globalMax = currMax;
            }
        }
        return globalMax;
    }

    public static void main(String arg[]) {
        int[] arr = {1, 7, -2, -5, 10, -1};
        System.out.println("Array: "+ Arrays.toString(arr));
        System.out.println("Sum: "+findMaxSumSubArray(arr));
    }
}
