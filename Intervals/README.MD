# ⏰ DSA.Intervals Problems - Complete Study Guide

A comprehensive roadmap for mastering interval-based algorithms and scheduling problems, organized by patterns and
real-world applications.

## 📚 Table of Contents

- [Core Foundations](#core-foundations)
- [Basic Interval Operations](#basic-interval-operations)
- [Scheduling & Resource Management](#scheduling--resource-management)
- [Advanced Interval Techniques](#advanced-interval-techniques)
- [Sweep Line Algorithms](#sweep-line-algorithms)
- [Real-World Applications](#real-world-applications)
- [FAANG Must-Master Problems](#faang-must-master-problems)

---

## 🏗️ Core Foundations

### Interval Fundamentals

- **Interval Representation** - [start, end] vs (start, end) conventions
- **Interval Relationships** - Overlap, containment, adjacency
- **Sorting Strategies** - By start time, end time, or duration
- **Data Structures** - DSA.Arrays, priority queues, trees for intervals

### Basic Interval Properties

```python
# Common interval operations
def overlaps(interval1, interval2):
    return interval1[0] < interval2[1] and interval2[0] < interval1[1]

def contains(outer, inner):
    return outer[0] <= inner[0] and inner[1] <= outer[1]

def merge_if_overlap(a, b):
    if overlaps(a, b):
        return [min(a[0], b[0]), max(a[1], b[1])]
    return None
```

### Problem Recognition Patterns

```
Interval problems typically involve:
✓ Time scheduling/booking systems
✓ Resource allocation optimization  
✓ Event processing and conflicts
✓ Range queries and updates
✓ Geometric overlap problems
✓ Calendar and meeting management
```

### Sorting Decision Framework

- **Sort by start time** - For merging, finding overlaps
- **Sort by end time** - For greedy scheduling, maximum activities
- **Sort by duration** - For shortest/longest interval problems
- **Custom comparators** - Multi-criteria optimization

---

## 🔧 Basic Interval Operations

### Merging DSA.Intervals

- **Merge DSA.Intervals** - Combine overlapping ranges
- **Insert Interval** - Add interval to sorted list
- **Interval List Intersections** - Find common time slots
- **Remove Covered DSA.Intervals** - Eliminate redundant intervals

### Overlap Detection

- **Non-overlapping DSA.Intervals** - Minimum removals needed
- **Maximum Overlapping DSA.Intervals** - Peak resource usage
- **Interval Conflicts** - Detect scheduling conflicts
- **Point Coverage** - Minimum intervals to cover points

### Implementation Patterns

```python
# Merge intervals template
def merge_intervals(intervals):
    if not intervals:
        return []
    
    # Sort by start time
    intervals.sort(key=lambda x: x[0])
    merged = [intervals[0]]
    
    for current in intervals[1:]:
        last = merged[-1]
        if current[0] <= last[1]:  # Overlap
            merged[-1] = [last[0], max(last[1], current[1])]
        else:
            merged.append(current)
    
    return merged

# Sweep line template for counting overlaps
def max_overlapping_intervals(intervals):
    events = []
    for start, end in intervals:
        events.append((start, 1))    # Start event
        events.append((end, -1))     # End event
    
    events.sort()
    current_count = max_count = 0
    
    for time, delta in events:
        current_count += delta
        max_count = max(max_count, current_count)
    
    return max_count
```

---

## 📅 Scheduling & Resource Management

### Meeting Room Problems

- **Meeting Rooms** - Can attend all meetings?
- **Meeting Rooms II** - Minimum rooms needed
- **Meeting Rooms III** - Advanced scheduling with priorities
- **Conference Room Booking** - Dynamic allocation

### Activity Selection

- **Maximum Non-overlapping DSA.Intervals** - Classic greedy problem
- **Weighted Activity Selection** - DP with interval values
- **Activity Selection with Groups** - Multiple resource types
- **Interval Scheduling Maximization** - Profit optimization

### Resource Allocation

- **Car Pooling** - Passenger capacity constraints
- **Task Scheduler** - CPU scheduling with constraints
- **Employee Free Time** - Find common availability
- **Minimum Platforms** - Railway scheduling

### Greedy Scheduling Strategies

```python
# Activity selection - sort by end time
def max_activities(intervals):
    if not intervals:
        return 0
    
    # Sort by end time for greedy selection
    intervals.sort(key=lambda x: x[1])
    count = 1
    last_end = intervals[0][1]
    
    for start, end in intervals[1:]:
        if start >= last_end:  # Non-overlapping
            count += 1
            last_end = end
    
    return count

# Meeting rooms - sort by start time, use min-heap for end times
import heapq
def min_meeting_rooms(intervals):
    if not intervals:
        return 0
    
    intervals.sort(key=lambda x: x[0])  # Sort by start time
    heap = []  # Min-heap of end times
    
    for start, end in intervals:
        if heap and heap[0] <= start:
            heapq.heappop(heap)  # Room becomes free
        heapq.heappush(heap, end)
    
    return len(heap)
```

---

## 🚀 Advanced Interval Techniques

### Interval Trees & Segment Trees

- **Range Sum Query** - Efficient range operations
- **Range Minimum/Maximum Query** - Segment tree applications
- **Lazy Propagation** - Batch updates on ranges
- **Persistent Segment Trees** - Historical range queries

### Dynamic Interval Problems

- **Calendar Booking** - Online interval insertion
- **My Calendar III** - Maximum concurrent bookings
- **Falling Squares** - 2D interval stacking
- **The Skyline Problem** - Building silhouette

### Interval DP Problems

- **Matrix Chain Multiplication** - Optimal parenthesization
- **Burst Balloons** - Optimal popping strategy
- **Palindrome Partitioning** - Minimum cuts
- **Stone Game** - Interval-based game theory

### Complex Scheduling

- **Course Schedule with Prerequisites** - Dependency intervals
- **Exam Room** - Maximize distance scheduling
- **Minimum Number of Arrows** - Balloon popping optimization
- **Video Stitching** - Concatenate time segments

### Advanced Data Structures

```python
# Interval tree node
class IntervalTreeNode:
    def __init__(self, interval):
        self.interval = interval
        self.max_end = interval[1]
        self.left = None
        self.right = None

# Coordinate compression for large intervals
def compress_coordinates(intervals):
    coords = set()
    for start, end in intervals:
        coords.add(start)
        coords.add(end)
    
    sorted_coords = sorted(coords)
    coord_map = {coord: i for i, coord in enumerate(sorted_coords)}
    
    compressed = []
    for start, end in intervals:
        compressed.append([coord_map[start], coord_map[end]])
    
    return compressed, sorted_coords
```

---

## 🧹 Sweep Line Algorithms

### Event-Based Processing

- **Meeting Rooms II** - Event-driven room allocation
- **Maximum Population** - Birth/death events
- **The Skyline Problem** - Building height changes
- **Rectangle Area** - Overlapping area calculation

### Line Sweep Templates

```python
# Generic sweep line for interval events
def sweep_line_intervals(intervals, query_points=None):
    events = []
    
    # Create events
    for i, (start, end) in enumerate(intervals):
        events.append((start, 'start', i))
        events.append((end, 'end', i))
    
    # Add query events if needed
    if query_points:
        for point in query_points:
            events.append((point, 'query', point))
    
    events.sort()
    
    active_intervals = set()
    results = []
    
    for time, event_type, data in events:
        if event_type == 'start':
            active_intervals.add(data)
        elif event_type == 'end':
            active_intervals.discard(data)
        elif event_type == 'query':
            results.append((data, len(active_intervals)))
    
    return results

# Skyline problem - critical points
def get_skyline(buildings):
    events = []
    for left, right, height in buildings:
        events.append((left, -height))   # Start (negative for max-heap)
        events.append((right, height))   # End
    
    events.sort()
    result = []
    heights = [0]  # Ground level
    
    i = 0
    while i < len(events):
        current_pos = events[i][0]
        
        # Process all events at same position
        while i < len(events) and events[i][0] == current_pos:
            height = events[i][1]
            if height < 0:  # Building starts
                heights.append(-height)
            else:  # Building ends
                heights.remove(height)
            i += 1
        
        # Check if max height changed
        max_height = max(heights)
        if not result or result[-1][1] != max_height:
            result.append([current_pos, max_height])
    
    return result
```

---

## 🌍 Real-World Applications

### Calendar & Booking Systems

- **Google Calendar** - Meeting conflict detection
- **Hotel Booking** - Room availability optimization
- **Flight Scheduling** - Gate assignment problems
- **Resource Reservation** - Conference room booking

### Financial Applications

- **Stock Trading** - Buy/sell interval optimization
- **Portfolio Rebalancing** - Time-based strategy intervals
- **Options Trading** - Expiration interval management
- **Market Hours** - Trading session overlaps

### System Design Integration

- **Load Balancing** - Request interval distribution
- **Caching Strategy** - TTL interval management
- **Database Partitioning** - Time-based sharding
- **Monitoring Windows** - Alert interval configuration

### Manufacturing & Logistics

- **Production Scheduling** - Machine time allocation
- **Delivery Routes** - Time window constraints
- **Maintenance Windows** - Downtime scheduling
- **Supply Chain** - Inventory interval planning

---

## 🎯 FAANG Must-Master Problems

### High-Priority (Master First)

| Problem                           | Companies                 | Pattern             | Difficulty |
|-----------------------------------|---------------------------|---------------------|------------|
| **Merge DSA.Intervals**           | Amazon, Google, Microsoft | Basic Merging       | Medium     |
| **Insert Interval**               | Google, Facebook          | Insertion + Merge   | Medium     |
| **Meeting Rooms**                 | Google, Amazon            | Basic Overlap       | Easy       |
| **Meeting Rooms II**              | Google, Amazon, Facebook  | Resource Allocation | Medium     |
| **Non-overlapping DSA.Intervals** | Amazon, Microsoft         | Greedy Selection    | Medium     |
| **Interval List Intersections**   | Google, Amazon            | Two-pointer Merge   | Medium     |

### Medium-Priority

| Problem                      | Companies         | Pattern              | Difficulty |
|------------------------------|-------------------|----------------------|------------|
| **Employee Free Time**       | Google, Facebook  | Multiple Schedules   | Hard       |
| **Car Pooling**              | Amazon, Google    | Capacity Constraints | Medium     |
| **My Calendar I**            | Google, Microsoft | Online Booking       | Medium     |
| **My Calendar II**           | Google            | Double Booking       | Medium     |
| **Minimum Number of Arrows** | Amazon, Google    | Greedy Optimization  | Medium     |
| **Video Stitching**          | Google            | Interval Coverage    | Medium     |

### Advanced (Senior+ Levels)

| Problem                                   | Companies                 | Pattern                 | Difficulty |
|-------------------------------------------|---------------------------|-------------------------|------------|
| **The Skyline Problem**                   | Google, Microsoft, Amazon | Sweep Line              | Hard       |
| **My Calendar III**                       | Google                    | K-booking Problem       | Hard       |
| **Falling Squares**                       | Google                    | 2D DSA.Intervals        | Hard       |
| **Range Module**                          | Google                    | Dynamic DSA.Intervals   | Hard       |
| **Rectangle Area**                        | Amazon, Google            | Geometric DSA.Intervals | Medium     |
| **Data Stream as Disjoint DSA.Intervals** | Google                    | Online Processing       | Hard       |

---

## 🧠 Pattern Recognition Guide

### Basic Overlap Problems

**Indicators:**

- Simple interval merging
- Conflict detection
- Basic scheduling

**Examples:** Merge DSA.Intervals, Meeting Rooms I

**Approach:** Sort by start time, iterate and merge

### Resource Allocation Problems

**Indicators:**

- Limited resources (rooms, capacity)
- Minimize resource usage
- Multi-constraint optimization

**Examples:** Meeting Rooms II, Car Pooling

**Approach:** Sort + heap/sweep line for tracking resources

### Greedy Selection Problems

**Indicators:**

- Maximum non-overlapping selections
- Activity selection variants
- Optimization with constraints

**Examples:** Non-overlapping DSA.Intervals, Minimum Arrows

**Approach:** Sort by end time, greedy selection

### Dynamic/Online Problems

**Indicators:**

- Real-time interval insertion
- Query-based operations
- Streaming interval data

**Examples:** My Calendar series, Range Module

**Approach:** Balanced trees, segment trees, or efficient search

### Sweep Line Problems

**Indicators:**

- Event-based processing
- Multiple simultaneous changes
- Complex geometric problems

**Examples:** Skyline Problem, Maximum Population

**Approach:** Event creation, sorting, state tracking

---

## 📖 Study Strategy

### Week 1: Foundations

1. **Master basic operations** - Overlap detection, merging
2. **Understand sorting strategies** - When to sort by start vs end
3. **Practice core problems** - Merge DSA.Intervals, Insert Interval
4. **Learn data structure choices** - DSA.Arrays vs heaps vs trees

### Week 2: Scheduling Problems

1. **Meeting room problems** - Basic to advanced variants
2. **Resource allocation** - Capacity constraints, optimization
3. **Greedy algorithms** - Activity selection, arrow problems
4. **Multi-constraint problems** - Car pooling, employee schedules

### Week 3: Advanced Techniques

1. **Sweep line algorithms** - Event processing, skyline
2. **Dynamic intervals** - Online booking, calendar systems
3. **Interval trees** - Range queries, segment trees
4. **Complex scheduling** - Dependencies, priorities

### Week 4: Interview Mastery

1. **Time all FAANG problems** - Build speed and confidence
2. **Practice pattern recognition** - Quick problem categorization
3. **Master edge cases** - Empty intervals, single points
4. **System design integration** - Real-world applications

---

## 🔗 Quick Reference

### Time Complexities

| Operation               | Typical Complexity | Space | Notes                         |
|-------------------------|--------------------|-------|-------------------------------|
| **Sort intervals**      | O(n log n)         | O(1)  | Usually the bottleneck        |
| **Merge intervals**     | O(n)               | O(n)  | After sorting                 |
| **Overlap detection**   | O(1)               | O(1)  | For two intervals             |
| **Meeting rooms II**    | O(n log n)         | O(n)  | DSA.BinaryHeap-based solution |
| **Sweep line**          | O(n log n)         | O(n)  | Event processing              |
| **Interval tree query** | O(log n)           | O(n)  | Balanced tree                 |

### Space Optimizations

- **In-place merging** - Modify input array when possible
- **Event compression** - Coordinate compression for large ranges
- **Lazy propagation** - Batch updates in segment trees
- **Memory pools** - Reuse interval objects in online systems

### Common Edge Cases

- **Empty interval list** - Handle gracefully
- **Single interval** - Base case optimization
- **Identical intervals** - Duplicate handling
- **Point intervals** - [x, x] vs [x, x+1]
- **Negative coordinates** - Time before epoch
- **Large coordinates** - Integer overflow prevention

---

## 💡 Pro Tips for Interviews

### Problem Analysis Framework

1. **Identify the core operation** - Merge, count, select, schedule
2. **Determine sorting strategy** - Start time, end time, duration
3. **Choose data structures** - Array, heap, tree, set
4. **Consider edge cases** - Empty, single, duplicate intervals

### Implementation Strategy

1. **Start with brute force** - O(n²) overlap checking
2. **Optimize with sorting** - Reduce to O(n log n)
3. **Add appropriate data structures** - Heaps for scheduling
4. **Handle edge cases** - Empty inputs, boundary conditions

### Communication Tips

1. **Explain sorting choice** - Why start time vs end time?
2. **Walk through examples** - Show interval operations visually
3. **Discuss trade-offs** - Time vs space complexity
4. **Mention real-world applications** - Calendar systems, scheduling

### Common Mistakes to Avoid

❌ **Wrong sorting criteria** - Not matching algorithm needs  
❌ **Off-by-one errors** - Inclusive vs exclusive endpoints  
❌ **Missing edge cases** - Empty lists, single intervals  
❌ **Inefficient data structures** - Linear search when heap needed  
❌ **Coordinate system confusion** - Mixing different conventions

---

## 🎯 Advanced Topics for Senior Roles

### System Design Considerations

- **Distributed scheduling** - Multiple server coordination
- **Cache-friendly intervals** - Memory locality optimization
- **Real-time processing** - Streaming interval updates
- **Fault tolerance** - Handling system failures in booking

### Performance Optimization

- **Lock-free algorithms** - Concurrent interval processing
- **Memory management** - Efficient interval storage
- **Batch processing** - Optimizing multiple operations
- **Approximation algorithms** - When exact solutions are too slow

### Domain-Specific Applications

- **Database query optimization** - Index range scans
- **Network packet scheduling** - QoS and bandwidth allocation
- **Game development** - Collision detection intervals
- **Scientific computing** - Time series data processing

---