package com.selfPractice.Recursion;

import com.selfPractice.linkedList.SinglyLinkedList;

import java.util.LinkedList;

class SearchInLinkedList {

//    public static boolean search(Node head, int num) {
//      // Base case
//      if (head == null) {
//        return false;
//      }
//
//      // Recursive case
//      else {
//        if (head.value == num) {
//          return true;
//        }
//        else {
//          return search(head.next, num);
//        }
//      }
//    }
//
//    public static void main( String args[] ) {
//        /* Start with the empty list */
//        SinglyLinkedList list = new SinglyLinkedList();
//        list.insertAtHead(0);
//        list.insertAtHead(3);
//        list.insertAtHead(1);
//        list.insertAtHead(6);
//        list.insertAtHead(4);
//
//        System.out.println("Linked List: ");
//        for (Node i = list.head; i != null; i = i.next) {
//          System.out.print(i.value + " ");
//        }
//
//        System.out.println(" ");
//        int searchFor = 8;
//        boolean result = search(list.head, searchFor);
//        System.out.println("Is " + searchFor + " present in the list? : " + result);
//    }
}