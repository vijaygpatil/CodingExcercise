package com.selfPractice.sort;

class SelectionSort {
    static Helper obj = new Helper();

    public static void selectionSort(int[] arr, int arrSize) {
        int minInd;
        //traverse through all elements of the array
        for (int i = 0; i < arrSize; i++) {
            //find the minimum element in the unsorted array
            minInd = obj.findMin(arr, i, arrSize - 1);
            //Swap the found minimum element with the leftmost unsorted element
            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }
    }

    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        selectionSort(arr, arrSize);
        obj.printArray(arr, arrSize);
    }
}
