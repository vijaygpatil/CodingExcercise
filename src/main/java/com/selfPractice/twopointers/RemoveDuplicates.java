package com.selfPractice.twopointers;

public class RemoveDuplicates {
    public static void main(String[] args){
        int result = 0;
        result = RemoveDuplicates.removeDuplicates(new int[] {2, 3, 3, 3, 6, 9, 9});
        System.out.println("The Length :"+result);

        result = RemoveDuplicates.removeDuplicates(new int[] {2, 2, 2, 11});
        System.out.println("The Length :"+result);
    }

    public static int removeDuplicates(int[] arr){
        int index = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[index - 1] != arr[i]) {
                arr[index] = arr[i];
                index++;
            }
        }

        return index;
    }
}
