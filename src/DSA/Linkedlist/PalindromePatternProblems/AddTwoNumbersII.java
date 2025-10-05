package DSA.Linkedlist.PalindromePatternProblems;

import DSA.utils.ListUtils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static DSA.utils.ListUtils.printList;

public class AddTwoNumbersII {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();

        // push l1 into stack
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        // push l2 into stack
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode res = null;

        // add from stacks
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int x = (!s1.isEmpty()) ? s1.pop() : 0;
            int y = (!s2.isEmpty()) ? s2.pop() : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            // prepend new node
            ListNode node = new ListNode(sum % 10);
            node.next = res;
            res = node;
        }

        return res;
    }

    // Test
    public static void main(String[] args) {
        // l1 = [7 -> 2 -> 4 -> 3], l2 = [5 -> 6 -> 4]
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        printList(addTwoNumbers(l1, l2)); // 7 8 0 7
    }
}
