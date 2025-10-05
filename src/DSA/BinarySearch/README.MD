# 🔍 Binary Search Problems

Master the art of binary search with this comprehensive guide covering everything from fundamental implementations to
advanced optimization problems. Your complete roadmap to conquering binary search in technical interviews.

## 📋 Table of Contents

- [Core Binary Search](#core-binary-search)
- [Variants of Binary Search](#variants-of-binary-search)
- [Binary Search on Range (Binary Search the Answer)](#binary-search-on-range-binary-search-the-answer)
- [Binary Search + Advanced Structures](#binary-search--advanced-structures)
- [Advanced / Hard Problems](#advanced--hard-problems)
- [Must-Do Problems for Top Companies](#must-do-problems-for-top-companies)

---

## 🎯 Core Binary Search

Master the fundamental binary search techniques that form the backbone of this powerful algorithmic approach.

### Essential Implementations

- **Implement Binary Search** (Iterative & Recursive approaches)
- **Find First and Last Position of Element** (Boundary search techniques)
- **Search Insert Position** (Finding insertion points)

### Rotated Array Mastery

- **Search in Rotated Sorted Array I** (No duplicates)
- **Search in Rotated Sorted Array II** (With duplicates)
- **Find Minimum in Rotated Sorted Array** (Pivot point identification)

### Peak Detection

- **Find Peak Element** (Local maximum finding)
- **Binary Search on Answer** (General template for optimization)

---

## 🔧 Variants of Binary Search

Extend your binary search skills with these modified applications and specialized use cases.

### Boundary & Approximation Problems

- **Floor and Ceil in Sorted Array** (Lower/upper bound finding)
- **Next Greatest Letter** (Character-based binary search)
- **Square Root (x)** (Mathematical approximation)

### Interactive & Matrix Problems

- **Guess Number Higher or Lower** (Interactive binary search)
- **Search a 2D Matrix** (2D space reduction)

### Optimization Applications

- **Find Smallest Divisor Given a Threshold** (Binary search on divisors)
- **Find K Closest Elements** (Distance-based optimization)
- **Median of Two Sorted DSA.Arrays** (Partition-based approach)

---

## 📊 Binary Search on Range (Binary Search the Answer)

Advanced optimization problems where binary search finds the optimal answer within a continuous range.

### Resource Allocation Problems

- **Minimum Days to Make m Bouquets** (Time optimization)
- **Capacity to Ship Packages Within D Days** (Capacity optimization)
- **Split Array Largest Sum** (Minimizing maximum subarray sum)

### Rate & Speed Optimization

- **Koko Eating Bananas** (Rate optimization classic)
- **Minimum Speed to Arrive on Time** (Speed calculation)

### Classic Competition Problems

- **Aggressive Cows** (Distance maximization)
- **Painters Partition Problem** (Work distribution)

---

## 🏗️ Binary Search + Advanced Structures

Complex problems integrating binary search with sophisticated data structures and algorithms.

### Advanced Applications

- **Allocate Books Problem** (Memory/resource distribution)
- **Find the Duplicate Number** (Pigeonhole principle + binary search)
- **H-Index II** (Citation analysis optimization)

### Specialized Array Problems

- **Maximum Number of Removable Characters** (DSA.String modification)
- **Find in Mountain Array** (Specialized array interface)
- **Search in Bitonic Array** (Peak-valley structure)

### Data Structure Integration

- **Count of Smaller Numbers After Self** (Binary search + Fenwick/Segment Tree)

---

## 🚀 Advanced / Hard Problems

Challenging problems requiring deep understanding, creative thinking, and advanced optimization techniques.

- **Median of Two Sorted DSA.Arrays** (Hard - Partition optimization)
- **Find Kth Smallest Pair Distance** (Distance array optimization)
- **Find Kth Element in Two Sorted DSA.Arrays** (Generalized median)
- **Wood Cutting Problem** (Resource cutting optimization)
- **Minimize Max Distance to Gas Station** (Distance minimization)

---

## ✅ Must-Do Problems for Top Companies

**Critical problems for Amazon / Microsoft / Google interviews:**

| Problem                                  | Difficulty | Pattern              | Interview Frequency | Priority |
|------------------------------------------|------------|----------------------|---------------------|----------|
| **Search in Rotated Sorted Array**       | Medium     | Rotated Array        | Very High           | 🔥🔥🔥   |
| **Find Minimum in Rotated Sorted Array** | Medium     | Rotated Array        | Very High           | 🔥🔥🔥   |
| **Find Peak Element**                    | Medium     | Peak Finding         | High                | 🔥🔥🔥   |
| **Search a 2D Matrix**                   | Medium     | 2D Search            | High                | 🔥🔥🔥   |
| **Koko Eating Bananas**                  | Medium     | Binary Search Answer | High                | 🔥🔥     |
| **Median of Two Sorted DSA.Arrays**      | Hard       | Advanced Partition   | Medium              | 🔥🔥     |
| **Split Array Largest Sum**              | Hard       | Binary Search Answer | Medium              | 🔥🔥     |
| **Capacity to Ship Packages**            | Medium     | Binary Search Answer | Medium              | 🔥🔥     |

### 🎯 Company-Specific Focus

#### **Amazon Essentials**

1. Search in Rotated Sorted Array
2. Capacity to Ship Packages Within D Days
3. Find Peak Element
4. Koko Eating Bananas

#### **Microsoft Favorites**

1. Search a 2D Matrix
2. Find Minimum in Rotated Sorted Array
3. Binary Search Implementation
4. Find First and Last Position

#### **Google Preferences**

1. Median of Two Sorted DSA.Arrays
2. Split Array Largest Sum
3. Find Peak Element
4. Search Insert Position

---

## 💡 Mastery Strategy

### Phase 1: Foundation (Week 1)

1. **Template Mastery**: Perfect the basic binary search template
2. **Core Problems**: Implement iterative and recursive versions
3. **Edge Cases**: Handle empty arrays, single elements, duplicates

### Phase 2: Pattern Recognition (Week 2)

1. **Rotated DSA.Arrays**: Master all rotation-based problems
2. **Boundary Search**: Find first/last occurrences
3. **2D Extensions**: Apply binary search to matrices

### Phase 3: Advanced Applications (Week 3)

1. **Binary Search on Answer**: Optimization problems
2. **Range Problems**: Bouquets, shipping, eating bananas
3. **Mathematical Applications**: Square root, divisors

### Phase 4: Expert Level (Week 4+)

1. **Hard Problems**: Median of two arrays, pair distances
2. **Data Structure Integration**: Fenwick trees, segment trees
3. **Competition Problems**: Aggressive cows, painters partition

---

## 🎯 Key Patterns to Master

### 🔍 Search Space Patterns

- **Sorted Array Search**: Classic element finding
- **Rotated Array Search**: Pivot-based division
- **2D Matrix Search**: Row-column reduction
- **Answer Space Search**: Optimization problems

### 🎲 Template Variations

- **Standard Template**: `left <= right` with mid calculation
- **Left Boundary**: Finding leftmost occurrence
- **Right Boundary**: Finding rightmost occurrence
- **Peak Finding**: Local maximum identification

### 🔧 Optimization Patterns

- **Minimize Maximum**: Split array, ship packages
- **Maximize Minimum**: Aggressive cows placement
- **Rate Optimization**: Eating bananas, arrival time
- **Resource Allocation**: Books, painters, bouquets

---

## ⚡ Quick Reference

### Time Complexities

- **Standard Binary Search**: O(log n)
- **2D Matrix Search**: O(log m + log n) or O(log(m×n))
- **Binary Search on Answer**: O(n × log(answer_range))
- **Median of Two DSA.Arrays**: O(log(min(m,n)))

### Space Complexities

- **Iterative Approach**: O(1)
- **Recursive Approach**: O(log n) due to call stack
- **With Additional Data Structures**: Varies by problem

### Essential Edge Cases

- **Empty Array**: `arr.length == 0`
- **Single Element**: `arr.length == 1`
- **Two Elements**: Minimum for meaningful comparison
- **All Duplicates**: Special handling required
- **Target Not Found**: Return appropriate indicator

---

## 🛠️ Core Techniques

### Binary Search Template

```java
public static int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2; // avoids overflow

        if (nums[mid] == target) {
            return mid; // found
        } else if (nums[mid] < target) {
            left = mid + 1; // search right half
        } else {
            right = mid - 1; // search left half
        }
    }
    return -1; // not found
}
```

### Key Implementation Tips

1. **Prevent Overflow**: Use `left + (right - left) // 2`
2. **Loop Invariant**: Maintain search space correctly
3. **Boundary Conditions**: Handle `left <= right` vs `left < right`
4. **Return Values**: Consistent success/failure indicators

---

## 🎓 Advanced Concepts

### Binary Search on Answer

When the problem asks to minimize/maximize something and you can:

1. **Define a search space** for possible answers
2. **Create a checking function** to validate if an answer works
3. **Apply binary search** on the answer space

### Rotated Array Handling

```python
def search_rotated(arr, target):
    # Identify which half is sorted
    # Search in the appropriate half
    # Handle pivot point correctly
```

### 2D Matrix Optimization

- **Treat as 1D**: `matrix[mid // cols][mid % cols]`
- **Row-wise then Column-wise**: Two-step binary search
- **Staircase Search**: Start from top-right or bottom-left

---

## 📚 Practice Resources

### Online Platforms

- **LeetCode**: 150+ binary search problems with difficulty progression
- **HackerRank**: Structured learning path with explanations
- **GeeksforGeeks**: Comprehensive theory and implementations
- **InterviewBit**: Company-specific problem collections

### Study Materials

- **Cracking the Coding Interview**: Chapter on searching algorithms
- **Elements of Programming Interviews**: Advanced binary search problems
- **Algorithm Design Manual**: Theoretical foundations

### Practice Strategy

1. **Daily Consistency**: 3-5 problems per day
2. **Pattern Grouping**: Solve similar problems consecutively
3. **Time Constraints**: Practice under interview conditions
4. **Code Reviews**: Optimize for clarity and efficiency
5. **Mock Interviews**: Explain solutions clearly

---

## 🏆 Interview Success Tips

### Before the Interview

1. **Master the Template**: Know it by heart
2. **Practice Edge Cases**: Empty arrays, single elements
3. **Understand Trade-offs**: Time vs space complexity
4. **Review Company Favorites**: Focus on frequently asked problems

### During the Interview

1. **Clarify Requirements**: Understand the problem completely
2. **Start with Brute Force**: Then optimize with binary search
3. **Handle Edge Cases**: Discuss them before coding
4. **Test Your Solution**: Walk through examples
5. **Optimize if Needed**: Discuss potential improvements

### Common Pitfalls to Avoid

- **Off-by-one errors** in boundary calculations
- **Infinite loops** with incorrect boundary updates
- **Overflow issues** in mid calculation
- **Wrong comparison logic** for complex conditions

---

## 🎯 Success Metrics

Track your progress with these milestones:

- [ ] **Week 1**: Solve all core binary search problems
- [ ] **Week 2**: Master rotated array problems
- [ ] **Week 3**: Complete binary search on answer problems
- [ ] **Week 4**: Tackle advanced and hard problems
- [ ] **Interview Ready**: Solve must-do problems under time pressure

---

*Master these patterns and binary search will become your algorithmic superpower! 🔍✨*