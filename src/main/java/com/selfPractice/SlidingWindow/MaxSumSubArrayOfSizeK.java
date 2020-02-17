package com.selfPractice.SlidingWindow;

public class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int maxSum = Integer.MIN_VALUE;
        for(; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if(windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int result = MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] {2,3,4,1,5});
        System.out.println("Max Sum :"+result);
        result = MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2});
        System.out.println("Max Sum: "+result);
    }
}
