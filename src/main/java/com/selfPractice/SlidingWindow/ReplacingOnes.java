package com.selfPractice.SlidingWindow;

import java.util.HashMap;

/**
 * Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.
 *
 *
 */
public class ReplacingOnes {
    public static void main(String[] args) {
        int result = 0;
        result = ReplacingOnes.findLength(2, new int[] {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1});
        System.out.println("Replacing Ones Longest Sub Array Length :"+result);

        result = ReplacingOnes.findLength(3, new int[] {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1});
        System.out.println("Replacing Ones Longest Sub Array Length :"+result);
    }

    public static int findLength(int k, int[] arr) {
        int windowStart = 0;
        int windowEnd = 0;
        int maxLenght = Integer.MIN_VALUE;
        int maxRepeat = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for(; windowEnd < arr.length; windowEnd++) {
            count.put(arr[windowEnd], count.getOrDefault(arr[windowEnd], 0) + 1);
            maxRepeat = Math.max(maxRepeat, count.get(arr[windowEnd]));


            while(windowEnd - windowStart + 1 - maxRepeat > k) {
                count.put(arr[windowStart], count.get(arr[windowStart]) - 1);
                if(count.get(arr[windowStart]) == 0) {
                    count.remove(arr[windowStart]);
                }
                windowStart++;
            }

            maxLenght = Math.max(maxLenght, windowEnd - windowStart + 1);
        }

        return maxLenght;
    }
}
