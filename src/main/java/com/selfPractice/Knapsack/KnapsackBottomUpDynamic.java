package com.selfPractice.Knapsack;

public class KnapsackBottomUpDynamic {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        // populate the capacity=0 columns, with '0' capacity we have '0' profit
        for(int i=0; i < n; i++)
            dp[i][0] = 0;

        // if we have only one weight, we will take it if it is not more than the capacity
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[0][c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for(int i=1; i < n; i++) {
            for(int c=1; c <= capacity; c++) {
                int profit1= 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if(weights[i] <= c)
                    profit1 = profits[i] + dp[i-1][c-weights[i]];
                // exclude the item
                profit2 = dp[i-1][c];
                // take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        printSelectedElements(dp, weights, profits, capacity);

        // maximum profit will be at the bottom-right corner.
        return dp[n-1][capacity];
    }

    private void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity){
        System.out.print("Selected weights:");
        int totalProfit = dp[weights.length-1][capacity];
        for(int i=weights.length-1; i > 0; i--) {
            if(totalProfit != dp[i-1][capacity]) {
                System.out.print(" " + weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }

        if(totalProfit != 0)
            System.out.print(" " + weights[0]);
        System.out.println("");
    }

    public static void main(String[] args) {
        KnapsackBottomUpDynamic ks = new KnapsackBottomUpDynamic();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    static int solveKnapsackbetter(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        // we only need one previous row to find the optimal solution, overall we need '2' rows
        // the above solution is similar to the previous solution, the only difference is that
        // we use `i%2` instead if `i` and `(i-1)%2` instead if `i-1`
        int[][] dp = new int[2][capacity+1];

        // if we have only one weight, we will take it if it is not more than the capacity
        for(int c=0; c <= capacity; c++) {
            if(weights[0] <= c)
                dp[0][c] = dp[1][c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for(int i=1; i < n; i++) {
            for(int c=0; c <= capacity; c++) {
                int profit1= 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if(weights[i] <= c)
                    profit1 = profits[i] + dp[(i-1)%2][c-weights[i]];
                // exclude the item
                profit2 = dp[(i-1)%2][c];
                // take maximum
                dp[i%2][c] = Math.max(profit1, profit2);
            }
        }

        return dp[(n-1)%2][capacity];
    }

    static int solveKnapsackbettebetter(int[] profits, int[] weights, int capacity) {
        // basic checks
        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
            return 0;

        int n = profits.length;
        int[] dp = new int[capacity + 1];

        // if we have only one weight, we will take it if it is not more than the
        // capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c)
                dp[c] = profits[0];
        }

        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int c = capacity; c >= 0; c--) {
                int profit1 = 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if (weights[i] <= c)
                    profit1 = profits[i] + dp[c - weights[i]];
                // exclude the item
                profit2 = dp[c];
                // take maximum
                dp[c] = Math.max(profit1, profit2);
            }
        }

        return dp[capacity];
    }
}
