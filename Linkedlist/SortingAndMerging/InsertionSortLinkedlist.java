package DSA.Linkedlist.SortingAndMerging;

import DSA.utils.ListUtils;
import DSA.utils.ListUtils.ListNode;

import static DSA.utils.ListUtils.printList;

public class InsertionSortLinkedlist {

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);

        while (head != null) {
            ListNode prev = dummy;

            // Find the insertion point
            while (prev.next != null && prev.next.val < head.val) {
                prev = prev.next;
            }

            // Insert current node
            ListNode next = head.next;
            head.next = prev.next;
            prev.next = head;
            head = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListUtils.ListNode unsorted = new ListUtils.ListNode(4);
        unsorted.next = new ListUtils.ListNode(2);
        unsorted.next.next = new ListUtils.ListNode(1);
        unsorted.next.next.next = new ListUtils.ListNode(3);

        System.out.print("Sorted List (Merge Sort): ");
        printList(insertionSortList(unsorted)); // 1 2 3 4
    }
}
