package com.selfPractice.linkedList;

class PalindromeChallengeDLL {
    public static <T> boolean isPalindrome(DoublyLinkedList<T> list) {
        DoublyLinkedList<T>.Node start = list.getHeadNode(); // get the head pointer
        DoublyLinkedList<T>.Node end = list.getTailNode(); // get the tail
        if (start == null){ // if list is empty, it is a palindrome
            return true;
        }
        while(start != null){ //otherwise traverse list from both sides
            if (start.data != end.data){ // if data mismatches at any point list is not a palindrome
                return false;
            }
            start = start.nextNode;
            end = end.prevNode;
        }
        return true; // if data didn't mismatch at any point, list is a palindrome.
    }
    public static void main( String args[] ) {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<Integer>();
        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list1.insertAtEnd(2);
        list1.insertAtEnd(1);
        System.out.print("1st ");
        list1.printList();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<Integer>();
        list2.insertAtEnd(6);
        list2.insertAtEnd(8);
        list2.insertAtEnd(6);
        list2.insertAtEnd(6);
        System.out.print("2nd ");
        list2.printList();
        System.out.println("Is 1st list a palindrome?  " + isPalindrome(list1));
        System.out.println("Is 2nd list a palindrome?  " + isPalindrome(list2));

    }

}

