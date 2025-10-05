package DSA.Linkedlist.PalindromePatternProblems;

import DSA.utils.ListUtils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckPalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();

        ListNode current = head;

        // 1. Push all nodes to stack
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        // 2. Compare while popping
        current = head;
        while (current != null) {
            if (current.val != stack.pop()) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    public static boolean isPalindromeOptimized(ListNode head) {
        if (head == null || head.next == null) return true;

        // 1. Find middle (slow will be at mid)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode secondHalf = reverseList(slow);

        // 3. Compare both halves
        ListNode firstHalf = head;
        ListNode copySecondHalf = secondHalf; // keep a copy for restoring
        boolean isPalin = true;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                isPalin = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // 4. Restore list (optional)
        reverseList(copySecondHalf);

        return isPalin;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head)); // true

        head.next.next.next.next = new ListNode(3);
        System.out.println(isPalindrome(head)); // false
    }
}
