package com.selfPractice.cyclicSort;

public class FindDuplicate {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4, 6, 7, 8, 9 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 1, 1, 1, 3, 2, 5, 4, 6, 7, 8, 9 }));
        System.out.println(FindDuplicate.findNumber(new int[] { 1, 3, 3, 3, 2, 5, 4, 6, 7, 8, 9 }));
    }

    public static int findNumber(int[] arr){
        int i = 0;
        while(i < arr.length) {
            if(arr[i] != arr[arr[i] - 1]) {
                swap(arr, i, arr[i] - 1);
            } else {
                i++;
            }
        }

        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        return arr[arr.length - 1];
    }
}
