package com.selfPractice.fastandslowpointers;

public class LinkedListCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        boolean isCyclic = false;
        ListNode pointer1 = head;
        ListNode pointer2 = head;
        while(pointer2 != null && pointer2.next.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;

            if(pointer1 == pointer2) {
                isCyclic = true;
                break;
            }

        }
        return isCyclic;
    }
}
