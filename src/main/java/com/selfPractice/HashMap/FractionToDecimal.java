package com.selfPractice.HashMap;

import java.util.*;

class FractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        String result = "";
        HashMap<Integer, Integer> remainderMap = new HashMap<Integer, Integer>();
        if (numerator == 0) {
            return "0";
        }

        if (numerator < 0 ^ denominator < 0) {
            result += '-';
        }

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        int quotient = numerator / denominator;
        int remainder = (numerator % denominator) * 10;
        result += Integer.toString(quotient);

        if (remainder == 0)
            return result;
        else {
            result += ".";
            while (remainder != 0) {
                if (remainderMap.containsKey(remainder)) {
                    int beginning = remainderMap.get(remainder);
                    String left = result.substring(0, beginning);
                    String right = result.substring(beginning, result.length());
                    result = left + "(" + right + ")";
                    return result;
                } else {
                    remainderMap.put(remainder, result.length());
                    quotient = remainder / denominator;
                    result += String.valueOf(quotient);
                    remainder = (remainder % denominator) * 10;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] inputs = {{ 47, 18 }, { 5, 333 }, { 2, 3 }, { 93, 7 }, { -5, 333 }, { 47, -18 },
                { -4, -2 } };
        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1 + ".\tInput: fraction_to_decimal(");
            for (int j = 0; j < inputs[i].length - 1; j++) {
                System.out.print(inputs[i][j]);
                System.out.print(", ");
            }
            System.out.println(inputs[i][inputs[i].length - 1] + ")");
            String result = fractionToDecimal(inputs[i][0], inputs[i][1]);
            System.out.println("\tOutput: " + result);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}