package com.selfPractice.topKth;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static void main(String[] args) {
        String result = FrequencySort.sortCharacterByFrequency("Programming");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);

        result = FrequencySort.sortCharacterByFrequency("abcbab");
        System.out.println("Here is the given string after sorting characters by frequency: " + result);
    }

    public static String sortCharacterByFrequency(String str) {

        char[] strChr = str.toCharArray();

        HashMap<Character, Integer> freq = new HashMap<>();
        for(Character c : strChr) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(freq.entrySet());

        StringBuilder sb = new StringBuilder(str.length());
        while(maxHeap.size() > 0){
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            int times = entry.getValue();
            for(int i = times; i > 0; i--) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}
