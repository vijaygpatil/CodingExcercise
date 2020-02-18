package com.selfPractice.SlidingWindow;

import java.util.HashMap;

public class CharacterReplacement {
    public static void main(String[] args) {
        int result = 0;
        result = CharacterReplacement.findLength(2, "aabcccbb");
        System.out.println("Max Length after CharacterReplacement :"+result);
        result = CharacterReplacement.findLength(1, "abbcb");
        System.out.println("Max Length after CharacterReplacement :"+result);
        result = CharacterReplacement.findLength(1, "abccde");
        System.out.println("Max Length after CharacterReplacement :"+result);
    }

    public static int findLength(int K, String str) {
        HashMap<Character, Integer> count = new HashMap<>();
        char[] arr = str.toCharArray();
        int windowStart = 0;
        int windowEnd = 0;
        int maxSize = Integer.MIN_VALUE;
        int maxRepeat = 0;
        for(; windowEnd < arr.length; windowEnd++) {
            count.put(arr[windowEnd], count.getOrDefault(arr[windowEnd], 0) + 1);
            maxRepeat = Math.max(maxRepeat, count.get(arr[windowEnd]));
            if(count.size() == 2) {
                maxSize = Math.max(maxSize, windowEnd - windowStart + 1);
            }

            while(windowEnd - windowStart + 1 - maxRepeat > K) {
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
