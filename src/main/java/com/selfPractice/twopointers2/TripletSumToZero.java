package com.selfPractice.twopointers2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {
    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 2; i++) {

            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            int x = arr[i];
            int pointer1 = i + 1;
            int pointer2 = arr.length - 1;
            while(pointer1 < pointer2){
                int currentSum = arr[pointer1] + arr[pointer2];
                if(currentSum == -x) {
                    List<Integer> set = new ArrayList<>();
                    set.add(x);
                    set.add(arr[pointer1]);
                    set.add(arr[pointer2]);
                    result.add(set);
                    pointer1++;
                    pointer2--;
                } else if(currentSum > -x) {
                    pointer2--;
                } else {
                    pointer1++;
                }
            }
        }
        return result;
    }
}
