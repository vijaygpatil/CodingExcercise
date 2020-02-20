package com.selfPractice.fastandslowpointers;

public class LinkedListCycleStart {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).val);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).val);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).val);
    }

    public static ListNode findCycleStart(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                break;
            }
        }

        ListNode count = slow.next;
        int length = 1;
        while(slow != count) {
            length++;
            count = count.next;
        }

        System.out.println("Length of the cycle: "+length);

        while(length != 0) {
            pointer2 = pointer2.next;
            length--;
        }

        while(pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer1;
    }
}
