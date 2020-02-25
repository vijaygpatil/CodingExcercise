package com.selfPractice.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Array = " + Arrays.toString(array));
        System.out.println("Max = " + findMaxSlidingWindow(array, 3));

        int[] array2 = {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67};
        System.out.println("Array = " + Arrays.toString(array2));
        System.out.println("Max = " + findMaxSlidingWindow(array2, 3));
    }

    public static List<Integer> findMaxSlidingWindow(int[] arr, int k) {
        int windowStart = 0;
        int windowEnd = 0;
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(; windowEnd < arr.length; windowEnd++) {
            maxHeap.add(arr[windowEnd]);
            if(windowEnd >= k - 1) {
                result.add(maxHeap.peek());
                maxHeap.remove(arr[windowStart]);
                windowStart++;
            }
        }
        return result;
    }
}
