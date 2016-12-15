package com.selfPractice.array;

public class MaximizeNumberOfZerosByFlippingSubarray {
	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 0, 1, 1, 0};
	    int n = arr.length;
	    System.out.println(findMaxZeroCount(arr, n));
	    System.out.println(findMaxZeroCountInNTime(arr, n));
	}
	
	static int findMaxZeroCount(int[] a, int n) {
		
		int ori_count_zeros = 0;
		int max_diff = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(a[i] == 0) {
				ori_count_zeros++;
			}
			
			int count0 = 0;
			int count1 = 0;
			
			for(int j = i; j < n; j++) {
				if(a[j] == 0) {
					count0++;
				} else {
					count1++;
				}
				max_diff = Math.max(max_diff, count1 - count0);
			}
		}
		return max_diff + ori_count_zeros;
	}
	
	static int findMaxZeroCountInNTime(int[]a, int n) {
		
		int max_diff = 0; 
		int ori_count_zeros = 0;
		int cur_max = 0;
		
		for(int i = 0; i < n; i++) {
			if(a[i] == 0) {
				ori_count_zeros++;
			}
			
			int val = a[i] == 1 ? 1 : -1;
			
			cur_max = Math.max(val, cur_max + 1);
			max_diff = Math.max(max_diff, cur_max);
		}
		max_diff = Math.max(0, max_diff);
		return ori_count_zeros + max_diff;
	}
}
