package com.selfPractice.topKth;

import java.util.PriorityQueue;

public class KthLargestNumberInStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
    int k;

    public static void main(String[] args) {
        int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
        KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
        System.out.println("4th largest number is: " + kthLargestNumber.add(6));
        System.out.println("4th largest number is: " + kthLargestNumber.add(13));
        System.out.println("4th largest number is: " + kthLargestNumber.add(4));
    }

    public KthLargestNumberInStream(int[] arr, int k) {
        this.k = k;
        for(int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    public int add(int num) {
        minHeap.add(num);

        if(minHeap.size() > this.k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
