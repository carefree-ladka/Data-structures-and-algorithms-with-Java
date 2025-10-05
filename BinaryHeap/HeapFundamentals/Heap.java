package DSA.BinaryHeap.HeapFundamentals;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Generic Heap class that mimics PriorityQueue behavior using a Comparator.
 *
 * @param <T> Type of elements stored in the heap
 */
public class Heap<T> implements Iterable<T> {
    private final List<T> data;
    private final Comparator<T> comparator;

    /**
     * Constructs a Heap with the given comparator.
     *
     * @param comparator Comparator to define heap order (min-heap or max-heap)
     */
    public Heap(Comparator<T> comparator) {
        this.data = new ArrayList<>();
        this.comparator = comparator;
    }

    /**
     * Returns the number of elements in the heap.
     */
    public int size() {
        return data.size();
    }

    /**
     * Returns true if the heap is empty.
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Returns the top-priority element without removing it.
     */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return data.get(0);
    }

    /**
     * Inserts an element into the heap (alias for offer).
     */
    public void add(T value) {
        offer(value);
    }

    /**
     * Inserts an element into the heap.
     */
    public void offer(T value) {
        data.add(value);
        heapifyUp(data.size() - 1);
    }

    /**
     * Removes and returns the top-priority element.
     */
    public T poll() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");

        T top = data.get(0);
        T last = data.remove(data.size() - 1);

        if (!isEmpty()) {
            data.set(0, last);
            heapifyDown(0);
        }

        return top;
    }

    /**
     * Removes a specific element from the heap.
     *
     * @param value element to remove
     * @return true if the element was found and removed
     */
    public boolean remove(T value) {
        int index = data.indexOf(value);
        if (index == -1) return false;

        T last = data.remove(data.size() - 1);
        if (index < data.size()) {
            data.set(index, last);
            heapifyDown(index);
            heapifyUp(index);
        }
        return true;
    }

    /**
     * Checks if the heap contains a specific element.
     */
    public boolean contains(T value) {
        return data.contains(value);
    }

    /**
     * Removes all elements from the heap.
     */
    public void clear() {
        data.clear();
    }

    /**
     * Heapify up after insertion
     */
    private void heapifyUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (comparator.compare(data.get(index), data.get(parent)) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    /**
     * Heapify down after removal
     */
    private void heapifyDown(int index) {
        int size = data.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int best = index;

            if (left < size && comparator.compare(data.get(left), data.get(best)) < 0) {
                best = left;
            }
            if (right < size && comparator.compare(data.get(right), data.get(best)) < 0) {
                best = right;
            }

            if (best == index) break;
            swap(index, best);
            index = best;
        }
    }

    /**
     * Swap two elements
     */
    private void swap(int i, int j) {
        T temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    /**
     * Iterator over elements in heap order (not sorted order).
     */
    @Override
    public @NotNull Iterator<T> iterator() {
        return data.iterator();
    }

    /**
     * Example usage
     */
    public static void main(String[] args) {
        Heap<Integer> minPQ = new Heap<Integer>(Comparator.naturalOrder());
        minPQ.offer(5);
        minPQ.offer(3);
        minPQ.offer(8);
        minPQ.offer(1);

        System.out.println("Min-PriorityQueue:");
        System.out.println("Contains 3? " + minPQ.contains(3));
        minPQ.remove(3);

        while (!minPQ.isEmpty()) {
            System.out.println(minPQ.poll());
        }

        Heap<Integer> maxPQ = new Heap<Integer>(Comparator.reverseOrder());
        maxPQ.offer(5);
        maxPQ.offer(3);
        maxPQ.offer(8);
        maxPQ.offer(1);

        System.out.println("\nMax-PriorityQueue:");
        while (!maxPQ.isEmpty()) {
            System.out.println(maxPQ.poll());
        }
    }
}
