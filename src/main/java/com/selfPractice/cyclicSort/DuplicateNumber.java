package com.selfPractice.cyclicSort;

public class DuplicateNumber {
    public static void main(String[] args) {
        System.out.println(DuplicateNumber.findDuplicate(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(DuplicateNumber.findDuplicate(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(DuplicateNumber.findDuplicate(new int[] { 2, 4, 1, 4, 4 }));
    }

    public static int findDuplicate(int[] arr) {
        int slow = arr[0];
        int fast = arr[0];

        //finding cycle
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while(slow != fast);

        //finding length of cycle
        int current = arr[slow];
        int cycleLength = 0;
        do {
            current = arr[current];
            cycleLength++;
        } while(current != arr[slow]);

        //finding start of cycle
        int pointer1 = arr[0];
        int pointer2 = arr[0];

        while (cycleLength > 0) {
            pointer2 = arr[pointer2];
            cycleLength--;
        }

        while (pointer1 != pointer2) {
            pointer1 = arr[pointer1];
            pointer2 = arr[pointer2];
        }

        return pointer1;
    }
}
