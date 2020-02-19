package com.selfPractice.twopointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    public static void main(String[] args) {
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(TripletSumCloseToTarget.searchTriplet(new int[] { 1, 0, 1, 1 }, 100));
    }

    public static int searchTriplet(int[] arr, int targetSum) {
        if(arr == null || arr.length < 2) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 2; i++) {
            int pointer1 = i + 1;
            int pointer2 = arr.length - 1;
            int x = arr[i];
            while(pointer1 < pointer2) {
                int currentSum = arr[pointer1] + arr[pointer2];
                int targetDiff = targetSum - currentSum - x;
                if(targetDiff == 0)
                    return targetSum;

                if (Math.abs(targetDiff) < Math.abs(smallestDifference) || (Math.abs(targetDiff) == Math.abs(smallestDifference) && targetDiff > smallestDifference))
                    smallestDifference = targetDiff;

                if(currentSum + x > targetSum) {
                    pointer2--;
                } else {
                    pointer1++;
                }
            }
        }


        return targetSum - smallestDifference;
    }
}
