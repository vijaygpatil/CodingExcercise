package com.selfPractice.Search;

class BinarySearch {
    static int binarySearch(int s, int arr[], int arrSize) {
        int start = 0;
        int end = arrSize - 1;
        int mid;

        while (start <= end) {
            mid = (end + start) / 2;
            if (arr[mid] < s)
                start = mid + 1;
            else if (arr[mid] > s)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    // Driver code to test the function
    public static void main(String args[]) {
        int arr[] = {-100,0,0,1,4,4,5,5,95,200};
        int arrSize = 10;
        int key = 1;
        int index = binarySearch(key, arr, arrSize);
        Helper obj = new Helper();
        obj.printArray(arr, arrSize);
        if (index != -1)
            System.out.println("Your Key \"" + key + "\" is found at index \"" + index + "\"");
        else
            System.out.println("Your Key \"" + key + "\" not found in the array: ");

    }
}