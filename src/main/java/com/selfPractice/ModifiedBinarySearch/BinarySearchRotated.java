package com.selfPractice.ModifiedBinarySearch;

public class BinarySearchRotated {
    public static void main(String []args){
        int[] v1 = {6, 7, 1, 2, 3, 4, 5};
        System.out.println("Key(3) found at: " + binarySearchRotated(v1, 3));
        System.out.println("Key(6) found at: " + binarySearchRotated(v1, 6));

        int[] v2 = {4, 5, 6, 1, 2, 3};
        System.out.println("Key(3) found at: " + binarySearchRotated(v2, 3));
        System.out.println("Key(6) found at: " + binarySearchRotated(v2, 6));
    }

    public static int binarySearchRotated(int arr[], int k) {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while(start <= end) {
            mid = start + (end - start) / 2;

            if(arr[mid] == k) {
                return mid;
            }

            if(arr[start] <= arr[mid] && k <= arr[mid] && k >= arr[start]) {
                end = mid - 1;
            } else if(arr[end] >= arr[mid] && k >= arr[mid] && k <= arr[end]) {
                start = mid + 1;
            } else if(arr[end] <= arr[mid]){
                start = mid + 1;
            } else if(arr[start] >= arr[mid]) {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearchRotateRecursive(int[] arr, int start, int end, int key) {
        // assuming all the keys are unique.

        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == key) {
            return mid;
        }

        if (arr[start] <= arr[mid] && key <= arr[mid] && key >= arr[start]) {
            return binarySearchRotateRecursive(arr, start, mid - 1, key);
        }

        else if (arr[mid] <= arr[end] && key >= arr[mid] && key <= arr[end]) {
            return binarySearchRotateRecursive(arr, mid + 1, end, key);
        }

        else if (arr[end] <= arr[mid]) {
            return binarySearchRotateRecursive(arr, mid + 1, end, key);
        }

        else if (arr[start] >= arr[mid]) {
            return binarySearchRotateRecursive(arr, start, mid - 1, key);
        }

        return -1;
    }

    static int binarySearchRotatedRec(int[] arr, int key) {
        return binarySearchRotateRecursive(arr, 0, arr.length - 1, key);
    }
}
