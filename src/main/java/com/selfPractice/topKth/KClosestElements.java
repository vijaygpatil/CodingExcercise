package com.selfPractice.topKth;

import java.util.*;

class Entry {
    int key;
    int value;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class KClosestElements {
    public static void main(String[] args) {
        List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        System.out.println("'K' closest numbers to 'X' are: " + result);

//        result = KClosestElements.findClosestElements2(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
//        System.out.println("'K' closest numbers to 'X' are: " + result);
//
//        result = KClosestElements.findClosestElements2(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
//        System.out.println("'K' closest numbers to 'X' are: " + result);
    }

    public static List<Integer> findClosestElements(int arr[], int K, int X) {
        List<Integer> result = new ArrayList<>();

        int index = binarySearch(arr, X);
        int low = index - K;
        int high = index + K;

        low = Math.max(low, 0);
        high = Math.min(high, arr.length - 1);

        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>((n1, n2) -> n1.key - n2.key);
        for(int i = low; i <= high; i++) {
            minHeap.add(new Entry(Math.abs(arr[i] - X), i));
        }

        for (int i = 0; i < K; i++)
            result.add(arr[minHeap.poll().value]);

        Collections.sort(result);

        return result;
    }

    public static List<Integer> findClosestElements2(int[] arr, int K, Integer X) {
        List<Integer> result = new LinkedList<>();
        int index = binarySearch(arr, X);
        int leftPointer = index;
        int rightPointer = index + 1;
        for (int i = 0; i < K; i++) {
            if (leftPointer >= 0 && rightPointer < arr.length) {
                int diff1 = Math.abs(X - arr[leftPointer]);
                int diff2 = Math.abs(X - arr[rightPointer]);
                if (diff1 <= diff2)
                    result.add(0, arr[leftPointer--]); // append in the beginning
                else
                    result.add(arr[rightPointer++]); // append at the end
            } else if (leftPointer >= 0) {
                result.add(0, arr[leftPointer--]);
            } else if (rightPointer < arr.length) {
                result.add(arr[rightPointer++]);
            }
        }
        return result;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] < target) {
                low = mid + 1;
            }
            if(arr[mid] > target) {
                high = mid - 1;
            }
        }

        if (low > 0) {
            return low - 1;
        }

        return low;
    }
}
