package DSA.Linkedlist.ModificationProblems;

import DSA.utils.ListUtils.ListNode;

import static DSA.utils.ListUtils.printList;

public class RotateLinkedList {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Compute the length of the list
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Make it a circular list
        tail.next = head;

        // Step 3: Find the new head
        k = k % length; // handle k > length
        int stepsToNewHead = length - k;
        ListNode newTail = tail;

        while (stepsToNewHead > 0) {
            newTail = newTail.next;
            stepsToNewHead--;
        }

        ListNode newHead = newTail.next;
        newTail.next = null; // break the circle

        return newHead;
    }

    public static void main(String[] args) {
        // Test case: 1 -> 2 -> 3 -> 4 -> 5, k = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head); // 1 2 3 4 5

        int k = 2;
        ListNode rotated = rotateRight(head, k);

        System.out.print("Rotated List by " + k + ": ");
        printList(rotated); // 4 5 1 2 3
    }
}
