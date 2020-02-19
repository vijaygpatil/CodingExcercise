package com.selfPractice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSum2 {
    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum2.searchTriplets1(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(TripletWithSmallerSum2.searchTriplets1(new int[] { -1, 4, 2, 1, 3 }, 5));
    }

    public static List<List<Integer>> searchTriplets1(int[] arr, int target) {
        if(arr == null || arr.length < 2) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(arr);

        List<List<Integer>> triplet = new ArrayList<>();
        for(int i = 0; i < arr.length - 2; i++) {
            int x = arr[i];
            int pointer1 = i + 1;
            int pointer2 = arr.length - 1;
            while(pointer1 < pointer2) {
                int currentSum = arr[pointer2] + arr[pointer1];
                if(currentSum + x < target) {
                    for(int j = pointer2; j > pointer1; j--) {
                        triplet.add(Arrays.asList(arr[i], arr[pointer1], arr[j]));
                    }
                    pointer1++;
                } else {
                    pointer2--;
                }
            }
        }

        return triplet;
    }
}
