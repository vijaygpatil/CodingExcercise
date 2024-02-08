package com.selfPractice.array;

public class ReArrangeArrayNegativePositive {
    public static void main(String[] arg){
        int[] arr = {2, 4, -6, 8, -5, -10};

        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+ " ");

        reArrange(arr);

        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+ " ");
    }

    public static void reArrange(int[] arr){
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                if(i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }
}
