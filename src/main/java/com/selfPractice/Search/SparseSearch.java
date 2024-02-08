package com.selfPractice.Search;

public class SparseSearch {
    public static void main(String[] args) {
        String [] array = {"", "educative", "", "", "",  "hello", "", "learning", "world", "", "", ""};
        String [] targetArray = {"educative", "learning"};

        for(int i = 0; i < 2; i++) {
            System.out.println(targetArray[i] + ": " + searchForString(array, targetArray[i]));
        }
    }

    private static int searchForString(String[] array, String target) {
        return modifiedBinarySearch(array, 0, array.length - 1, target);
    }

    private static int modifiedBinarySearch(String[] array, int low, int high, String target) {
        if(low > high)
            return -1;

        int mid = (low + high) / 2;

        if(array[mid] == "") {
            int i = mid - 1;
            int j = mid + 1;
            while(true) {
                if(i < low && j > high)
                    return -1;

                if(i >= low && array[i] != "") {
                    mid = i;
                    break;
                } else if(j <= high && array[j] != "") {
                    mid = j;
                    break;
                }
                i--;
                j++;
            }
        }

        // Now perform simple Binary Search
        if (array[mid].equals(target))
            return mid;
        else if (array[mid].compareTo(target) > 0)
            return modifiedBinarySearch(array, low, mid - 1, target);
        else
            return modifiedBinarySearch(array, mid + 1, high, target);
    }
}