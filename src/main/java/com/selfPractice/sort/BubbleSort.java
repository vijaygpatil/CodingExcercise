package com.selfPractice.sort;

class BubbleSort {
    static Helper obj = new Helper();
    static void bubbleSort(int arr[], int arrSize) {
        int i, j, temp;
        //Traverse through all array elements
        for (i = 0; i < arrSize - 1; i++)
            // Last i elements are already in place
            for (j = 0; j < arrSize - i - 1; j++)
                //Traverse the array from 0 to size of array[i-1]
                //Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        bubbleSort(arr, arrSize);
        obj.printArray(arr, arrSize);
    }
}
