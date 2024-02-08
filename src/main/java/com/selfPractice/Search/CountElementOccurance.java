package com.selfPractice.Search;

public class CountElementOccurance {
    public static void main(String[] args) {
        int arr[] = {-5, -3, 0, 1, 3, 3, 3, 3, 4, 5};
        int key = 3;
        System.out.println("The key \""+ key + "\" occurs " + calcFreq(arr, key) + " times in the Array.");
//        System.out.println("The key \""+ key + "\" occurs " + calcFreq2(arr, key) + " times in the Array.");
    }

    private static int calcFreq(int[] arr, int key) {
        int arrSize = arr.length;
        int index = binarySearch(key, arr, arrSize);

        if(index == -1)
            return 0;

        int count = 1;

        int start = index - 1;
        while(start >= 0 && arr[start] == key) {
            count++;
            start--;
        }

        int end = index + 1;
        while(end < arrSize && arr[end] == key) {
            count++;
            end++;
        }

        return count;
    }

    private static int binarySearch(int s, int arr[], int arrSize) {
        if(arrSize <= 0)
            return -1;

        if(arrSize == 1){
            if(arr[0] == s) {
                return 0;
            } else {
                return -1;
            }
        }

        int start = 0;
        int end = arrSize - 1;
        int mid;

        while(start <= end) {
            mid = (start + end)/2;
            if(arr[mid] < s) {
                start = mid + 1;
            } else if(arr[mid] > s) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int calcFreq2(int arr[], int key) {
        int arrSize = arr.length;
        int start = 0;
        int end = arrSize - 1;
        int mid;
        int result = -1;

        while(start <= end) {
            mid = (start + end) / 2;
            if(arr[mid] == key) {
                result = mid;
                end = mid - 1;
            } else if(arr[mid] > key) {
                end = mid - 1;
            } else if(arr[mid] < key) {
                start = mid + 1;
            }
        }

        int start1 = 0;
        int end1 = arrSize - 1;
        int mid1;
        int result1 = -1;
        while(start1 <= end1) {
            mid1 = (start1 + end1)/2;
            if(arr[mid1] == key) {
                result1 = mid1;
                end1 = mid1 - 1;
            } else if(arr[mid1] > key) {
                end1 = mid1 - 1;
            } else if(arr[mid1] > key) {
                start1 = mid1 + 1;
            }
        }

        if(result == -1 || result1 == -1)
            return result1 - result;

        return result1 - result + 1;
    }
}