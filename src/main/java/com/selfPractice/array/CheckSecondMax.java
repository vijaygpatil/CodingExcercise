package com.selfPractice.array;

public class CheckSecondMax {
    public static void main(String[] arg) {
        int[] arr = {-2, -33, -10, -456};

        System.out.println("Array: "+arrayToString(arr));

        int secMax = findSecondMaximum(arr);

        System.out.println("Second Maximum: "+secMax);
    }

    public static String arrayToString(int arr[]){
        if (arr.length > 0){
            String result = "";
            for(int i = 0; i < arr.length; i++) {
                result += arr[i] + " ";
            }
            return result;
        }
        else {
            return "Empty Array!";
        }
    }

    public static int findSecondMaximum(int arr[]) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if(arr[i] > secondMax && arr[i] < max) {
                secondMax = arr[i];
            }
        }

        return secondMax;
    }
}
