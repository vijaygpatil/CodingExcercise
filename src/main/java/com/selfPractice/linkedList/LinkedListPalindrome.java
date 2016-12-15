package com.selfPractice.linkedList;

public class LinkedListPalindrome {
	
	public static boolean isPalindrome(ListNode<Character> L) {
		
		if(L == null) {
			return false;
		}
		
		ListNode<Character> fast = L;
		ListNode<Character> slow = L;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		
		ListNode<Character> firstHalfIter = L;
		ListNode<Character> secondHalfIter = reverseSublist(slow, 2, 3);
		
		while(firstHalfIter != null && secondHalfIter != null) {
			if(firstHalfIter.data != secondHalfIter.data) {
				return false;
			}
			
			firstHalfIter = firstHalfIter.next;
			secondHalfIter = secondHalfIter.next;
		}
		
		return false;
	}
	
	public static ListNode<Character> reverseSublist(ListNode<Character> L, int start, int finish) {
		
		if (start == finish) {
			return L;
		}

		ListNode<Character> dummyHead = L;
		ListNode<Character> sublistHead = dummyHead;
		
		int k = 1;
		while (k++ < start) {
			sublistHead = sublistHead.next;
		}

		// Reverse sublist.
		ListNode<Character> sublistIter = sublistHead.next;
		while (start++ < finish) {
			ListNode<Character> temp = sublistIter.next;
			sublistIter.next = temp.next;
			temp.next = sublistHead.next;
			sublistHead.next = temp;
		}
		
		return dummyHead.next;
	}
}
