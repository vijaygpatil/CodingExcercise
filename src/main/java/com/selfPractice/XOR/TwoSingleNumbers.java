package com.selfPractice.XOR;

public class TwoSingleNumbers {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 4, 2, 1, 3, 5, 6, 2, 3, 5 };
        int[] result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);

        arr = new int[] { 2, 1, 3, 2 };
        result = TwoSingleNumbers.findSingleNumbers(arr);
        System.out.println("Single numbers are: " + result[0] + ", " + result[1]);
    }

    public static int[] findSingleNumbers(int[] nums) {
        int n1xn2 = 0;
        for(int num : nums) {
            n1xn2 ^= num;
        }

        int rightMostBit = 1;
        while((n1xn2 & rightMostBit) == 0) {
            rightMostBit = rightMostBit << 1;
        }

        int n1 = 0;
        int n2 = 0;

        for(int num : nums) {
            if((num & rightMostBit) != 0) {
                n1 ^= num;
            } else {
                n2 ^= num;
            }
        }

        return new int[] {n1, n2};
    }
}
