package com.selfPractice.InPlaceReverseLinkedList;

import java.util.Arrays;
import java.util.List;

class LinkedListAlternateReorder {
	public static LinkedListNode reorderList(LinkedListNode head)
	{
		if(head == null)
		    return head;

		LinkedListNode slow = head; 
		LinkedListNode fast = head;

		while(fast!= null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		LinkedListNode prev = null;
		LinkedListNode curr = slow;
		LinkedListNode next = null;

		while(curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		LinkedListNode first = head;
		LinkedListNode second = prev;
		LinkedListNode temp = head;

        while(second.next != null)
		{
			temp = temp.next;
			first.next = second;
			second = second.next;
			first.next.next = temp;
			first = first.next.next;
		}

		return head;
	}

	public static void main(String[] args) {
		LinkedList obj1 = new LinkedList();
		List<Integer> inputList = Arrays.asList(1, 1, 2, 2, 3, -1, 10, 12);
		obj1.createLinkedList(inputList);
		System.out.print("1.\tOrignal list: ");
		PrintList.printListWithForwardArrow(obj1.head);
		reorderList(obj1.head);
		System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj1.head);
//		System.out.println(PrintHyphens.repeat("-", 100));

		LinkedList obj2 = new LinkedList();
		List<Integer> inputList1 = Arrays.asList(10, 20, -22, 21, -12);
		obj2.createLinkedList(inputList1);
		System.out.print("2.\tOrignal list: ");
		PrintList.printListWithForwardArrow(obj2.head);
		reorderList(obj2.head);
		System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj2.head);
//		System.out.println(PrintHyphens.repeat("-", 100));

		LinkedList obj3 = new LinkedList();
		List<Integer> inputList2 = Arrays.asList(1, 1, 1);
		obj3.createLinkedList(inputList2);
		System.out.print("3.\tOrignal list: ");
		PrintList.printListWithForwardArrow(obj3.head);
		reorderList(obj3.head);
		System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj3.head);
//		System.out.println(PrintHyphens.repeat("-", 100));

		LinkedList obj4 = new LinkedList();
		List<Integer> inputList3 = Arrays.asList(-2, -5, -6, 0, -1, -4);
		obj4.createLinkedList(inputList3);
		System.out.print("4.\tOrignal list: ");
		PrintList.printListWithForwardArrow(obj4.head);
		reorderList(obj4.head);
		System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj4.head);
//		System.out.println(PrintHyphens.repeat("-", 100));

		LinkedList obj5 = new LinkedList();
		List<Integer> inputList4 = Arrays.asList(3, 1, 5, 7, -4, -2, -1, -6);
		obj5.createLinkedList(inputList4);
		System.out.print("5.\tOrignal list: ");
		PrintList.printListWithForwardArrow(obj5.head);
		reorderList(obj5.head);
		System.out.print("\tAfter folding: ");
        PrintList.printListWithForwardArrow(obj5.head);
//		System.out.println(PrintHyphens.repeat("-", 100));
	}
}