package com.selfPractice.SlidingWindow;

import java.util.HashMap;

public class NoRepeatSubstring {
    public static void main(String[] args) {
        int result = 0;
        result = NoRepeatSubstring.findLength("aabccbb");
        System.out.println("NoRepeatSubstring Length :"+result);
        result = NoRepeatSubstring.findLength("abbbb");
        System.out.println("NoRepeatSubstring Length :"+result);
        result = NoRepeatSubstring.findLength("abccde");
        System.out.println("NoRepeatSubstring Length :"+result);
    }

    public static int findLength(String str){
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();
        int windowStart = 0;
        int windowEnd = 0;
        int maxSize = Integer.MIN_VALUE;
        for(;windowEnd < arr.length; windowEnd++) {
            count.put(arr[windowEnd], count.getOrDefault(arr[windowEnd], 0) + 1);
            if(count.get(arr[windowEnd]) > 1) {
                count.put(arr[windowStart], count.get(arr[windowStart]) - 1);
                windowStart++;
                maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
            }
        }

        return maxSize;
    }
}
