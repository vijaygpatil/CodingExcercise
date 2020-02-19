package com.selfPractice.twopointers;

import java.util.Arrays;

public class TripletWithSmallerSum {

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }

    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0; i < arr.length - 2; i++) {
            int pointer1 = i + 1;
            int pointer2 = arr.length - 1;
            int x = arr[i];
            while(pointer1 < pointer2) {
                int currentSum = arr[pointer1] + arr[pointer2];
                if(currentSum + x < target) {
                    count += pointer2 - pointer1;
                    pointer1++;
                } else {
                    pointer2--;
                }
            }
        }
        return count;
    }

}
