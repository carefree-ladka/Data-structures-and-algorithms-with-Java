# 🌐 DSA.Graph Problems - Complete Study Guide

A comprehensive roadmap for mastering graph algorithms and data structures, organized by difficulty and concept
category.

## 📚 Table of Contents

- [Core Foundations](#core-foundations)
- [Cycle Detection & Topological Sort](#cycle-detection--topological-sort)
- [Shortest Path Algorithms](#shortest-path-algorithms)
- [Spanning Trees](#spanning-trees)
- [Advanced DSA.Graph Theory](#advanced-graph-theory)
- [FAANG Must-Master Problems](#faang-must-master-problems)

---

## 🏗️ Core Foundations

### DSA.Graph Representations

- **Adjacency List vs Matrix** - Space/time tradeoffs and when to use each
- **Weighted vs Unweighted** - Edge representation strategies
- **Directed vs Undirected** - Implementation differences

### Essential Traversals

- **Depth First Search (DFS)** - Recursive and iterative approaches
- **Breadth First Search (BFS)** - Level-order traversal with queue
- **Connected Components** - Finding disconnected graph parts
- **Clone DSA.Graph** - Deep copying with visited tracking

### Grid-Based Problems

- **Number of Islands** - Classic 2D DFS/BFS application
- **Count Distinct Islands** - Shape recognition with canonical forms
- **Pacific Atlantic Water Flow** - Multi-source traversal
- **Word Search II** - DFS + DSA.Trie optimization

---

## 🔄 Cycle Detection & Topological Sort

### Cycle Detection Techniques

- **Undirected Graphs**
    - DFS with parent tracking
    - Union-Find approach
- **Directed Graphs**
    - DFS with recursion stack (3-color method)
    - White → Gray → Black state tracking

### Topological Ordering

- **Kahn's Algorithm** - BFS-based with in-degree counting
- **DFS-Based Topological Sort** - Post-order traversal
- **Course Schedule I & II** - Dependency resolution
- **Alien Dictionary** - Custom ordering from examples
- **Minimum Height Trees** - Finding graph centers

---

## 🛣️ Shortest Path Algorithms

### Single-Source Shortest Path

- **BFS for Unweighted Graphs** - O(V + E) optimal solution
- **Dijkstra's Algorithm** - Non-negative weights with priority queue
- **Bellman-Ford Algorithm** - Handles negative weights, detects negative cycles

### Specialized Shortest Path

- **Network Delay Time** - Single-source to all nodes
- **Cheapest Flights Within K Stops** - Constrained path finding
- **Word Ladder** - Shortest transformation sequence

### All-Pairs Shortest Path

- **Floyd-Warshall Algorithm** - Dynamic programming approach O(V³)

---

## 🌳 Spanning Trees

### Minimum Spanning Tree (MST)

- **Kruskal's Algorithm**
    - Union-Find data structure
    - Edge-based greedy approach
- **Prim's Algorithm**
    - Vertex-based greedy with priority queue
    - Better for dense graphs

### Applications

- **Connecting Cities with Minimum Cost**
- **Network Infrastructure Design**

---

## 🚀 Advanced DSA.Graph Theory

### Strong Connectivity

- **Strongly Connected Components (SCCs)**
    - Kosaraju's Algorithm - Two-pass DFS
    - Tarjan's Algorithm - Single-pass with low-link values
- **Critical Connections (Bridges)** - Tarjan's bridge-finding algorithm
- **Articulation Points** - Vertices whose removal disconnects graph

### Specialized Algorithms

- **Bipartite DSA.Graph Detection** - 2-coloring with BFS/DFS
- **DSA.Graph Coloring** - Minimum colors needed
- **Eulerian Path & Circuit** - Traversing every edge exactly once
- **Hamiltonian Path** - Visiting every vertex exactly once

### Flow Networks

- **Maximum Flow** - Ford-Fulkerson method
- **Minimum Cut** - Max-flow min-cut theorem
- **Edmonds-Karp** - BFS-based Ford-Fulkerson implementation

### Advanced Data Structures

- **Disjoint Set Union (DSU)**
    - Path compression optimization
    - Union by rank/size
    - Applications in dynamic connectivity

---

## 🎯 FAANG Must-Master Problems

### High-Priority (Master First)

| Problem                    | Companies                 | Key Concepts                      |
|----------------------------|---------------------------|-----------------------------------|
| **Clone DSA.Graph**            | Google, Facebook, Amazon  | DFS/BFS, Hash mapping             |
| **Number of Islands**      | All FAANG                 | 2D DFS/BFS, Grid traversal        |
| **Course Schedule I & II** | Google, Amazon, Microsoft | Topological sort, Cycle detection |
| **Word Ladder**            | Facebook, Google          | BFS, Shortest path                |
| **Network Delay Time**     | Amazon, Google            | Dijkstra's algorithm              |

### Medium-Priority

| Problem                            | Companies         | Key Concepts          |
|------------------------------------|-------------------|-----------------------|
| **Detect Cycle in Directed DSA.Graph** | Microsoft, Amazon | DFS, Recursion stack  |
| **Topological Sort**               | Google, Amazon    | Kahn's algorithm, DFS |
| **Minimum Spanning Tree**          | Microsoft, Google | Kruskal's, Prim's     |
| **Critical Connections**           | Amazon, Facebook  | Tarjan's algorithm    |

### Advanced (Senior+ Levels)

- **Strongly Connected Components** - System design, dependency analysis
- **Maximum Flow Problems** - Network optimization
- **DSA.Graph Coloring** - Resource allocation problems

---

## 📖 Study Strategy

### Week 1-2: Foundations

1. Master DFS and BFS implementations
2. Solve basic connectivity problems
3. Practice grid-based traversals

### Week 3-4: Intermediate Concepts

1. Learn cycle detection techniques
2. Implement topological sorting
3. Study shortest path algorithms

### Week 5-6: Advanced Topics

1. MST algorithms and applications
2. Strong connectivity components
3. Specialized graph problems

### Week 7+: Interview Preparation

1. Time all FAANG must-do problems
2. Practice explaining algorithms clearly
3. Review complexity analysis

---

## 🔗 Quick Reference

### Time Complexities

- **DFS/BFS**: O(V + E)
- **Dijkstra's**: O((V + E) log V) with binary heap
- **Floyd-Warshall**: O(V³)
- **Union-Find**: O(α(n)) amortized per operation

### Space Complexities

- **Adjacency List**: O(V + E)
- **Adjacency Matrix**: O(V²)
- **DFS**: O(V) recursion stack
- **BFS**: O(V) queue space

---