# 🧩 Dynamic Programming - Complete Study Guide

A comprehensive roadmap for mastering dynamic programming patterns and optimization techniques, organized by problem
types and difficulty progression.

## 📚 Table of Contents

- [Core Foundations](#core-foundations)
- [Linear DP Patterns](#linear-dp-patterns)
- [2D Grid & Matrix DP](#2d-grid--matrix-dp)
- [DSA.String & Subsequence DP](#string--subsequence-dp)
- [Tree & Interval DP](#tree--interval-dp)
- [Advanced DP Techniques](#advanced-dp-techniques)
- [FAANG Must-Master Problems](#faang-must-master-problems)

---

## 🏗️ Core Foundations

### Dynamic Programming Fundamentals

- **Optimal Substructure** - Optimal solution contains optimal subproblems
- **Overlapping Subproblems** - Same subproblems solved multiple times
- **Memoization vs Tabulation** - Top-down vs Bottom-up approaches
- **State Space Design** - Defining DP states and transitions

### Problem-Solving Framework

```
1. Identify if it's a DP problem:
   - Optimization (min/max/count)
   - Overlapping subproblems
   - Choices at each step

2. Define the state:
   - What parameters uniquely identify a subproblem?
   - What's the meaning of dp[i][j]?

3. Write recurrence relation:
   - How to compute current state from previous states?
   - What are the base cases?

4. Choose implementation:
   - Top-down (recursion + memoization)
   - Bottom-up (tabulation)
   - Space optimization possible?
```

### Implementation Approaches

```python
# Top-down (Memoization)
def dp_recursive(params):
    if base_case:
        return base_value
    if params in memo:
        return memo[params]
    
    result = recurrence_relation(params)
    memo[params] = result
    return result

# Bottom-up (Tabulation)
def dp_iterative():
    dp = [[0] * cols for _ in range(rows)]
    # Initialize base cases
    for i in range(rows):
        for j in range(cols):
            dp[i][j] = recurrence_relation(i, j)
    return dp[target_i][target_j]
```

---

## 📈 Linear DP Patterns

### Single Array DP

- **House Robber** - Non-adjacent selection optimization
- **Maximum Subarray (Kadane's)** - Contiguous subarray maximum
- **Best Time to Buy/Sell Stock** - Transaction optimization
- **Climbing Stairs** - Fibonacci-style counting
- **Decode Ways** - DSA.String parsing combinations

### Multiple DSA.Arrays/States

- **House Robber II** - Circular array constraint
- **Paint House** - Multi-state transitions
- **Best Time to Buy/Sell Stock with Cooldown** - State machine DP
- **Delete and Earn** - Transform to House Robber variant

### Advanced Linear DP

- **Maximum Product Subarray** - Handle negative numbers
- **Word Break** - DSA.String segmentation
- **Palindrome Partitioning II** - Minimum cuts
- **Jump Game** - Reachability analysis
- **Jump Game II** - Minimum jumps

### Pattern Recognition

```
Linear DP when:
- Processing array/string left to right
- Decision at each position affects future
- State depends on previous positions
- Often 1D or 2D state space
```

---

## 🎯 2D Grid & Matrix DP

### Path-Based Problems

- **Unique Paths** - Grid navigation counting
- **Unique Paths II** - With obstacles
- **Minimum Path Sum** - Cost optimization
- **Maximum Path Sum** - Triangle/grid variants
- **Cherry Pickup** - Multiple traversals

### Matrix Optimization

- **Maximal Rectangle** - Largest rectangle in binary matrix
- **Maximal Square** - Largest square submatrix
- **Range Sum Query 2D** - Prefix sum matrices
- **Count Square Submatrices** - All squares with 1s

### Dynamic Grid Problems

- **Dungeon Game** - Minimum initial health
- **Minimum Falling Path Sum** - Multiple descent paths
- **Pizza Cuts** - Geometric partitioning

### Implementation Pattern

```python
# Standard 2D DP template
def solve_grid_dp(grid):
    m, n = len(grid), len(grid[0])
    dp = [[0] * n for _ in range(m)]
    
    # Initialize first row/column
    for i in range(m):
        dp[i][0] = initialize_value(i, 0)
    for j in range(n):
        dp[0][j] = initialize_value(0, j)
    
    # Fill DP table
    for i in range(1, m):
        for j in range(1, n):
            dp[i][j] = recurrence(dp, i, j)
    
    return dp[m-1][n-1]
```

---

## 🔤 DSA.String & Subsequence DP

### Classic DSA.String Problems

- **Longest Common Subsequence (LCS)** - Two string matching
- **Longest Common Substring** - Contiguous matching
- **Edit Distance (Levenshtein)** - Minimum operations
- **Distinct Subsequences** - Count matching patterns
- **Shortest Common Supersequence** - Minimum containing string

### Advanced DSA.String DP

- **Regular Expression Matching** - Pattern with . and *
- **Wildcard Matching** - Pattern with ? and *
- **Interleaving DSA.String** - Two strings forming third
- **Scramble DSA.String** - Tree-based string transformation
- **Palindromic Substrings** - Count all palindromes

### Subsequence Variants

- **Longest Increasing Subsequence (LIS)** - O(n²) and O(n log n)
- **Longest Arithmetic Subsequence** - Arithmetic progression
- **Longest Palindromic Subsequence** - Palindrome from subsequence
- **Number of LIS** - Count of longest increasing subsequences

### DSA.String DP Patterns

```python
# Two string DP template
def string_dp(s1, s2):
    m, n = len(s1), len(s2)
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    
    # Base cases
    for i in range(m + 1):
        dp[i][0] = base_case_value(i)
    for j in range(n + 1):
        dp[0][j] = base_case_value(j)
    
    # Fill table
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s1[i-1] == s2[j-1]:
                dp[i][j] = dp[i-1][j-1] + match_value
            else:
                dp[i][j] = max/min(dp[i-1][j], dp[i][j-1]) + mismatch_cost
    
    return dp[m][n]
```

---

## 🌳 Tree & Interval DP

### Tree DP Problems

- **House Robber III** - Binary tree constraint
- **Binary Tree Maximum Path Sum** - Any node to any node
- **Diameter of Binary Tree** - Longest path through tree
- **Binary Tree Cameras** - Minimum surveillance coverage
- **Tree Distance Sum** - Sum of distances to all nodes

### Interval DP

- **Matrix Chain Multiplication** - Optimal parenthesization
- **Burst Balloons** - Optimal popping order
- **Palindrome Partitioning** - Minimum cuts for palindromes
- **Stone Game** - Optimal game strategy
- **Minimum Score Triangulation** - Polygon triangulation

### Advanced Tree DP

- **All Possible Full Binary Trees** - Generate all structures
- **Unique Binary Search Trees** - Catalan numbers
- **Binary Tree Coloring** - Constraint satisfaction

### Tree DP Template

```python
def tree_dp(node):
    if not node:
        return base_case
    
    # Process children first
    left_result = tree_dp(node.left)
    right_result = tree_dp(node.right)
    
    # Combine results with current node
    current_result = combine(node.val, left_result, right_result)
    
    # Update global answer if needed
    global_answer = update_global(current_result, global_answer)
    
    return current_result
```

---

## 🚀 Advanced DP Techniques

### State Machine DP

- **Best Time to Buy/Sell Stock** series - Transaction states
- **Paint House** - Color state transitions
- **Knight Dialer** - Position state transitions
- **Prison Cells After N Days** - Cycle detection in states

### Bitmasking DP

- **Traveling Salesman Problem** - Visit all cities
- **Number of Ways to Wear Different Hats** - Assignment problems
- **Shortest Superstring** - Overlap optimization
- **Fair Distribution of Cookies** - Subset partitioning

### Probability DP

- **Knight Probability in Chessboard** - Stay on board probability
- **Soup Servings** - Probability calculations
- **New 21 Game** - Game theory with probability

### Multi-dimensional DP

- **Profitable Schemes** - 3D optimization
- **Number of Dice Rolls** - 3D counting
- **Minimum Cost to Cut Stick** - Interval + cost optimization

### Optimization Techniques

```
Space Optimization:
- Rolling arrays for 2D DP
- Only keep necessary previous states
- O(n²) space → O(n) space

Time Optimization:
- Monotonic queue/stack for range queries
- Segment trees for dynamic updates
- Mathematical formulas (Catalan numbers)

State Compression:
- Bitmasks for subset states
- Coordinate compression for large ranges
- Hash maps for sparse state spaces
```

---

## 🎯 FAANG Must-Master Problems

### High-Priority (Master First)

| Problem                        | Companies                 | Pattern              | Difficulty |
|--------------------------------|---------------------------|----------------------|------------|
| **Climbing Stairs**            | Google, Amazon            | Linear DP, Fibonacci | Easy       |
| **House Robber**               | Amazon, Microsoft         | Linear DP, Selection | Medium     |
| **Maximum Subarray**           | Amazon, Google, Microsoft | Kadane's Algorithm   | Easy       |
| **Unique Paths**               | Google, Amazon            | 2D Grid DP           | Medium     |
| **Longest Common Subsequence** | Google, Microsoft         | DSA.String DP        | Medium     |
| **Coin Change**                | Amazon, Facebook          | Unbounded Knapsack   | Medium     |
| **Word Break**                 | Google, Amazon            | Linear DP, DSA.Trie  | Medium     |

### Medium-Priority

| Problem                            | Companies         | Pattern          | Difficulty |
|------------------------------------|-------------------|------------------|------------|
| **Edit Distance**                  | Google, Amazon    | DSA.String DP    | Hard       |
| **Longest Increasing Subsequence** | Microsoft, Amazon | Subsequence DP   | Medium     |
| **Minimum Path Sum**               | Amazon, Google    | 2D Grid DP       | Medium     |
| **Best Time to Buy/Sell Stock II** | Amazon, Google    | State Machine DP | Medium     |
| **Decode Ways**                    | Google, Facebook  | Linear DP        | Medium     |
| **Paint House**                    | Google, LinkedIn  | State Transition | Medium     |
| **Range Sum Query 2D**             | Amazon, Google    | Matrix DP        | Medium     |

### Advanced (Senior+ Levels)

| Problem                          | Companies         | Pattern        | Difficulty |
|----------------------------------|-------------------|----------------|------------|
| **Regular Expression Matching**  | Google, Facebook  | DSA.String DP  | Hard       |
| **Burst Balloons**               | Google, Amazon    | Interval DP    | Hard       |
| **Stone Game**                   | Amazon            | Game Theory DP | Medium     |
| **Cherry Pickup**                | Google            | Multi-path DP  | Hard       |
| **Binary Tree Maximum Path Sum** | Facebook, Amazon  | Tree DP        | Hard       |
| **Traveling Salesman**           | Google, Microsoft | Bitmask DP     | Hard       |

---

## 🧠 Pattern Recognition Guide

### Linear DP Indicators

- Array/string processing left to right
- Decision at each position
- Previous decisions affect current choice
- **Examples**: House Robber, Maximum Subarray, Climbing Stairs

### 2D DP Indicators

- Grid/matrix problems
- Two sequences comparison
- Two-parameter state space
- **Examples**: Unique Paths, LCS, Edit Distance

### Tree DP Indicators

- Binary tree problems
- Optimal choices at each node
- Combine child results
- **Examples**: Tree diameter, House Robber III

### Interval DP Indicators

- Range-based problems
- Optimal way to process interval
- Divide interval into subintervals
- **Examples**: Matrix Chain Multiplication, Burst Balloons

### State Machine DP Indicators

- Limited states at each step
- Transitions between states
- State affects available actions
- **Examples**: Stock problems with cooldown, Paint House

---

## 📖 Study Strategy

### Week 1: Foundations

1. **Master basic concepts** - Memoization vs tabulation
2. **Solve fundamental problems** - Fibonacci, climbing stairs
3. **Practice recurrence relations** - State definition and transitions
4. **Learn space optimization** - Rolling arrays technique

### Week 2: Linear & Grid DP

1. **Linear DP patterns** - House Robber series, Maximum Subarray
2. **2D Grid problems** - Unique Paths, Minimum Path Sum
3. **State space design** - Multi-dimensional thinking
4. **Optimization techniques** - Space and time improvements

### Week 3: DSA.String & Advanced Patterns

1. **DSA.String DP classics** - LCS, Edit Distance, Word Break
2. **Tree DP problems** - Path sums, tree optimization
3. **Interval DP** - Matrix Chain, Burst Balloons
4. **State machine DP** - Stock problems, Paint House

### Week 4: Advanced & Interview Prep

1. **Complex DP problems** - Regular expressions, game theory
2. **Optimization techniques** - Bitmask DP, probability DP
3. **Time all problems** - Build interview speed
4. **Pattern recognition** - Quick problem categorization

---

## 🔗 Quick Reference

### Time Complexities

| DP Type           | Typical Complexity | Space         | Examples           |
|-------------------|--------------------|---------------|--------------------|
| **Linear DP**     | O(n) to O(n²)      | O(n) to O(1)  | House Robber, LIS  |
| **2D Grid DP**    | O(mn)              | O(mn) to O(n) | Unique Paths, LCS  |
| **DSA.String DP** | O(mn)              | O(mn)         | Edit Distance, LCS |
| **Tree DP**       | O(n)               | O(h)          | Tree diameter      |
| **Interval DP**   | O(n³)              | O(n²)         | Matrix Chain       |
| **Bitmask DP**    | O(n × 2ⁿ)          | O(2ⁿ)         | TSP                |

### Common Base Cases

- **Empty input**: Often 0 or 1
- **Single element**: Usually the element itself
- **Impossible state**: -1 or infinity
- **Starting state**: Problem-specific initialization

### Optimization Checklist

✅ **Space optimization possible?** (rolling arrays)  
✅ **Mathematical formula exists?** (Catalan, Fibonacci)  
✅ **Bottom-up vs top-down?** (iterative vs recursive)  
✅ **State compression possible?** (bitmask, coordinate)

---

## 💡 Pro Tips for Interviews

### Problem Analysis

1. **Identify optimization target** - min/max/count
2. **Look for choices** - multiple options at each step
3. **Check for overlapping subproblems** - repeated calculations
4. **Define state clearly** - what does dp[i] represent?

### Implementation Strategy

1. **Start with brute force** - identify recursion
2. **Add memoization** - top-down approach
3. **Convert to tabulation** - bottom-up if needed
4. **Optimize space** - rolling arrays when possible

### Communication Tips

1. **Explain the intuition** - why DP is needed
2. **Walk through small examples** - show state transitions
3. **Discuss trade-offs** - time vs space complexity
4. **Mention optimizations** - space reduction techniques

### Common Pitfalls

❌ **Wrong state definition** - doesn't capture all info  
❌ **Missing base cases** - edge case handling  
❌ **Off-by-one errors** - array indexing mistakes  
❌ **Space inefficiency** - not optimizing when possible

---

## 🎯 Advanced Topics for Senior Roles

### System Design Integration

- **Caching strategies** - Where to apply memoization in systems
- **Distributed DP** - Parallel computation of independent states
- **Memory constraints** - External DP for large state spaces

### Mathematical Foundations

- **Catalan numbers** - Tree structures, parentheses
- **Fibonacci variants** - Linear recurrences
- **Probability theory** - Expected value calculations

### Algorithmic Variants

- **Online algorithms** - DP with streaming data
- **Approximation algorithms** - When exact DP is too slow
- **Randomized DP** - Monte Carlo methods

---