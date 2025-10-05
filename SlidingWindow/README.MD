# 🪟 Sliding Window Patterns

Master the sliding window technique with this comprehensive guide covering everything from fundamental implementations
to advanced optimization problems. Your complete roadmap to conquering sliding window problems in technical interviews.

## 📋 Table of Contents

- [Core Sliding Window Concepts](#core-sliding-window-concepts)
- [Fixed Window Problems](#fixed-window-problems)
- [Variable Window Problems](#variable-window-problems)
- [Advanced Sliding Window Techniques](#advanced-sliding-window-techniques)
- [Sliding Window + Data Structures](#sliding-window--data-structures)
- [Must-Do Problems for Top Companies](#must-do-problems-for-top-companies)

---

## 🎯 Core Sliding Window Concepts

Master the fundamental sliding window techniques that transform O(n²) brute force solutions into efficient O(n)
algorithms.

### 🔑 Key Principles

**The sliding window technique** reduces complexity by:

- **Avoiding recomputation** of overlapping subarrays/substrings
- **Reusing results** from previous window positions
- **Maintaining state** efficiently as window slides

### Essential Patterns

- **Expand-Contract Strategy** (Two-pointer approach)
- **Condition-Based Window Management** (Sum, count, distinct elements)
- **State Tracking** (Hash maps, frequency arrays, running totals)

### Window Movement Strategies

- **Fixed Size Windows** (Slide by exactly 1 position)
- **Expandable Windows** (Grow until condition violated)
- **Shrinkable Windows** (Contract to maintain validity)

---

## 🔧 Fixed Window Problems

Problems where the window size remains constant throughout the sliding process.

### Sum & Average Problems

- **Maximum Sum Subarray of Size K** (Classic fixed window)
- **Maximum Average Subarray I** (Average calculation optimization)
- **Minimum Sum Subarray of Size K** (Minimum finding variant)

### DSA.String Pattern Problems

- **Maximum Number of Vowels in Substring of Given Length** (Character counting)
- **Contains Duplicate II** (Distance-based duplicate detection)
- **Fixed Window Anagram Detection** (Pattern matching)

### Array Statistics

- **Sliding Window Maximum** (Deque optimization required)
- **Sliding Window Median** (Order statistics)
- **First Negative Number in Every Window of Size K** (Negative tracking)

---

## 📊 Variable Window Problems

Advanced problems where window size changes dynamically based on conditions.

### Longest Substring Problems

- **Longest Substring Without Repeating Characters** (Classic variable window)
- **Longest Substring with At Most K Distinct Characters** (Character diversity)
- **Longest Repeating Character Replacement** (Character replacement optimization)

### Minimum Window Problems

- **Minimum Window Substring** (Pattern covering minimization)
- **Smallest Subarray with Sum ≥ Target** (Sum threshold optimization)
- **Minimum Size Subarray Sum** (Size minimization)

### Counting & Frequency Problems

- **Subarrays with K Different Integers** (Exact count matching)
- **Number of Substrings Containing All Three Characters** (Complete coverage)
- **Count Number of Nice Subarrays** (Odd number counting)

---

## 🏗️ Advanced Sliding Window Techniques

Complex problems requiring sophisticated window management and optimization strategies.

### Multi-Condition Windows

- **Longest Substring with At Most 2 Distinct Characters** (Character limit)
- **Max Consecutive Ones III** (Flip optimization)
- **Replace the Substring for Balanced DSA.String** (Balance maintenance)

### Mathematical Optimization

- **Maximum Points You Can Obtain from Cards** (Endpoint selection)
- **Grumpy Bookstore Owner** (State modification)
- **Diet Plan Performance** (Health score optimization)

### Advanced DSA.String Processing

- **Permutation in DSA.String** (Anagram detection in sliding fashion)
- **Find All Anagrams in a DSA.String** (Multiple anagram detection)
- **Longest Turbulent Subarray** (Pattern-based window)

---

## 🚀 Sliding Window + Data Structures

Challenging problems integrating sliding window with advanced data structures.

### Deque-Based Optimization

- **Sliding Window Maximum** (Monotonic deque)
- **Constrained Subsequence Sum** (Dynamic programming + deque)
- **Shortest Subarray with Sum at Least K** (Prefix sum + deque)

### Hash Map Integration

- **Minimum Window Substring** (Character frequency tracking)
- **Longest Substring with At Most K Distinct Characters** (Distinct counting)
- **Subarrays with K Different Integers** (Exact count optimization)

### Advanced Data Structure Problems

- **Count of Smaller Numbers After Self** (Sliding window + Fenwick tree)
- **Range Sum Query - Mutable** (Segment tree + sliding concepts)
- **Maximum Sum of Rectangle No Larger Than K** (2D sliding window)

---

## ✅ Must-Do Problems for Top Companies

**Critical problems for Amazon / Microsoft / Google interviews:**

| Problem                                            | Difficulty | Pattern         | Interview Frequency | Priority |
|----------------------------------------------------|------------|-----------------|---------------------|----------|
| **Longest Substring Without Repeating Characters** | Medium     | Variable Window | Very High           | 🔥🔥🔥   |
| **Minimum Window Substring**                       | Hard       | Variable Window | Very High           | 🔥🔥🔥   |
| **Sliding Window Maximum**                         | Hard       | Fixed + Deque   | High                | 🔥🔥🔥   |
| **Maximum Sum Subarray of Size K**                 | Easy       | Fixed Window    | High                | 🔥🔥🔥   |
| **Longest Repeating Character Replacement**        | Medium     | Variable Window | High                | 🔥🔥     |
| **Subarrays with K Different Integers**            | Hard       | Variable Window | Medium              | 🔥🔥     |
| **Max Consecutive Ones III**                       | Medium     | Variable Window | High                | 🔥🔥     |
| **Smallest Subarray with Sum ≥ Target**            | Medium     | Variable Window | Medium              | 🔥🔥     |

### 🎯 Company-Specific Focus

#### **Amazon Essentials**

1. Longest Substring Without Repeating Characters
2. Minimum Window Substring
3. Maximum Sum Subarray of Size K
4. Sliding Window Maximum

#### **Microsoft Favorites**

1. Longest Repeating Character Replacement
2. Max Consecutive Ones III
3. Minimum Window Substring
4. Subarrays with K Different Integers

#### **Google Preferences**

1. Sliding Window Maximum
2. Minimum Window Substring
3. Longest Substring with At Most K Distinct Characters
4. Maximum Points from Cards

---

## 💡 Mastery Strategy

### Phase 1: Foundation (Week 1)

1. **Template Mastery**: Perfect fixed and variable window templates
2. **Core Concepts**: Understand expand-contract strategy
3. **Basic Problems**: Maximum sum, longest without repeating

### Phase 2: Pattern Recognition (Week 2)

1. **Fixed Window**: Master all constant-size problems
2. **Variable Window**: Condition-based expansion/contraction
3. **State Management**: Hash maps and frequency tracking

### Phase 3: Advanced Applications (Week 3)

1. **Multi-Condition Windows**: Complex constraint handling
2. **DSA.String Processing**: Anagram and pattern problems
3. **Optimization Problems**: Minimum/maximum finding

### Phase 4: Expert Level (Week 4+)

1. **Hard Problems**: Minimum window, sliding maximum
2. **Data Structure Integration**: Deques, segment trees
3. **Competition Problems**: Advanced optimization challenges

---

## 🎯 Key Patterns to Master

### 🪟 Window Types

- **Fixed Size Window**: Constant k elements
- **Expandable Window**: Grow until condition breaks
- **Shrinkable Window**: Contract to maintain validity
- **Hybrid Window**: Combine expansion and contraction

### 🎲 Template Variations

- **Fixed Window Template**: Slide by 1, maintain size k
- **Two Pointer Template**: left/right pointers manage window
- **Condition-Based Template**: Expand/contract based on criteria
- **Frequency Template**: Track character/element frequencies

### 🔧 Optimization Strategies

- **Minimize Window Size**: Find smallest valid window
- **Maximize Window Content**: Optimize sum, length, or count
- **Exact Condition Matching**: Meet precise requirements
- **Multi-Objective Optimization**: Balance multiple constraints

---

## ⚡ Quick Reference

### Time Complexities

- **Fixed Window**: O(n) where n is array length
- **Variable Window**: O(n) with efficient state management
- **Sliding Window Maximum**: O(n) with deque optimization
- **Multi-Condition Problems**: O(n × k) where k is constraint complexity

### Space Complexities

- **Basic Sliding Window**: O(1) to O(k) for window state
- **Hash Map Integration**: O(k) where k is unique elements
- **Deque Optimization**: O(k) for monotonic deque
- **Advanced Problems**: Varies by data structure requirements

### Essential Edge Cases

- **Empty Array/DSA.String**: Handle gracefully
- **Single Element**: Minimum valid input
- **Window Larger Than Array**: Impossible window sizes
- **All Elements Same**: Special optimization cases
- **No Valid Window**: Return appropriate default

---

## 🛠️ Core Templates

### Fixed Window Template

```python
def fixed_window_template(arr, k):
    if len(arr) < k:
        return []
    
    # Calculate first window
    window_sum = sum(arr[:k])
    max_sum = window_sum
    
    # Slide the window
    for i in range(k, len(arr)):
        window_sum = window_sum - arr[i-k] + arr[i]
        max_sum = max(max_sum, window_sum)
    
    return max_sum
```

### Variable Window Template

```python
def variable_window_template(arr, target):
    left = 0
    current_sum = 0
    min_length = float('inf')
    
    for right in range(len(arr)):
        # Expand window
        current_sum += arr[right]
        
        # Contract window while condition is met
        while current_sum >= target:
            min_length = min(min_length, right - left + 1)
            current_sum -= arr[left]
            left += 1
    
    return min_length if min_length != float('inf') else 0
```

### Hash Map Frequency Template

```python
def frequency_window_template(s, pattern):
    from collections import defaultdict
    
    pattern_freq = defaultdict(int)
    window_freq = defaultdict(int)
    
    # Build pattern frequency
    for char in pattern:
        pattern_freq[char] += 1
    
    left = 0
    min_len = float('inf')
    formed = 0
    required = len(pattern_freq)
    
    for right in range(len(s)):
        # Expand window
        char = s[right]
        window_freq[char] += 1
        
        if char in pattern_freq and window_freq[char] == pattern_freq[char]:
            formed += 1
        
        # Contract window
        while formed == required:
            # Update result
            min_len = min(min_len, right - left + 1)
            
            # Remove from left
            left_char = s[left]
            window_freq[left_char] -= 1
            if left_char in pattern_freq and window_freq[left_char] < pattern_freq[left_char]:
                formed -= 1
            left += 1
    
    return min_len
```

---

## 🎓 Advanced Concepts

### Two-Pointer Technique

The sliding window is essentially a specialized two-pointer technique:

1. **Left Pointer**: Start of current window
2. **Right Pointer**: End of current window
3. **Window State**: Maintain relevant information
4. **Condition Checking**: Expand/contract based on criteria

### Monotonic Deque for Sliding Maximum

```python
from collections import deque

def sliding_window_maximum(nums, k):
    dq = deque()  # stores indices
    result = []
    
    for i in range(len(nums)):
        # Remove indices outside current window
        while dq and dq[0] <= i - k:
            dq.popleft()
        
        # Remove smaller elements (maintain decreasing order)
        while dq and nums[dq[-1]] < nums[i]:
            dq.pop()
        
        dq.append(i)
        
        # Add to result when window is complete
        if i >= k - 1:
            result.append(nums[dq[0]])
    
    return result
```

### Frequency-Based Window Management

- **Character Frequency**: Track character counts in hash map
- **Distinct Elements**: Count unique elements in window
- **Pattern Matching**: Compare window frequency with target pattern
- **Exact Count**: Maintain precise element counts

---

## 📚 Problem Categories

### 🔍 Sum-Based Problems

**Pattern**: Maintain running sum, adjust window based on sum conditions

- Maximum Sum Subarray of Size K
- Minimum Sum Subarray of Size K
- Subarray Sum Equals K (with hash map)
- Maximum Average Subarray I

### 📏 Length-Based Problems

**Pattern**: Optimize window length based on content constraints

- Longest Substring Without Repeating Characters
- Longest Substring with At Most K Distinct Characters
- Longest Repeating Character Replacement
- Maximum Length of Repeated Subarray

### 🔢 Count-Based Problems

**Pattern**: Track element frequencies, adjust based on count conditions

- Subarrays with K Different Integers
- Number of Substrings Containing All Three Characters
- Count Number of Nice Subarrays
- Find All Anagrams in a DSA.String

### 🎯 Optimization Problems

**Pattern**: Find minimum/maximum window satisfying constraints

- Minimum Window Substring
- Smallest Subarray with Sum ≥ Target
- Minimum Size Subarray Sum
- Maximum Points You Can Obtain from Cards

---

## 🏆 Interview Success Tips

### Before the Interview

1. **Master Both Templates**: Fixed and variable window approaches
2. **Practice State Management**: Hash maps, frequency arrays
3. **Understand Trade-offs**: Time vs space complexity
4. **Review Edge Cases**: Empty inputs, impossible conditions

### During the Interview

1. **Identify the Pattern**: Recognize sliding window opportunity
2. **Choose Right Template**: Fixed vs variable window
3. **Define Window State**: What information to track
4. **Handle Edge Cases**: Discuss before implementing
5. **Optimize Step by Step**: Start simple, then optimize

### Common Pitfalls to Avoid

- **Incorrect window boundaries** (inclusive vs exclusive)
- **Inefficient state updates** (recomputing instead of maintaining)
- **Missing edge cases** (empty input, window larger than array)
- **Wrong expansion/contraction logic** for variable windows
- **Integer overflow** in sum calculations

---

## 🎯 Success Metrics

Track your progress with these milestones:

- [ ] **Week 1**: Master fixed window template and basic problems
- [ ] **Week 2**: Complete variable window problems with hash maps
- [ ] **Week 3**: Solve advanced multi-condition problems
- [ ] **Week 4**: Tackle hard problems with data structure integration
- [ ] **Interview Ready**: Solve must-do problems efficiently under time pressure

---

## 📊 Complexity Analysis

### Time Complexity Patterns

- **O(n)**: Standard sliding window with efficient state management
- **O(n × k)**: When window operations are O(k) complexity
- **O(n log k)**: With ordered data structures (TreeMap, etc.)
- **O(n × m)**: 2D sliding window problems

### Space Complexity Patterns

- **O(1)**: Fixed window with constant state
- **O(k)**: Variable window with element tracking
- **O(min(m,n))**: Hash map size bounded by alphabet or pattern
- **O(n)**: When additional data structures are required

---

## 🚀 Advanced Applications

### 2D Sliding Window

```python
def max_sum_2d_submatrix(matrix, k):
    """Maximum sum submatrix of size k×k"""
    rows, cols = len(matrix), len(matrix[0])
    max_sum = float('-inf')
    
    for i in range(rows - k + 1):
        for j in range(cols - k + 1):
            current_sum = 0
            for r in range(i, i + k):
                for c in range(j, j + k):
                    current_sum += matrix[r][c]
            max_sum = max(max_sum, current_sum)
    
    return max_sum
```

### Multi-Window Problems

- **K-Window Maximum**: Track multiple sliding windows
- **Overlapping Windows**: Handle window intersections
- **Window Composition**: Combine multiple window results

### Dynamic Window Size

- **Adaptive Windows**: Change size based on content
- **Multi-Size Windows**: Consider multiple window sizes
- **Optimal Size Finding**: Binary search + sliding window

---

*Master these patterns and sliding window will become your algorithmic superpower! 🪟✨*