package DSA.Linkedlist.TwoPointerProblems;

public class IntersectionOfTwoLinkedLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = (a != null ? a.next : null);
            b = (b != null ? b.next : null);
        }
        
        return a;  // Either the intersection node or null
    }

    public static void main(String[] args) {
        // List A: 1 -> 2 -> 3 \
        //                        7 -> 8 -> 9
        // List B:       4 -> 5 /
        ListNode common = new ListNode(7);
        common.next = new ListNode(8);
        common.next.next = new ListNode(9);

        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = common;

        ListNode headB = new ListNode(4);
        headB.next = new ListNode(5);
        headB.next.next = common;

        ListNode intersection = getIntersectionNode(headA, headB);

        System.out.println("Intersection Node: " + (intersection != null ? intersection.val : "null"));
    }
}
