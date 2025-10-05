package DSA.Linkedlist.AdvancedApplications;

import java.util.HashMap;

class LRUCache<K, V> {

    private final int capacity;
    private final HashMap<K, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(null, null); // dummy head
        tail = new Node(null, null); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Get value by key
    public V get(K key) {
        Node node = map.get(key);
        if (node == null) return null;
        moveToHead(node);
        return node.value;
    }

    // Put key-value
    public void put(K key, V value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            if (map.size() >= capacity) {
                // Remove LRU
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            addToHead(newNode);
            map.put(key, newNode);
        }
    }

    // Remove node from DLL
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Add node to the head of DLL
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Move node to head (mark as most recently used)
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // Debug: Print current cache state
    public void printCache() {
        Node curr = head.next;
        while (curr != tail) {
            System.out.print("[" + curr.key + ":" + curr.value + "] ");
            curr = curr.next;
        }
        System.out.println();
    }

    private class Node {
        K key;
        V value;
        Node prev, next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.printCache(); // [3:Three] [2:Two] [1:One]

        cache.get(2);
        cache.printCache(); // [2:Two] [3:Three] [1:One]

        cache.put(4, "Four");
        cache.printCache(); // [4:Four] [2:Two] [3:Three] (1 evicted)
    }
}
