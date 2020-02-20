package com.selfPractice.InPlaceReverseLinkedList;

public class ReverseEveryKElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null)
            return head;

        ListNode current = head;
        ListNode previous = null;
        while(true) {
            ListNode lastNodeOfPreviousList = previous;
            ListNode lastNodeOfSublist = current;
            ListNode next = null;

            int i = 0;
            while(i < k && current != null) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
                i++;
            }

            if(lastNodeOfPreviousList != null) {
                lastNodeOfPreviousList.next = previous;
            } else {
                head = previous;
            }

            lastNodeOfSublist.next = current;

            if(current == null) {
                break;
            }

            previous = lastNodeOfSublist;
        }
        return head;
    }
}
