package DSA.HashMap;

import module java.base;

/**
 * A simple implementation of a DSA.HashMap using separate chaining
 * with linked lists to handle collisions.
 *
 * <p>This map supports {@code null} keys and values, similar to Java's
 * built-in {@link java.util.HashMap}. Only one {@code null} key is allowed,
 * which is always placed in bucket index 0.</p>
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class HashMap<K, V> {

    /**
     * Represents a single entry (key-value pair) in the hash map.
     *
     * @param <K> the type of keys
     * @param <V> the type of values
     */
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Array of buckets storing linked list entries.
     */
    private Entry<K, V>[] buckets;

    /**
     * Current capacity of the bucket array.
     */
    private int capacity = 16;

    /**
     * Current number of key-value mappings.
     */
    private int size = 0;

    /**
     * The load factor threshold for resizing.
     */
    private static final double LOAD_FACTOR = 0.75;

    /**
     * Creates a new empty {@code MyHashMap} with default initial capacity (16).
     */
    @SuppressWarnings("unchecked")
    public HashMap() {
        buckets = new Entry[capacity];
    }

    /**
     * Computes the index in the bucket array for the given key.
     *
     * @param key the key to hash (maybe null)
     * @return the bucket index where the key should reside
     */
    private int getBucketIndex(K key) {
        if (key == null) {
            return 0;
        }
        // Use bit masking to handle negative hash codes properly
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old value is replaced.
     *
     * @param key   the key with which the specified value is to be associated (may be null)
     * @param value the value to be associated with the specified key (may be null)
     * @return the previous value associated with the key, or null if there was no mapping
     */
    public V put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> head = buckets[index];

        // Check if key already exists and update value
        while (head != null) {
            if (Objects.equals(head.key, key)) {
                V oldValue = head.value;
                head.value = value;
                return oldValue;
            }
            head = head.next;
        }

        // Key doesn't exist, add new entry
        Entry<K, V> newNode = new Entry<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;

        // Check if resize is needed
        if ((1.0 * size) / capacity >= LOAD_FACTOR) {
            resize();
        }

        return null;
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned (may be null)
     * @return the value to which the specified key is mapped, or {@code null} if no mapping
     */
    public V get(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> head = buckets[index];

        while (head != null) {
            if (Objects.equals(head.key, key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key the key whose mapping is to be removed (may be null)
     * @return the previous value associated with the key,
     * or {@code null} if there was no mapping for the key
     */
    public V remove(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> head = buckets[index];
        Entry<K, V> prev = null;

        while (head != null) {
            if (Objects.equals(head.key, key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    buckets[index] = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    /**
     * Returns {@code true} if this map contains a mapping for the specified key.
     *
     * @param key the key whose presence in this map is to be tested (may be null)
     * @return {@code true} if this map contains a mapping for the key
     */
    public boolean containsKey(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> head = buckets[index];

        while (head != null) {
            if (Objects.equals(head.key, key)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * Returns {@code true} if this map contains one or more keys mapping to the specified value.
     *
     * @param value the value whose presence in this map is to be tested
     * @return {@code true} if this map maps one or more keys to the specified value
     */
    public boolean containsValue(V value) {
        for (int i = 0; i < capacity; i++) {
            Entry<K, V> head = buckets[i];
            while (head != null) {
                if (Objects.equals(head.value, value)) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this map contains no key-value mappings.
     *
     * @return {@code true} if this map contains no key-value mappings
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all the mappings from this map.
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        buckets = new Entry[capacity];
        size = 0;
    }

    /**
     * Doubles the capacity of the bucket array and rehashes all existing entries.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldBuckets = buckets;
        int oldCapacity = capacity;

        capacity *= 2;
        buckets = new Entry[capacity];
        int oldSize = size;
        size = 0;

        // Rehash all existing entries
        for (int i = 0; i < oldCapacity; i++) {
            Entry<K, V> head = oldBuckets[i];
            while (head != null) {
                Entry<K, V> next = head.next; // Save next before rehashing
                putDuringResize(head.key, head.value);
                head = next;
            }
        }

        // Verify size consistency
        assert size == oldSize : "Size mismatch during resize: expected " + oldSize + ", got " + size;
    }

    /**
     * Helper method to add entries during resize without triggering another resize.
     */
    private void putDuringResize(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> newNode = new Entry<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }

    /**
     * Returns a string representation of this map for debugging purposes.
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "{}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;

        for (int i = 0; i < capacity; i++) {
            Entry<K, V> head = buckets[i];
            while (head != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(head.key).append("=").append(head.value);
                first = false;
                head = head.next;
            }
        }

        sb.append("}");
        return sb.toString();
    }

    /**
     * Demonstrates usage of {@code MyHashMap}.
     */
    static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        System.out.println("Testing basic operations...");
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);
        map.put(null, 10);

        System.out.println("Map contents: " + map);
        System.out.println("Size: " + map.size()); // 4

        System.out.println("\nTesting get operations...");
        System.out.println("Get 'banana': " + map.get("banana")); // 2
        System.out.println("Get null key: " + map.get(null)); // 10
        System.out.println("Get non-existent key: " + map.get("grape")); // null

        System.out.println("\nTesting update...");
        Integer oldValue = map.put("apple", 4);
        System.out.println("Updated 'apple' from " + oldValue + " to " + map.get("apple")); // 1 to 4

        System.out.println("\nTesting null key update...");
        map.put(null, 5);
        System.out.println("Updated null key to: " + map.get(null)); // 5

        System.out.println("\nTesting containsKey...");
        System.out.println("Contains 'apple': " + map.containsKey("apple")); // true
        System.out.println("Contains 'grape': " + map.containsKey("grape")); // false
        System.out.println("Contains null: " + map.containsKey(null)); // true

        System.out.println("\nTesting containsValue...");
        System.out.println("Contains value 4: " + map.containsValue(4)); // true
        System.out.println("Contains value 100: " + map.containsValue(100)); // false

        System.out.println("\nTesting remove...");
        Integer removedValue = map.remove("banana");
        System.out.println("Removed 'banana', value was: " + removedValue); // 2
        System.out.println("Get 'banana' after removal: " + map.get("banana")); // null
        System.out.println("Size after removal: " + map.size()); // 3

        System.out.println("\nTesting resize by adding many elements...");
        for (int i = 0; i < 20; i++) {
            map.put("key" + i, i);
        }
        System.out.println("Size after adding 20 elements: " + map.size());

        System.out.println("\nTesting clear...");
        map.clear();
        System.out.println("Size after clear: " + map.size()); // 0
        System.out.println("Is empty: " + map.isEmpty()); // true
        System.out.println("Map contents after clear: " + map); // {}
    }
}