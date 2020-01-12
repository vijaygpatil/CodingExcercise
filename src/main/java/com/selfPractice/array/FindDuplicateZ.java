 package com.selfPractice.array;

public class FindDuplicateZ {
	void printRepeating(int arr[], int size) {
		int i;
		System.out.println("The repeating elements are : ");

		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] >= 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + " ");
		}
	}
	
	void printRepeating2(int arr[], int size) 
    {
        int count[] = new int[size];
        int i;
 
        System.out.println("Repeated elements are : ");
        for (i = 0; i < size; i++) 
        {
            if (count[arr[i]] == 1)
                System.out.print(arr[i] + " ");
            else
                count[arr[i]]++;
        }
    }

	/* Driver program to test the above function */
	public static void main(String[] args) {
		FindDuplicateZ duplicate = new FindDuplicateZ();
		int arr[] = { 14, 2, 4, 5, 2, 3, 1 };
		int arr_size = arr.length;
		duplicate.printRepeating(arr, arr_size);
	}
}
