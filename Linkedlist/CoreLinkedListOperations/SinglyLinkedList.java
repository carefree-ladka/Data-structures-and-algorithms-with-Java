package DSA.Linkedlist.CoreLinkedListOperations;

public class SinglyLinkedList {

    // Node definition
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // head of the list

    // ---------------- Basic Operations ----------------

    // Insert at head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert at given position (0-based index)
    public void insertAtPosition(int data, int position) {
        if (position < 0) {
            throw new IllegalArgumentException("Position must be >= 0");
        }
        if (position == 0) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            throw new IndexOutOfBoundsException("Position out of range");
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by value
    public void deleteByValue(int value) {
        if (head == null) return;

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Delete by position (0-based index)
    public void deleteByPosition(int position) {
        if (position < 0 || head == null) return;

        if (position == 0) {
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            throw new IndexOutOfBoundsException("Position out of range");
        }

        temp.next = temp.next.next;
    }

    // Find length
    public int getLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // ---------------- Reversal Operations ----------------

    // Iterative reversal
    public void reverseIterative() {
        Node prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Recursive reversal
    public void reverseRecursive() {
        head = reverseRecursiveHelper(head);
    }

    private Node reverseRecursiveHelper(Node node) {
        if (node == null || node.next == null) return node;
        Node newHead = reverseRecursiveHelper(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    // Reverse first k nodes
    public void reverseFirstK(int k) {
        if (k <= 0 || head == null) return;
        Node prev = null, curr = head, next = null;
        Node kthNode = head;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        head.next = curr; // connect the tail of reversed part
        head = prev;      // new head
    }

    // Reverse between m and n (1-based index)
    public void reverseBetween(int m, int n) {
        if (m >= n || head == null) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        // Move prev to node before position m
        for (int i = 1; i < m; i++) {
            if (prev == null) return;
            prev = prev.next;
        }

        Node curr = prev.next;
        Node next = null;

        // Reverse from m to n
        for (int i = 0; i < n - m; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        head = dummy.next;
    }

    // ---------------- Middle Node ----------------
    public Node findMiddle() {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // ---------------- Nth Node from End ----------------
    public Node findNthFromEnd(int n) {
        if (head == null || n <= 0) return null;
        Node first = head, second = head;
        for (int i = 0; i < n; i++) {
            if (first == null) return null; // n > length
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }

    // ---------------- Check if Length is Even or Odd ----------------
    public boolean isLengthEven() {
        Node temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next.next;
        }
        return temp == null; // true if even, false if odd
    }

    // Print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Driver code to test
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert nodes
        list.insertAtHead(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.insertAtPosition(15, 1);
        list.insertAtTail(40);
        list.insertAtTail(50);

        System.out.print("Original List: ");
        list.printList();

        // Length
        System.out.println("Length: " + list.getLength());

        // Delete by value
        list.deleteByValue(20);
        System.out.print("After deleting 20: ");
        list.printList();

        // Delete by position
        list.deleteByPosition(2);
        System.out.print("After deleting position 2: ");
        list.printList();

        // Iterative reversal
        list.reverseIterative();
        System.out.print("After Iterative Reverse: ");
        list.printList();

        // Recursive reversal
        list.reverseRecursive();
        System.out.print("After Recursive Reverse: ");
        list.printList();

        // Reverse first k nodes (k=3)
        list.reverseFirstK(3);
        System.out.print("After Reversing First 3 Nodes: ");
        list.printList();

        // Reverse between m and n (m=2, n=4)
        list.reverseBetween(2, 4);
        System.out.print("After Reversing Between 2 and 4: ");
        list.printList();

        // Find middle node
        Node middle = list.findMiddle();
        System.out.println("Middle Node: " + (middle != null ? middle.data : "null"));

        // Find nth node from end (n=2)
        Node nth = list.findNthFromEnd(2);
        System.out.println("2nd Node from End: " + (nth != null ? nth.data : "null"));

        // Check if length is even or odd
        System.out.println("Is Length Even? " + list.isLengthEven());
    }
}
