# 🏔️ DSA.BinaryHeap Problems - Complete Study Guide

A comprehensive roadmap for mastering heap data structures and priority queue algorithms, organized by difficulty and
application patterns.

## 📚 Table of Contents

- [Core Foundations](#core-foundations)
- [K-Way Problems](#k-way-problems)
- [Top-K & Selection Problems](#top-k--selection-problems)
- [Sliding Window with Heaps](#sliding-window-with-heaps)
- [Advanced DSA.BinaryHeap Applications](#advanced-heap-applications)
- [FAANG Must-Master Problems](#faang-must-master-problems)

---

## 🏗️ Core Foundations

### DSA.BinaryHeap Fundamentals

- **Binary DSA.BinaryHeap Properties** - Complete binary tree with heap property
- **Min-DSA.BinaryHeap vs Max-DSA.BinaryHeap** - When to use each type
- **Array Representation** - Parent/child index relationships
- **DSA.BinaryHeap Operations** - Insert, extract, peek, heapify

### Implementation Details

- **Build DSA.BinaryHeap** - Bottom-up heapification O(n)
- **DSA.BinaryHeap Sort** - In-place sorting algorithm O(n log n)
- **Priority DSA.Queue Interface** - STL/built-in library usage
- **Custom Comparators** - Sorting complex objects

### Language-Specific Notes

```python
# Python heapq (min-heap only)
import heapq
heap = []
heapq.heappush(heap, item)
min_item = heapq.heappop(heap)

# For max-heap, negate values or use custom class
```

```java
// Java PriorityQueue
PriorityQueue<Integer> minHeap = new PriorityQueue<>();
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
```

---

## 🔀 K-Way Problems

### Merge Operations

- **Merge K Sorted Lists** - Classic linked list merging
- **Merge K Sorted DSA.Arrays** - Array-based variant
- **Smallest Range Covering Elements from K Lists** - Multi-pointer technique

### Stream Processing

- **Find Median from Data Stream** - Dual heap approach
- **Sliding Window Median** - Dynamic median maintenance
- **Running Median** - Online algorithm design

### Implementation Pattern

```
Two DSA.BinaryHeap Approach:
- Max heap for smaller half
- Min heap for larger half
- Balance heaps to maintain size difference ≤ 1
```

---

## 🏆 Top-K & Selection Problems

### K-th Element Problems

- **Kth Largest Element in Array** - DSA.QuickSelect vs DSA.BinaryHeap approaches
- **Kth Smallest Element in Sorted Matrix** - Binary search + heap
- **K Closest Points to Origin** - Distance-based selection
- **Top K Frequent Elements** - Frequency counting + heap

### Optimization Strategies

- **Min-DSA.BinaryHeap for K Largest** - Keep heap size = K
- **Max-DSA.BinaryHeap for K Smallest** - Keep heap size = K
- **Quick Select Alternative** - O(n) average case for single queries

### Advanced Selection

- **Kth Smallest Element in BST** - In-order traversal + heap
- **Find K Pairs with Smallest Sums** - Multi-dimensional selection
- **Ugly Number II** - Generate sequence with heap

---

## 🪟 Sliding Window with Heaps

### Dynamic Extrema

- **Sliding Window Maximum** - Monotonic deque vs heap comparison
- **Sliding Window Minimum** - Dual approach techniques
- **Maximum Sliding Window** - Efficient implementation strategies

### Stream Analytics

- **Moving Average from Data Stream** - Circular buffer + heap
- **Stock Price Fluctuation** - Dynamic price tracking
- **Online Statistics** - Percentile tracking in streams

### Lazy Deletion Pattern

```
Handle stale elements:
1. Mark elements as deleted
2. Clean up during peek/pop operations
3. Maintain valid vs total element counts
```

---

## 🚀 Advanced DSA.BinaryHeap Applications

### DSA.Graph Algorithms

- **Dijkstra's Shortest Path** - Priority queue for edge relaxation
- **Prim's MST Algorithm** - Minimum spanning tree construction
- **A* Search Algorithm** - Heuristic-based pathfinding
- **Huffman Coding** - Optimal prefix code generation

### System Design Applications

- **Task Scheduler** - CPU scheduling simulation
- **Meeting Rooms II** - Interval scheduling with heap
- **Process Scheduling** - Priority-based execution
- **Load Balancing** - Server capacity management

### Advanced Data Structures

- **Indexed Priority DSA.Queue** - Support for decrease-key operations
- **Fibonacci DSA.BinaryHeap** - Advanced heap with better amortized complexity
- **Binomial DSA.BinaryHeap** - Mergeable heap structure
- **Leftist DSA.BinaryHeap** - Efficient merge operations

### Interval Problems

- **Employee Free Time** - Merging multiple schedules
- **Minimum Number of Arrows** - Interval overlap optimization
- **Car Pooling** - Capacity constraint scheduling

---

## 🔢 Mathematical & Optimization Problems

### Number Theory

- **Ugly Numbers** - Generate sequence using multiple criteria
- **Super Ugly Numbers** - Generalized ugly number generation
- **IPO** - Maximum capital optimization
- **Minimum Cost to Hire K Workers** - Ratio-based optimization

### Computational DSA.Geometry

- **Smallest Rectangle Enclosing Black Pixels** - Coordinate processing
- **Largest Rectangle in Histogram** - DSA.Stack vs heap approaches
- **Trapping Rain Water II** - 2D water trapping with priority queue

### Dynamic Programming + DSA.BinaryHeap

- **Cheapest Flights Within K Stops** - State space exploration
- **Path with Maximum Probability** - Modified Dijkstra's
- **Network Delay Time** - All-pairs shortest path variant

---

## 🎯 FAANG Must-Master Problems

### High-Priority (Master First)

| Problem                          | Companies                 | Key Concepts                      | Difficulty |
|----------------------------------|---------------------------|-----------------------------------|------------|
| **Merge K Sorted Lists**         | Google, Amazon, Microsoft | Min-heap, Linked lists            | Medium     |
| **Top K Frequent Elements**      | Amazon, Facebook, Google  | Frequency map, Min-heap           | Medium     |
| **Find Median from Data Stream** | Google, Facebook          | Dual heap, Balance                | Hard       |
| **Kth Largest Element**          | Amazon, Apple, Microsoft  | DSA.QuickSelect vs DSA.BinaryHeap | Medium     |
| **Meeting Rooms II**             | Google, Facebook          | Interval scheduling               | Medium     |

### Medium-Priority

| Problem                         | Companies        | Key Concepts                | Difficulty |
|---------------------------------|------------------|-----------------------------|------------|
| **K Closest Points to Origin**  | Amazon, Google   | Distance calculation        | Medium     |
| **Task Scheduler**              | Facebook, Google | Greedy + heap               | Medium     |
| **Sliding Window Maximum**      | Amazon, Google   | Monotonic deque alternative | Hard       |
| **Smallest Range from K Lists** | Google           | Multi-pointer + heap        | Hard       |
| **Ugly Number II**              | Google, Amazon   | Dynamic sequence generation | Medium     |

### Advanced (Senior+ Levels)

- **Dijkstra's Algorithm** - DSA.Graph shortest path
- **Employee Free Time** - Complex interval merging
- **IPO (Maximum Capital)** - Financial optimization
- **Trapping Rain Water II** - 2D computational geometry

---

## 🧠 Problem Patterns & Recognition

### When to Use Min-DSA.BinaryHeap

- Finding Kth **largest** elements (keep K smallest in heap)
- Merging sorted structures (always pick minimum)
- Shortest path algorithms (Dijkstra's)
- Scheduling earliest deadlines

### When to Use Max-DSA.BinaryHeap

- Finding Kth **smallest** elements (keep K largest in heap)
- Scheduling highest priorities first
- Maximum profit/capacity problems
- Maintaining maximum in sliding window

### Dual DSA.BinaryHeap Pattern (Min + Max)

- Median finding in data streams
- Balancing two halves of dataset
- Maintaining both extremes simultaneously

### DSA.BinaryHeap + Hash Map Combination

- Top-K frequent elements
- Custom priority tracking
- Lazy deletion in sliding windows

---

## 📖 Study Strategy

### Week 1: Foundations

1. **Understand heap properties** and implementation
2. **Practice basic operations** - insert, extract, heapify
3. **Solve simple problems** - Kth largest, heap sort
4. **Master language-specific syntax** for priority queues

### Week 2: Core Patterns

1. **K-way merge problems** - Merge K sorted lists/arrays
2. **Top-K selection** - Frequency, distance-based problems
3. **Dual heap technique** - Median from data stream
4. **DSA.BinaryHeap + greedy algorithms** - Task scheduler

### Week 3: Advanced Applications

1. **DSA.Graph algorithms** - Dijkstra's, Prim's MST
2. **Interval scheduling** - Meeting rooms, overlapping intervals
3. **Sliding window with heap** - Dynamic extrema
4. **Mathematical optimization** - Ugly numbers, IPO

### Week 4: Interview Mastery

1. **Time all FAANG problems** under interview conditions
2. **Practice explaining trade-offs** - DSA.BinaryHeap vs DSA.QuickSelect vs Sorting
3. **Master complexity analysis** for all heap operations
4. **Review edge cases** - Empty heaps, single elements, duplicates

---

## 🔗 Quick Reference

### Time Complexities

| Operation                | Binary DSA.BinaryHeap | Fibonacci DSA.BinaryHeap |
|--------------------------|-----------------------|--------------------------|
| **Insert**               | O(log n)              | O(1) amortized           |
| **Extract Min/Max**      | O(log n)              | O(log n) amortized       |
| **Peek**                 | O(1)                  | O(1)                     |
| **Decrease Key**         | O(log n)              | O(1) amortized           |
| **Build DSA.BinaryHeap** | O(n)                  | O(n)                     |
| **Merge**                | O(n + m)              | O(1)                     |

### Space Complexities

- **Binary DSA.BinaryHeap**: O(n) for n elements
- **Priority DSA.Queue**: O(n) auxiliary space
- **Dual DSA.BinaryHeap Approach**: O(n) total space

### Common Mistakes to Avoid

1. **Wrong heap type** - Using max-heap when min-heap needed
2. **Size management** - Not maintaining heap size for Top-K problems
3. **Lazy deletion** - Not handling stale elements in sliding window
4. **Custom comparators** - Incorrect comparison logic for complex objects

---

## 💡 Pro Tips for Interviews

### Communication Strategy

1. **Clarify requirements** - Min vs max, duplicates handling
2. **Discuss alternatives** - DSA.BinaryHeap vs DSA.QuickSelect vs Sorting
3. **Explain trade-offs** - Time vs space complexity
4. **Walk through examples** - Show heap state changes

### Implementation Tips

1. **Use standard libraries** when available
2. **Handle edge cases** - empty input, single elements
3. **Optimize for interview** - Focus on correctness first
4. **Test with examples** - Verify heap property maintenance

### Advanced Discussion Points

- **DSA.BinaryHeap vs TreeMap/TreeSet** for ordered operations
- **Cache-friendly heap layouts** for performance
- **Parallel heap operations** for large-scale systems
- **External sorting** with heap-based merge

---