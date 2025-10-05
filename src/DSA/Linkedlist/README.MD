# 🔗 Linked List Problems

A comprehensive guide to mastering linked list operations, algorithms, and interview problems. From basic operations to
advanced applications, this roadmap covers everything you need for technical interviews.

## 📋 Table of Contents

- [Core Linked List Operations](#core-linked-list-operations)
- [Reversal Techniques](#reversal-techniques)
- [Two-Pointer Problems](#two-pointer-problems)
- [Sorting & Merging](#sorting--merging)
- [Modification Problems](#modification-problems)
- [Palindrome & Pattern Problems](#palindrome--pattern-problems)
- [Advanced Applications](#advanced-applications)
- [Must-Do Problems for Top Companies](#must-do-problems-for-top-companies)

---

## 🔧 Core Linked List Operations

Master the fundamental operations that form the foundation of all linked list algorithms.

### Basic Implementation

- **Implement a Singly Linked List from Scratch**
- **Node Structure & Memory Management**
- **Basic Operations Setup**

### Insertion Operations

- **Insert at Head** (O(1) complexity)
- **Insert at Tail** (O(n) without tail pointer, O(1) with tail pointer)
- **Insert at Middle** (insert at specific position)

### Deletion Operations

- **Delete Node by Value**
- **Delete Node by Position**
- **Delete Head/Tail Nodes**

### Utility Operations

- **Find Length of Linked List**
- **Search for Element**
- **Display/Print List**

---

## 🔄 Reversal Techniques

Essential reversal patterns that appear frequently in interviews and real applications.

- **Iterative Reversal** (Classic 3-pointer approach)
- **Recursive Reversal** (Understanding the call stack)
- **Reverse First K Nodes** (Partial reversal)
- **Reverse Between M and N** (Sublist reversal)

### 🎯 Key Pattern: Three-Pointer Technique

```
prev → current → next
```

---

## 👥 Two-Pointer Problems

Leverage the power of multiple pointers to solve complex problems efficiently.

### Fast & Slow Pointer (Tortoise & Hare)

- **Find Middle Node** (Floyd's cycle-finding algorithm application)
- **Find Nth Node from End** (Two-pass vs one-pass solutions)
- **Check if Length is Even or Odd**

### Cycle Detection & Analysis

- **Cycle Detection** (Floyd's algorithm)
- **Find Start of Cycle** (Mathematical approach)
- **Intersection of Two Linked Lists** (Two-pointer convergence)

### Specialized Two-Pointer Applications

- **Remove Nth Node from End** (One-pass solution)

---

## 📊 Sorting & Merging

Transform and combine linked lists using various sorting and merging strategies.

### Merging Techniques

- **Merge Two Sorted Linked Lists** (Two-pointer merging)
- **Merge K Sorted Lists**
    - DSA.BinaryHeap-based approach (O(n log k))
    - Divide & Conquer approach
    - Sequential merging

### Sorting Algorithms

- **Sort a Linked List** (Merge sort - most efficient for linked lists)
- **Insertion Sort on Linked List** (In-place sorting)

---

## ⚙️ Modification Problems

Transform linked list structure while preserving or reorganizing data.

### Duplicate Removal

- **Remove Duplicates from Sorted List**
- **Remove Duplicates from Unsorted List** (Hash set approach)

### Structural Modifications

- **Partition List** (Around a pivot value x)
- **Rotate List** (K positions to the right/left)
- **Reorder List** (L₀ → Lₙ → L₁ → Lₙ₋₁ → L₂ → Lₙ₋₂ ...)

---

## 🔍 Palindrome & Pattern Problems

Analyze and manipulate linked lists based on mathematical and pattern-based operations.

### Pattern Recognition

- **Check Palindrome Linked List** (Multiple approaches)
    - Reverse second half
    - DSA.Stack-based comparison
    - Recursive approach

### Mathematical Operations

- **Add Two Numbers** (Linked list representation of integers)
- **Multiply Two Linked Lists** (Mathematical operations on lists)

---

## 🚀 Advanced Applications

Complex problems that combine multiple concepts and real-world applications.

### Multi-Level Structures

- **Flatten a Multilevel Doubly Linked List** (DFS approach)
- **Skip List Basics** (Probabilistic data structure)

### Memory & Reference Management

- **Copy List with Random Pointer** (Deep copy with random references)

### Data Structure Design

- **LRU Cache** (Linked List + DSA.HashMap combination)
    - O(1) get and put operations
    - Doubly linked list implementation
    - Hash map for O(1) access

---

## ✅ Must-Do Problems for Top Companies

**Critical problems for Amazon / Microsoft / Google interviews:**

| Problem                      | Difficulty  | Pattern             | Priority |
|------------------------------|-------------|---------------------|----------|
| **Reverse Linked List**      | Easy        | Iterative/Recursive | 🔥🔥🔥   |
| **Cycle Detection + Start**  | Medium      | Two Pointer         | 🔥🔥🔥   |
| **Merge Two Sorted Lists**   | Easy        | Two Pointer         | 🔥🔥🔥   |
| **Remove Nth Node from End** | Medium      | Two Pointer         | 🔥🔥🔥   |
| **Reorder List**             | Medium      | Multiple Techniques | 🔥🔥     |
| **Palindrome Check**         | Easy-Medium | Reverse/DSA.Stack       | 🔥🔥     |
| **Add Two Numbers**          | Medium      | Mathematical        | 🔥🔥     |
| **Copy with Random Pointer** | Medium      | Deep Copy           | 🔥🔥     |

### 🎯 Interview Focus Areas

#### **Amazon Favorites**

1. Merge K Sorted Lists
2. LRU Cache Implementation
3. Copy List with Random Pointer
4. Reverse Nodes in K-Group

#### **Microsoft Preferences**

1. Intersection of Two Linked Lists
2. Palindrome Linked List
3. Remove Duplicates from Sorted List
4. Partition List

#### **Google Essentials**

1. Add Two Numbers
2. Reorder List
3. Flatten Multilevel Doubly Linked List
4. Sort List (Merge Sort)

---

## 💡 Study Strategy

### Phase 1: Foundation (Week 1)

1. **Basic Operations**: Implement from scratch
2. **Simple Traversal**: Length, search, display
3. **Basic Insertion/Deletion**: All positions

### Phase 2: Core Techniques (Week 2)

1. **Reversal Mastery**: All reversal variations
2. **Two-Pointer Introduction**: Fast/slow pointer
3. **Simple Merging**: Two sorted lists

### Phase 3: Pattern Recognition (Week 3)

1. **Cycle Problems**: Detection and analysis
2. **Advanced Two-Pointer**: Nth from end, intersection
3. **Modification Patterns**: Partition, rotate, reorder

### Phase 4: Advanced Applications (Week 4+)

1. **Complex Merging**: K sorted lists
2. **Design Problems**: LRU Cache
3. **Advanced Structures**: Random pointer, multilevel

---

## 🎯 Key Patterns to Master

### 🔄 Reversal Patterns

- **Three-Pointer Technique**: `prev`, `current`, `next`
- **Recursive Thinking**: Base case and recursive step
- **Partial Reversal**: Reverse specific sections

### 👥 Two-Pointer Patterns

- **Fast & Slow**: Different speeds for cycle detection
- **Leading & Trailing**: Fixed distance for nth from end
- **Convergence**: Meeting point for intersection problems

### 🔗 Merging Patterns

- **Dummy Head**: Simplify edge cases
- **Priority DSA.Queue**: For K-way merge
- **Divide & Conquer**: Optimal for large datasets

### 🏗️ Modification Patterns

- **In-Place Operations**: Minimize space complexity
- **Multiple Passes**: Break complex problems into steps
- **State Tracking**: Remember positions and values

---

## ⚡ Quick Reference

### Time Complexities

- **Traversal**: O(n)
- **Search**: O(n)
- **Insert/Delete at Head**: O(1)
- **Insert/Delete at Tail**: O(n) without tail pointer
- **Reverse**: O(n)
- **Merge Two Lists**: O(m + n)
- **Sort**: O(n log n) with merge sort

### Space Complexities

- **Iterative Operations**: O(1)
- **Recursive Operations**: O(n) due to call stack
- **Merge K Lists (DSA.BinaryHeap)**: O(k)
- **Hash-based Solutions**: O(n)

### Common Edge Cases

- **Empty List**: `head == null`
- **Single Node**: `head.next == null`
- **Two Nodes**: Minimum for meaningful operations
- **Cycle Present**: Infinite loops possible
- **Duplicate Values**: May need special handling

---

## 🛠️ Essential Techniques

1. **Dummy Head Usage**: Simplifies insertion/deletion logic
2. **Two-Pointer Mastery**: Solve in single pass
3. **Iterative vs Recursive**: Know when to use each
4. **Edge Case Handling**: Always consider null and single node
5. **Space Optimization**: Prefer O(1) space when possible

---

## 📚 Practice Resources

- **LeetCode**: 100+ linked list problems
- **HackerRank**: Structured learning path
- **GeeksforGeeks**: Detailed explanations and variations
- **Cracking the Coding Interview**: Chapter 2 - Linked Lists

### 🎲 Practice Strategy

1. **Daily Practice**: 2-3 problems per day
2. **Pattern Focus**: Group similar problems
3. **Time Limits**: Simulate interview conditions
4. **Code Reviews**: Optimize for clarity and efficiency
5. **Explain Aloud**: Practice articulating your approach

---

## 🏆 Pro Tips for Interviews

1. **Draw It Out**: Always sketch the linked list
2. **Handle Nulls**: Check for null pointers first
3. **Dummy Nodes**: Use them to simplify logic
4. **Test Edge Cases**: Empty list, single node, cycles
5. **Optimize Space**: Prefer in-place solutions when possible
6. **Explain Trade-offs**: Discuss time vs space complexity

---

*Master these patterns and linked lists will become your strength! 🔗✨*