package DSA.Linkedlist.ModificationProblems;

import DSA.utils.ListUtils.ListNode;

import static DSA.utils.ListUtils.printList;

public class PartitionList {

    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        // Two dummy nodes to build <x and >=x lists
        ListNode beforeDummy = new ListNode(0);
        ListNode before = beforeDummy;
        ListNode afterDummy = new ListNode(0);
        ListNode after = afterDummy;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                before.next = current;
                before = before.next;
            } else {
                after.next = current;
                after = after.next;
            }
            current = current.next;
        }

        after.next = null; // terminate the after list
        before.next = afterDummy.next; // connect before list with after list

        return beforeDummy.next;
    }

    public static void main(String[] args) {
        // Test case: 1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        System.out.print("Original List: ");
        printList(head); // 1 4 3 2 5 2

        int x = 3;
        ListNode partitioned = partition(head, x);

        System.out.print("Partitioned List around " + x + ": ");
        printList(partitioned); // 1 2 2 4 3 5
    }
}
