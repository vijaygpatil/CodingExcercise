package com.selfPractice.twopointers;

public class SortedArraySquares {
    public static void main(String[] args) {
        int[] result = SortedArraySquares.makeSquares(new int[] {-2, -1, 0, 2, 3});
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { 1, 2, 3, 4, 5 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -5, -4, -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }

    public static int[] makeSquares(int[] arr){
        int[] result = new int[arr.length];

        int pointer1 = 0;
        int pointer2 = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                pointer1++;
            } else {
                break;
            }
        }

        pointer2 = pointer1 - 1;
        int j = 0;
        while(pointer1 < arr.length && pointer2 >= 0) {
            int squarpointer1 = arr[pointer1] * arr[pointer1];
            int squarepointer2 = arr[pointer2] * arr[pointer2];

            if(squarpointer1 < squarepointer2) {
                result[j++] = squarpointer1;
                pointer1++;
            } else if(squarepointer2 < squarpointer1) {
                result[j++] = squarepointer2;
                pointer2--;
            } else {
                result[j++] = squarepointer2;
                result[j++] = squarpointer1;
                pointer1++;
                pointer2--;
            }
        }

        while(pointer1 < arr.length) {
            int squarpointer1 = arr[pointer1] * arr[pointer1];
            result[j++] = squarpointer1;
            pointer1++;
        }

        while(pointer2 >= 0) {
            int squarepointer2 = arr[pointer2] * arr[pointer2];
            result[j++] = squarepointer2;
            pointer2--;
        }

        return result;
    }

    public static int[] makeSquares2(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int highestSquareIdx = n - 1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if (leftSquare > rightSquare) {
                squares[highestSquareIdx--] = leftSquare;
                left++;
            } else {
                squares[highestSquareIdx--] = rightSquare;
                right--;
            }
        }
        return squares;
    }
}
