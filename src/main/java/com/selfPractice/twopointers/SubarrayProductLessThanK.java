package com.selfPractice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubarrayProductLessThanK {
    public static List<List<Integer>> findSubarrays(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int windowStart = 0;
        int windowEnd = 0;
        int pointer1 = 0;
        int pointer2 = 0;

        while(windowEnd < arr.length) {
            int product = 1;
            pointer2 = windowEnd;
            pointer1 = windowStart;
            while(pointer1 <= pointer2) {
                product *= arr[pointer1++];
            }
            if(product <= target) {

                List<Integer> set = new ArrayList<>();
                for(int i = windowStart; i <= windowEnd; i++) {
                    set.add(arr[i]);
                }
                result.add(set);
            } else {
                windowEnd = windowStart;
                windowStart++;
            }
            windowEnd++;
        }

        if(arr[arr.length-1] <= target)
            result.add(new ArrayList<>(Arrays.asList(arr[arr.length-1])));

        return result;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
