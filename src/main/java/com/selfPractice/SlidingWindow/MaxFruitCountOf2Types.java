package com.selfPractice.SlidingWindow;

import java.util.HashMap;

public class MaxFruitCountOf2Types {
    public static void main(String[] args) {
        int result = 0;
        result = MaxFruitCountOf2Types.findLength(2, new char[] {'A', 'B', 'C', 'A', 'C'});
        System.out.println("MaxFruitCountOf2Types :"+result);
        result = MaxFruitCountOf2Types.findLength(2, new char[] {'A', 'B', 'C', 'B', 'B', 'C'});
        System.out.println("MaxFruitCountOf2Types :"+result);
    }

    public static int findLength(int K, char[] arr) {
        HashMap<Character, Integer> count = new HashMap<>();
        int windowStart = 0;
        int windowEnd = 0;
        int maxSize = Integer.MIN_VALUE;
        for(;windowEnd < arr.length; windowEnd++){
            count.put(arr[windowEnd], count.getOrDefault(arr[windowEnd], 0) + 1);
            if(count.size() == K) {
                maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
            }

            while(count.size() > K) {
                count.put(arr[windowStart], count.get(arr[windowStart]) - 1);
                if(count.get(arr[windowStart]) == 0) {
                    count.remove(arr[windowStart]);
                    windowStart++;
                }
            }
        }

        return maxSize;
    }
}
