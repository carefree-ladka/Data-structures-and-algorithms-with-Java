package DSA.Linkedlist.SortingAndMerging;

import DSA.utils.ListUtils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

import static DSA.utils.ListUtils.printList;

public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        for (ListNode list : lists) {
            if (list != null)
                pq.add(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();

            current.next = node;
            current = current.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }

    public static ListNode mergeKListsDivideConquer(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        int idx = 1;

        while (idx < lists.length) {

            for (int i = 0; i + idx < lists.length; i += 2 * idx) {
                lists[i] = MergeTwoSortedLists.mergeTwoLists(lists[i], lists[i + idx]);
            }
            idx *= 2;
        }
        return lists[0];
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);

        ListNode list2 = new ListNode(3);
        list2.next = new ListNode(4);

        ListNode list3 = new ListNode(5);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};

        printList(mergeKLists(lists)); // 1 2 3 4 5 6
    }
}
