package com.selfPractice.Greedy;

public class ConnectNPipesWithMinimumCost {
    public static void main(String[] args){
        int pipes[] = { 4, 3, 2, 6 };
        int n = pipes.length;

        System.out.println("Total cost for connecting pipes is " + ConnectNPipesWithMinimumCost.minCost(pipes, n));

        int[] pipes1 = {1, 1, 2, 6};
        n = pipes1.length;
        System.out.println("Total cost for connecting pipes1 is " + ConnectNPipesWithMinimumCost.minCost(pipes1,n));
    }

    private static int minCost(int[] pipes, int n) {
        int cost = 0;
        int minimum, secondMinimum;
        MinHeap minHeap = new MinHeap(pipes, n);
        while(!minHeap.SizeIsOne()) {
            minimum = minHeap.extractMin();
            secondMinimum = minHeap.extractMin();

            cost += (minimum + secondMinimum);

            minHeap.insertKey(minimum + secondMinimum);
        }
        return cost;
    }
}
