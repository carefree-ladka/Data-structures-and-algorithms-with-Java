package DSA.Linkedlist.TwoPointerProblems;

public class CycleDetection {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static boolean detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    public static ListNode getCycleStartingNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow)
                break;
        }

        if (fast == null || fast.next == null)
            return null;

        fast = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        // Create a cycle: 6 -> 3
        head.next.next.next.next.next.next = head.next.next;

        // Test detectCycle
        boolean hasCycle = detectCycle(head);
        System.out.println("Cycle detected? " + hasCycle); // true

        // Test getCycleStartingNode
        ListNode cycleStart = getCycleStartingNode(head);
        System.out.println("Cycle starts at node with value: " + (cycleStart != null ? cycleStart.val : "null")); // 3
    }
}
