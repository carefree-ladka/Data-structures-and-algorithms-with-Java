package DSA.HashSet;

import java.util.Objects;

/**
 * A simple implementation of DSA.HashSet using separate chaining.
 * This DSA.HashSet does not allow duplicate elements and permits one null element.
 *
 * @param <E> the type of elements maintained by this set
 */
public class HashSet<E> {

    /**
     * Node class to represent each element in the bucket list.
     */
    private static class Node<E> {
        E key;
        Node<E> next;

        Node(E key) {
            this.key = key;
        }
    }

    private Node<E>[] buckets;
    private int capacity = 16;
    private int size = 0;
    private static final double LOAD_FACTOR = 0.75;

    @SuppressWarnings("unchecked")
    public HashSet() {
        buckets = new Node[capacity];
    }

    /**
     * Computes the bucket index for a given key.
     */
    private int getBucketIndex(E key) {
        if (key == null) {
            return 0;
        }
        // Use bit masking for better distribution and to handle negative hash codes
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    /**
     * Adds the specified element to the set if not already present.
     *
     * @param key element to be added
     * @return true if the set did not already contain the element
     */
    public boolean add(E key) {
        int index = getBucketIndex(key);
        Node<E> head = buckets[index];

        while (head != null) {
            if (Objects.equals(head.key, key)) {
                return false; // already exists
            }
            head = head.next;
        }

        Node<E> newNode = new Node<>(key);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;

        if ((1.0 * size) / capacity >= LOAD_FACTOR) {
            resize();
        }
        return true;
    }

    /**
     * Returns true if this set contains the specified element.
     *
     * @param key element whose presence is to be tested
     * @return true if this set contains the specified element
     */
    public boolean contains(E key) {
        int index = getBucketIndex(key);
        Node<E> head = buckets[index];

        while (head != null) {
            if (Objects.equals(head.key, key)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * Removes the specified element from this set if present.
     *
     * @param key object to be removed from the set
     * @return true if the set contained the specified element
     */
    public boolean remove(E key) {
        int index = getBucketIndex(key);
        Node<E> head = buckets[index];
        Node<E> prev = null;

        while (head != null) {
            if (Objects.equals(head.key, key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets[index] = head.next;
                }
                size--;
                return true;
            }
            prev = head;
            head = head.next;
        }
        return false;
    }

    /**
     * Returns the number of elements in this set.
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this set contains no elements.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all elements from this set.
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        buckets = new Node[capacity];
        size = 0;
    }

    /**
     * Doubles the capacity and rehashes all existing elements.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        Node<E>[] oldBuckets = buckets;
        int oldCapacity = capacity;

        capacity *= 2;
        buckets = new Node[capacity];
        int oldSize = size;
        size = 0;

        // Rehash all existing elements
        for (int i = 0; i < oldCapacity; i++) {
            Node<E> head = oldBuckets[i];
            while (head != null) {
                Node<E> next = head.next; // Save next before adding
                addDuringResize(head.key);
                head = next;
            }
        }

        // Verify size consistency
        assert size == oldSize : "Size mismatch during resize";
    }

    /**
     * Helper method to add elements during resize without triggering another resize.
     */
    private void addDuringResize(E key) {
        int index = getBucketIndex(key);
        Node<E> newNode = new Node<>(key);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    /**
     * Returns a string representation of the set for debugging.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;

        for (int i = 0; i < capacity; i++) {
            Node<E> head = buckets[i];
            while (head != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(head.key);
                first = false;
                head = head.next;
            }
        }

        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        // Test basic operations
        System.out.println("Adding elements...");
        set.add("apple");
        set.add("banana");
        set.add("orange");
        set.add(null);

        System.out.println("Set contents: " + set);
        System.out.println("Size: " + set.size()); // 4

        System.out.println("\nTesting contains...");
        System.out.println("Contains 'banana': " + set.contains("banana")); // true
        System.out.println("Contains 'grape': " + set.contains("grape"));   // false
        System.out.println("Contains null: " + set.contains(null));         // true

        System.out.println("\nRemoving 'banana'...");
        set.remove("banana");
        System.out.println("Contains 'banana': " + set.contains("banana")); // false
        System.out.println("Size: " + set.size()); // 3

        System.out.println("\nTrying to add duplicate 'apple'...");
        boolean added = set.add("apple");
        System.out.println("Was 'apple' added: " + added); // false
        System.out.println("Size: " + set.size()); // 3

        // Test resize by adding many elements
        System.out.println("\nTesting resize by adding many elements...");
        for (int i = 0; i < 20; i++) {
            set.add("item" + i);
        }
        System.out.println("Size after adding 20 items: " + set.size());

        // Test clear
        System.out.println("\nTesting clear...");
        set.clear();
        System.out.println("Size after clear: " + set.size()); // 0
        System.out.println("Is empty: " + set.isEmpty()); // true
    }
}