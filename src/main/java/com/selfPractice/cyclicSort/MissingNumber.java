package com.selfPractice.cyclicSort;

public class MissingNumber {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(MissingNumber.findMissingNumber1(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }

    public static int findMissingNumber1(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        for (int num : nums)
            System.out.print(num + " ");
        System.out.println();

        for (i = 0; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        return nums.length;
    }

    public static int findMissingNumber(int[] nums) {
        int n = nums.length;

        int sumOfAll = n * (n + 1) /2;

        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        return sumOfAll - sum;
    }
}
