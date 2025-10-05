package DSA.Linkedlist.SortingAndMerging;

import DSA.utils.ListUtils.ListNode;

import static DSA.Linkedlist.SortingAndMerging.MergeTwoSortedLists.mergeTwoLists;
import static DSA.utils.ListUtils.printList;

public class SortLinkedList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Split list into halves
        ListNode mid = getMiddle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        // Step 2: Recursive sort
        left = sortList(left);
        right = sortList(right);

        // Step 3: Merge sorted halves
        return mergeTwoLists(left, right);
    }

    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode unsorted = new ListNode(4);
        unsorted.next = new ListNode(2);
        unsorted.next.next = new ListNode(1);
        unsorted.next.next.next = new ListNode(3);

        System.out.print("Sorted List (Merge Sort): ");
        printList(sortList(unsorted)); // 1 2 3 4
    }
}
