package com.selfPractice.InPlaceReverseLinkedList;

public class ReverseSubList {
    public static ListNode reverse(ListNode head, int p, int q) {

        if(p == q) {
            return head;
        }

        // after skipping 'p-1' nodes, current will point to 'p'th node
        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < p - 1; ++i) {
            previous = current;
            current = current.next;
        }

        // we are interested in three parts of the LinkedList, part before index 'p', part between 'p' and
        // 'q', and the part after index 'q'
        ListNode lastNodeOfFirstPart = previous; // points to the node at index 'p-1'
        // after reversing the LinkedList 'current' will become the last node of the sub-list
        ListNode lastNodeOfSubList = current;
        ListNode next = null; // will be used to temporarily store the next node
        // reverse nodes between 'p' and 'q'
        for (int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // connect with the first part
        if (lastNodeOfFirstPart != null)
            lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
        else // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
            head = previous;

        // connect with the last part
        lastNodeOfSubList.next = current;

        return head;

    }

    public static ListNode reverse2(ListNode head, int p, int q) {
        if(p == q) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        int i = 0;
        while(i < p - 1) {
            previous = current;
            current = current.next;
            i++;
        }

        ListNode lastNodeofFirstPart = previous;
        ListNode lastNodeOfSublist = current;
        ListNode next = null;

        while(i < q) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            i++;
        }

        if (lastNodeofFirstPart != null)
            lastNodeofFirstPart.next = previous; // 'previous' is now the first node of the sub-list
        else // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
            head = previous;

        lastNodeOfSublist.next = current;

        return head;

    }

    public static ListNode reverse3(ListNode head, int p, int q) {
        ListNode previous = null;
        ListNode current = head;

        int i = 0;
        while(i < p - 1) {
            previous = current;
            current = current.next;
        }

        ListNode lastNodeOfPrevList = previous;
        ListNode lastNodeOfSublist = current;
        ListNode next = null;

        while(i < q) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            i++;
        }

        if(lastNodeOfPrevList != null) {
            lastNodeOfPrevList.next = previous;
        } else {
            head = previous;
        }

        lastNodeOfSublist.next = current;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse3(head, 1, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println();

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next.next = new ListNode(8);

        ListNode counter = head1;
        int i = 0;
        while(counter != null){
            i++;
            counter = counter.next;
        }

        System.out.println("Length of the head1: "+i);

        if(i % 2 == 0) {
            head1 = reverse2(head1, 1, i/2);
            head1 = reverse2(head1, i/2 + 1, i);
        } else {
            head1 = reverse2(head1, 1, i/2);
            head1 = reverse2(head1, i/2 + 2, i);
        }

        System.out.println();
        System.out.print("Nodes of the reversed LinkedList head1: ");
        while (head1 != null) {
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }
    }
}
