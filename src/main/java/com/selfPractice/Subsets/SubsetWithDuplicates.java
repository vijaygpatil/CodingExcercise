package com.selfPractice.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets2(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

//        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
//        System.out.println("Here is the list of subsets: " + result);
    }

    public static List<List<Integer>> findSubsets(int[] nums) {
        // sort the numbers to handle duplicates
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            // if current and the previous elements are same, create new subsets only from the subsets
            // added in the previous step
            if (i > 0 && nums[i] == nums[i - 1])
                startIndex = endIndex + 1;
            endIndex = subsets.size() - 1;
            for (int j = startIndex; j <= endIndex; j++) {
                // create a new subset from the existing subset and add the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }

    public static List<List<Integer>> findSubsets2(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex = 0;
        int endIndex = 0;

        for(int i = 0; i < arr.length; i++) {
            startIndex = 0;
            if(i > 0 && arr[i] == arr[i - 1]) {
                startIndex = endIndex + 1;
            }
            endIndex = subsets.size() - 1;
            for(int j = startIndex; j <= endIndex; j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(arr[i]);
                subsets.add(set);
            }
        }
        return subsets;
    }
}
