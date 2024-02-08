package com.selfPractice.twopointers;

import java.util.*;

class SortThreeColors {
    public static int[] sortColors(int[] colors) {

        int red = 0;
        int white = 0;
        int blue = colors.length - 1;

        while (white <= blue) {

            if (colors[white] == 0) {

                if (colors[red] != 0) {
                    int temp = colors[red];
                    colors[red] = colors[white];
                    colors[white] = temp;
                }

                white++;
                red++;
            }

            else if (colors[white] == 1) {
                white++;
            }

            else {
                if (colors[blue] != 2) {
                    int temp = colors[white];
                    colors[white] = colors[blue];
                    colors[blue] = temp;
                }

                blue--;
            }
        }

        return colors;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
            {0, 1, 0},
            {1, 1, 0, 2},
            {2, 1, 1, 0, 0},
            {2, 2, 2, 0, 1, 0},
            {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
//            System.out.println((i + 1) + ".\tcolors: " + Print.arrayToString(inputs[i]));

            int[] sortedColors = sortColors(inputs[i].clone());
//            System.out.println("\n\tThe sorted array is: " + Print.arrayToString(sortedColors));

//            System.out.println(Print.repeat("-", 100));
        }
    }
}