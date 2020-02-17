package com.selfPractice.SlidingWindow;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        int result = MinSizeSubArraySum.finMinSizeSubArraySum(7, new int[] {2, 1, 5, 2, 3, 2});
        System.out.println("MinSizeSubArraySum :"+result);
        result = MinSizeSubArraySum.finMinSizeSubArraySum(7, new int[] {2, 1, 5, 2, 8});
        System.out.println("MinSizeSubArraySum :"+result);
        result = MinSizeSubArraySum.finMinSizeSubArraySum(8, new int[] {3, 4, 1, 1, 6});
        System.out.println("MinSizeSubArraySum :"+result);
    }

    public static int finMinSizeSubArraySum(int S, int[] arr) {
        int windowEnd = 0;
        int windowStart = 0;
        int windowSum = 0;
        int minSize = Integer.MAX_VALUE;
        for(;windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while(windowSum >= S) {
                minSize = Math.min(minSize, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }

        return minSize;
    }
}
