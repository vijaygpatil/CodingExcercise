package com.selfPractice.Greedy;

import java.util.Arrays;

public class FindMinNumberOfPlatforms {
    public static void main(String[] args){

        //Example 1
        int arrival[] = {900, 940, 950, 1100, 1500, 1800};
        int departure[] = {910, 1200, 1120, 1130, 1900, 2000};
        int answer  = FindMinNumberOfPlatforms.findPlatform(arrival, departure);
        System.out.println("Minimum Number of Platforms Required for Plan1 = " + answer);


        System.out.println();

        // Example 2
        int arrival1[] = {200, 210, 300, 320, 350, 500};
        int departure1[] = {230, 240, 320, 430, 400, 520};
        int answer2 = FindMinNumberOfPlatforms.findPlatform(arrival1, departure1);
        System.out.println("Minimum Number of Platforms Required for Plan2 = " + answer2);

        //Example 1
        int arrival2[] = {900, 940, 950, 1100, 1500, 1800};
        int departure2[] = {910, 1200, 1120, 1130, 1900, 2000};
        int answer1  = FindMinNumberOfPlatforms.findPlatform2(arrival2, departure2);
        System.out.println("Minimum Number of Platforms Required for Plan1 = " + answer1);


        System.out.println();

        // Example 2
        int arrival12[] = {200, 210, 300, 320, 350, 500};
        int departure12[] = {230, 240, 320, 430, 400, 520};
        int answer3 = FindMinNumberOfPlatforms.findPlatform2(arrival12, departure12);
        System.out.println("Minimum Number of Platforms Required for Plan2 = " + answer3);

    }

    private static int findPlatform(int[] arrival, int[] departure) {
        int n = arrival.length;
        int result = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 1; j < n; j++) {
                if (arrival[j] >= arrival[i] && arrival[j] <= departure[i]) {
                    count++;
                }
            }
            if (result < count)
                result = count;
        }
        return result;
    }

    public static int findPlatform2(int[] arrival, int[] departure) {

        int n = arrival.length;

        //sorting both arrays
        Arrays.sort(arrival);
        Arrays.sort(departure);

        //plat_needed indicates number of platforms needed at a time
        int plat_needed = 1;
        int result = 1;
        int i = 1;
        int j = 0;

        //Similar to merge in merge sort to process all events in sorted order
        while ((i < n) && (j < n)) {
            //If next event arrives in sorted order, increment count of platforms needed
            if (arrival[i] < departure[j]) {
                plat_needed += 1;
                i += 1;
                //Update result if needed
                if (plat_needed > result) {
                    result = plat_needed;
                }
            } else {
                //Else decrement count of platforms needed
                plat_needed -= 1;
                j += 1;
            }
        }
        return result;
    }
}
