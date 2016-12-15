package com.selfPractice.array;

public class MinimumMergeForPalindrome {
	public static void main(String[] args) {
		int arr[] = {1, 4, 5, 9, 1};
		int n = arr.length;
		printMiniumMergeOperations(arr, n);
		int arr2[] = {11, 14, 15, 99};
		int n2 = arr2.length;
		printMiniumMergeOperations(arr2, n2);
	}
	
	static void printMiniumMergeOperations(int[] a, int n) {
		
		int ans = 0;
		if(n == 1) {
			System.out.println(ans);
		}
		
		int i = 0; 
		int j = n - 1;
		
		while(i <= j) {
			if(a[i] == a[j]) {
				i++;
				j--;
			} else if(a[i] > a[j]) {
				j--;
				a[j] = a[j] + a[j+1];
				ans++;
				
			} else if(a[j] > a[i]) {
				i++;
				a[i] = a[i] + a[i-1];
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
