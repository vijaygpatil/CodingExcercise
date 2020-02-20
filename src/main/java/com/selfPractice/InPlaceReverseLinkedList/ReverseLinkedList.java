package com.selfPractice.InPlaceReverseLinkedList;

public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {

        if(head == null || head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null) {
            next = current.next; // temporarily store the next node
            current.next = previous; // reverse the current node
            previous = current; // before we move to the next node, point previous to the current node
            current = next; // move on the next node
        }

        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

//        System.out.print("Nodes of the LinkedList are: ");
//        while (head != null) {
//            System.out.print(head.val + " ");
//            head = head.next;
//        }
//        System.out.println();

        ListNode result = ReverseLinkedList.reverse(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
