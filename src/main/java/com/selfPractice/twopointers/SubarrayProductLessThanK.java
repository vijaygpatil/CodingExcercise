package com.selfPractice.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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

    public static List<List<Integer>> findSubarrays1(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int product = 1, left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            while (product >= target && left < arr.length)
                product /= arr[left++];
            // since the product of all numbers from left to right is less than the target therefore,
            // all subarrays from lef to right will have a product less than the target too; to avoid
            // duplicates, we will start with a subarray containing only arr[right] and then extend it
            List<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays1(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays(new int[] { 8, 2, 6, 5 }, 50));
    }
}
