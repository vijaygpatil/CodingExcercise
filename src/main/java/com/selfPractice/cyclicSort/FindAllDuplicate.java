package com.selfPractice.cyclicSort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicate {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        List<Integer> duplicates = FindAllDuplicate.findNumbers(new int[] { 3, 4, 4, 5, 5 });
        System.out.println("Duplicates are: " + duplicates);

        duplicates = FindAllDuplicate.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
        System.out.println("Duplicates are: " + duplicates);
    }

    public static List<Integer> findNumbers(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if(arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }

        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        List<Integer> duplicateNumbers = new ArrayList<>();
        for (i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1)
                duplicateNumbers.add(arr[i]);
        }

        return duplicateNumbers;
    }
}
