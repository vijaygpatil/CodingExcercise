package com.selfPractice.InPlaceReverseLinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ReverseLinkedListInKOrderGroup {

    public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {
    
    LinkedListNode dummy = new LinkedListNode(0);
    dummy.next = head;
    LinkedListNode ptr = dummy;

    while (ptr != null) {

        LinkedListNode tracker = ptr;

        for (int i = 0; i < k; i++) {
            if (tracker == null) {
                break;
            }
            tracker = tracker.next;
        }

        if (tracker == null) {
            break;
        }

        LinkedListNode[] updatedNodes = LinkedListReversal.reverseLinkedList(ptr.next, k);
        LinkedListNode previous = updatedNodes[0];
        LinkedListNode current = updatedNodes[1];

        LinkedListNode lastNodeOfReversedGroup = ptr.next;
        lastNodeOfReversedGroup.next = current;
        ptr.next = previous;
        ptr = lastNodeOfReversedGroup;

    }

    return dummy.next;
}

    // Driver code
    public static void main(String[] args) {
        List<List<Integer>> inputList = new ArrayList<>(Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8),
                Arrays.asList(3, 4, 5, 6, 2, 8, 7, 7),
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(1)
        ));

        List<Integer> k = new ArrayList<>(Arrays.asList(3, 2, 1, 7, 1));

        for (int i = 0; i < inputList.size(); ++i) {
            LinkedList inputLinkedList = new LinkedList();
            inputLinkedList.createLinkedList(inputList.get(i));

            System.out.print((i + 1) + ".\tLinked list: ");
            PrintList.printListWithForwardArrow(inputLinkedList.head);
            System.out.println();

            System.out.print("\n\tReversed linked list: ");
            LinkedListNode result = reverseKGroups(inputLinkedList.head, k.get(i));
            PrintList.printListWithForwardArrow(result);
            System.out.println();

            String hyphens = new String(new char[100]).replace('\0', '-');
            System.out.println(hyphens);
        }
    }
}