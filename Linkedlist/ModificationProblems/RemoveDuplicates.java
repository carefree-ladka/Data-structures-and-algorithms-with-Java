package DSA.Linkedlist.ModificationProblems;

import static DSA.utils.ListUtils.printList;

import java.util.HashSet;

import DSA.utils.ListUtils.ListNode;

public class RemoveDuplicates {

    public static ListNode removeDuplicatesSorted(ListNode head) {
        if (head == null)
            return null;

        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // skip duplicate
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static ListNode removeDuplicatesUnsorted(ListNode head) {
        if (head == null)
            return null;

        HashSet<Integer> seen = new HashSet<>();
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy, current = head;

        while (current != null) {
            if (seen.contains(current.val)) {
                prev.next = current.next; // remove duplicate
            } else {
                seen.add(current.val);
                prev = current;
            }
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Test sorted list
        ListNode sorted = new ListNode(1);
        sorted.next = new ListNode(1);
        sorted.next.next = new ListNode(2);
        sorted.next.next.next = new ListNode(3);
        sorted.next.next.next.next = new ListNode(3);

        System.out.print("Original Sorted List: ");
        printList(sorted); // 1 1 2 3 3

        ListNode sortedNoDup = removeDuplicatesSorted(sorted);
        System.out.print("After Removing Duplicates (Sorted): ");
        printList(sortedNoDup); // 1 2 3

        // Test unsorted list
        ListNode unsorted = new ListNode(4);
        unsorted.next = new ListNode(2);
        unsorted.next.next = new ListNode(3);
        unsorted.next.next.next = new ListNode(2);
        unsorted.next.next.next.next = new ListNode(4);

        System.out.print("Original Unsorted List: ");
        printList(unsorted); // 4 2 3 2 4

        ListNode unsortedNoDup = removeDuplicatesUnsorted(unsorted);
        System.out.print("After Removing Duplicates (Unsorted): ");
        printList(unsortedNoDup); // 4 2 3
    }
}
