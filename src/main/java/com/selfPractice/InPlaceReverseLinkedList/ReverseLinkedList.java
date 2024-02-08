package com.selfPractice.InPlaceReverseLinkedList;

class ReverseLinkedList {
    // Assume that the linked list has left to right nodes.
    // Reverse left to right nodes of the given linked list.
    public static LinkedListNode reverse(LinkedListNode head, int left, int right) {
        LinkedListNode prev = null;
        LinkedListNode curr = head;
        while (right >= left) {
            LinkedListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }
        return prev;
    }

    // Reverses the sublist between left and right in the linked list
    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        LinkedListNode curr = head;
        LinkedListNode lpn = null;
        LinkedListNode right_n = null;
        LinkedListNode reverse_head = null;

        int count = 1;
        while (count < left && curr != null) {
            lpn = curr;
            curr = curr.next;
            count++;
        }
        if (curr != null) {
            LinkedListNode rpn = curr;
            while (count <= right && rpn != null) {
                right_n = rpn;
                rpn = right_n.next;
                count++;
            }
            if (right_n != null) {
                reverse_head = reverse(curr, left, right);
            }
            if (lpn != null) {
                lpn.next = reverse_head;
            }
            if (rpn != null) {
                LinkedListNode tmp = reverse_head;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = rpn;
            }
        }

        if (lpn != null) {
            return head;
        } else {
            return reverse_head;
        }
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] input = {
            {1, 2, 3, 4, 5, 6, 7},
            {6, 9, 3, 10, 7, 4, 6},
            {6, 9, 3, 4},
            {6, 2, 3, 6, 9},
            {6, 2}
        };
        int[] left = {1, 3, 2, 1, 1};
        int[] right = {5, 6, 4, 3, 2};
        for(int i=0; i<input.length; i++){
            System.out.print(i+1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tOriginal linked list is:  ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tReversed linked list is:  " );
            PrintList.printListWithForwardArrow(reverseBetween(list.head,left[i],right[i]));
        }
    }
}