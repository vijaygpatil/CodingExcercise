package com.selfPractice.array;

public class SortedArrayRotatedFindElement {
	public static int findElement(int[] a, int n, int e) {
		
		int l = 0;
		int r = n-1;
		
		while(l <= r) {
			int m = l + ((r - l)/2);
			if(a[m] == e) {
				return e;
			}
		
			if(a[l] <= a[m]) {
				if(e < a[m] && e >= a[l]) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			} else {
				if(a[m] < e && e <= a[r]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int a[] = {9, 10, 11, 1, 2, 5, 6};
		int e = 10;
		int n = a.length;
		System.out.println(findElement(a, n, e));
	}
}
