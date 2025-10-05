package DSA.Linkedlist.PalindromePatternProblems;

import DSA.utils.ListUtils.ListNode;

import static DSA.utils.ListUtils.printList;

public class MultiplyLinkedLists {

    public static ListNode multiplyTwoLists(ListNode l1, ListNode l2) {
        long num1 = 0, num2 = 0;

        // Convert l1 to number
        while (l1 != null) {
            num1 = num1 * 10 + l1.val;
            l1 = l1.next;
        }

        // Convert l2 to number
        while (l2 != null) {
            num2 = num2 * 10 + l2.val;
            l2 = l2.next;
        }

        long product = num1 * num2;

        // If product is 0
        if (product == 0) return new ListNode(0);

        // Convert product to linked list
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        String str = String.valueOf(product);
        for (char c : str.toCharArray()) {
            curr.next = new ListNode(c - '0');
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(4, new ListNode(6)));  // 946
        ListNode l2 = new ListNode(8, new ListNode(4));                   // 84

        printList(multiplyTwoLists(l1, l2)); // 7 9 4 6 4
    }
}
