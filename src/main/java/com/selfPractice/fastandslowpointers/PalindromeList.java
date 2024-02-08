package com.selfPractice.fastandslowpointers;

import java.util.*;

class PalindromeList {
    public static boolean palindrome(LinkedListNode head) {
       
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        LinkedListNode revertData = LinkedListReversal.reverseLinkedList(slow);
        boolean check = compareTwoHalves(head, revertData);
        LinkedListReversal.reverseLinkedList(revertData);
        
        if (check) {
            return true;
        }

        return false;

    }

    public static boolean compareTwoHalves(LinkedListNode firstHalf, LinkedListNode secondHalf) {
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            } else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }


        }
        return true;
    }

    // Driver code
    public static void main( String args[] ) {
        
        int[][] input={
          {2, 4, 6, 4, 2},
          {0, 3, 5, 5, 0},
          {9, 27, 4, 4, 27, 9},
          {5, 4, 7, 9, 4, 5},
          {5, 10, 15, 20, 15, 10, 5}
          };
        
        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tLinked list:  ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tIs it a palindrome?  ");
            boolean result = palindrome(list.head);
            if(result){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
        
    }
}