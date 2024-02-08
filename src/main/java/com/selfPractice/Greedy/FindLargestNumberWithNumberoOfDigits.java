package com.selfPractice.Greedy;

class FindLargestNumberWithNumberOfDigits {

    public static int findSumOfDigits(int num) {

        int sum = 0;
        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void findLargestNumber(int numberOfDigits, int sumOfDigits) {
        int max = 0;
        int startRange = (int) Math.pow(10, (numberOfDigits - 1));
        int endRange = (int) Math.pow(10, numberOfDigits);

        if (sumOfDigits == 0) {
            if (numberOfDigits == 1)
                System.out.println("Largest number is " + 0);
            else
                System.out.println("Largest number is Not possible");
            return;
        }

        // sumOfDigits is greater than the maximum possible sum.
        if (sumOfDigits > 9 * numberOfDigits) {
            System.out.println("Largest number is Not possible");
            return;
        }

        while (startRange < endRange) {
            if (findSumOfDigits(startRange) == sumOfDigits) {
                if (max < startRange)
                    max = startRange;
            }
            startRange++;
        }

        System.out.println("Largest number is " + max);
    }

    public static void findLargestNumber2(int number_of_digits, int sum_of_digits) {
        int[] result = new int[number_of_digits];
        // If sum of digits is 0, then a number is possible only if number of digits is 1.
        if (sum_of_digits == 0) {
            if (number_of_digits == 1) {
                System.out.print(0);
            } else {
                System.out.print("None");
            }
            return;
        }
        // sumOfDigits is greater than the maximum possible sum.
        if (sum_of_digits > 9 * number_of_digits) {
            System.out.print("None");
            return;
        }
        // Fill from most significant digit to least significant digit!
        for (int i = 0; i < number_of_digits; i++) {
            // Place 9 to make the number largest
            if (sum_of_digits >= 9) {
                result[i] = 9;
                sum_of_digits -= 9;
            }
            // If remaining sum becomes less than 9, then fill the remaining sum
            else {
                result[i] = sum_of_digits;
                sum_of_digits = 0;
            }
        }
        for (int i = 0; i < number_of_digits; i++) {
            System.out.print(result[i]);
        }
    }
}



class Main{
    public static void main(String[] args) {
        int sumOfDigits = 20;
        int numberOfDigits = 3;

        System.out.println("If sum of digits is 20 and number of digits is 3 then ");
        FindLargestNumberWithNumberOfDigits.findLargestNumber(numberOfDigits, sumOfDigits);
        System.out.println();

        //Example 2
        sumOfDigits = 100;
        numberOfDigits = 2;

        System.out.println("If sum of digits is 100 and number of digits is 2 then ");
        FindLargestNumberWithNumberOfDigits.findLargestNumber(numberOfDigits, sumOfDigits);

    }
}
