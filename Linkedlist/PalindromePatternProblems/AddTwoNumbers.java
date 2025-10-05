package DSA.Linkedlist.PalindromePatternProblems;

import DSA.utils.ListUtils.ListNode;

import static DSA.utils.ListUtils.printList;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // l1 = [2 -> 4 -> 3], l2 = [5 -> 6 -> 4]
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = addTwoNumbers(l1, l2);

        printList(result); // [7,0,8]
        printList(addTwoNumbers(new ListNode(0), new ListNode(0))); // 0
    }
}
