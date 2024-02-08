package com.selfPractice.Search;

public class SearchMatrix {

    public static void main(String[] args){

        int[][] matrix = {
                {10, 11, 12, 13},
                {14, 15, 16, 17},
                {27, 29, 30, 31},
                {32, 33, 39, 50}
        };

        System.out.println("Search for 80 returned: "+findKey(matrix, 4, 4, 80));
        System.out.println("Search for 80 returned: "+findKey(matrix, 4, 4, 15));
    }

    private static Boolean findKey(int[][] matrix, int numberOfRows, int numberOfColumns, int target) {
        int min = 0;
        int max = numberOfRows * numberOfColumns - 1;

        while(min <= max) {
            int middle = (min + max)/2;
            int row = middle/numberOfColumns;
            int col = middle%numberOfColumns;
            if(target < matrix[row][col]) {
                max = middle - 1;
            } else if(target > matrix[row][col]){
                min = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
