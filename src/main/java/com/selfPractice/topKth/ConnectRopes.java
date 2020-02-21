package com.selfPractice.topKth;

import java.util.PriorityQueue;

public class ConnectRopes {
    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }

    public static int minimumCostToConnectRopes(int[] arr) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for(Integer n : arr) {
            minHeap.add(n);
        }

        int cost = 0;
        while(minHeap.size() > 1) {
            int n1 = minHeap.poll();
            int n2 = minHeap.poll();
            cost += n1 + n2;
            minHeap.add(n1 + n2);
        }

        return cost;
    }
}
