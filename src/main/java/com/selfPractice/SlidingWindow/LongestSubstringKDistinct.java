package com.selfPractice.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        int result = 0;
        result = LongestSubstringKDistinct.findLength(2, "araaci");
        System.out.println("LongestSubstringKDistinct :"+result);
        result = LongestSubstringKDistinct.findLength(1, "araaci");
        System.out.println("LongestSubstringKDistinct :"+result);
        result = LongestSubstringKDistinct.findLength(3, "cbbebi");
        System.out.println("LongestSubstringKDistinct :"+result);
    }

    public static int findLength(int K, String str) {
        if(str == null || str.length() == 0 || str.length() < K) {
            throw new IllegalArgumentException();
        }

        char[] arr = str.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();
        int windowStart = 0;
        int windowEnd = 0;
        int maxSize = Integer.MIN_VALUE;
        for(; windowEnd < arr.length; windowEnd++) {
            count.put(arr[windowEnd], count.getOrDefault(arr[windowEnd], 0) + 1);
            if(count.size() == K) {
                maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
            }

            while(count.size() > K) {
                count.put(arr[windowStart], count.get(arr[windowStart]) - 1);
                if(count.get(arr[windowStart]) == 0) {
                    count.remove(arr[windowStart]);
                }
                windowStart++;
            }
        }

        return maxSize;
    }
}
