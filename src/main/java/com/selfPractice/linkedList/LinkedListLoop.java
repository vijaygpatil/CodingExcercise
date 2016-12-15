package com.selfPractice.linkedList;

public class LinkedListLoop {
	public boolean loopExists(ListNode<Integer> L) {
		
		ListNode<Integer> fast = L;
		ListNode<Integer> slow = L;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow) {
				return true;
			}
		}
		
		return false;
	}
	
	public ListNode<Integer> findStartInLoopedLinkedList(ListNode<Integer> L) {
		ListNode<Integer> fast = L;
		ListNode<Integer> slow = L;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow) {
				int cycleLen = 0;
				do {
					++cycleLen;
					fast = fast.next;
				} while(slow != fast);
				
				ListNode<Integer> cycleAdvanceIter = L;
				while(cycleLen-- > 0) {
					cycleAdvanceIter = cycleAdvanceIter.next;
				}
				
				ListNode<Integer> iter = L;
				while(iter != cycleAdvanceIter) {
					iter = iter.next;
					cycleAdvanceIter = cycleAdvanceIter.next;
				}
				return iter;
			}
		}
		return null;
	}
	
	public ListNode<Integer> findStartInLoopedLinkedList2(ListNode<Integer> L) {
		ListNode<Integer> fast = L;
		ListNode<Integer> slow = L;
		
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow) {
				slow = L;
				while(slow != fast) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}
}
