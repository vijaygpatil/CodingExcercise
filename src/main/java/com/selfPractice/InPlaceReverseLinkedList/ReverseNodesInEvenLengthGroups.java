package com.selfPractice.InPlaceReverseLinkedList;

import java.util.*;

class ReverseNodesInEvenLengthGroups {
	public static LinkedListNode reverseEvenLengthGroups(LinkedListNode head)
	{
		LinkedListNode prev = head;
		LinkedListNode node, reverse, currNext, curr, prevNext = null;
		int groupLen = 2;
		int numNodes = 0;
		while(prev.next!= null)
		{
			node = prev;
			numNodes = 0;
			for (int i = 0; i < groupLen; i ++)
			{
				if(node.next == null)
                    break;
				numNodes += 1;
				node=node.next;
			}

			if(numNodes % 2 != 0) {
			   prev = node; 
			} else {
				reverse = node.next;
				curr = prev.next;
                for(int j=0; j < numNodes;j++){
                    currNext = curr.next;
				    curr.next = reverse;
				    reverse = curr;
				    curr = currNext;
                }
                prevNext = prev.next;
				prev.next = node;
			    prev = prevNext;
			}
			groupLen += 1;
		}
	    return head;
	}
		

	public static void main(String[] args) {

		// Declaring and creating a linked list
		LinkedList obj1 = new LinkedList();
		List<Integer> inputList = Arrays.asList(1, 2, 3, 4);
        List<Integer> inputList1 = Arrays.asList(10, 11, 12, 13, 14);
        List<Integer> inputList2 = Arrays.asList(15);
        List<Integer> inputList3 = Arrays.asList(16, 17);

        LinkedList inputLinkList1 = new LinkedList();
        inputLinkList1.createLinkedList(inputList);

        LinkedList inputLinkList2 = new LinkedList();
        inputLinkList2.createLinkedList(inputList1);

        LinkedList inputLinkList3 = new LinkedList();
        inputLinkList3.createLinkedList(inputList2);
        
        LinkedList inputLinkList4 = new LinkedList();
        inputLinkList4.createLinkedList(inputList3);

		List<LinkedListNode> listHeads = Arrays.asList(inputLinkList1.head, inputLinkList2.head, inputLinkList3.head, inputLinkList4.head);
		for (int i = 0; i< listHeads.size(); i++)
		{
			System.out.println(i+1 + ".\tIf we reverse the even length groups of the linked list:");
			PrintList.printListWithForwardArrow(listHeads.get(i));
			System.out.println("\n\n\twe will get: \t");
			PrintList.printListWithForwardArrow(reverseEvenLengthGroups(listHeads.get(i)));
			System.out.print("\n");
			System.out.println(new String(new char[100]).replace('\0', '-'));
		}
	}
}