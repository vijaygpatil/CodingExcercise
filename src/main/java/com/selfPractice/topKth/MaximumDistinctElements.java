package com.selfPractice.topKth;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctElements {

    public static void main(String[] args) {
        int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);

        result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
        System.out.println("Maximum distinct numbers after removing K numbers: " + result);
    }

    public static int findMaximumDistinctElements(int[] arr, int K) {
        int distinctElements = 0;
        if (arr.length <= K)
            return distinctElements;

        HashMap<Integer, Integer> freq = new HashMap<>();
        for(Integer n : arr) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((n1, n2) -> (n1.getValue() - n2.getValue()));
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                distinctElements++;
            } else {
                minHeap.add(entry);
            }
        }

        while(K > 0 && !minHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            K -= entry.getValue() - 1;
            if(K >= 0) {
                distinctElements++;
            }
        }

        if(K > 0) {
            distinctElements -= K;
        }

        return distinctElements;
    }
}
