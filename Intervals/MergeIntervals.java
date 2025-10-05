package DSA.Intervals;

import java.util.*;

public class MergeIntervals {

    public static int[][] mergeUsingSorting(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= current[1]) {
                // Overlapping intervals, merge them
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                // No overlap, push current interval to result
                result.add(current);
                current = intervals[i];
            }
        }

        // Add the last interval
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }

    public static int[][] mergeUsingHeap(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));

        for (int[] interval : intervals) {
            pq.offer(interval);
        }

        List<int[]> merged = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (merged.isEmpty() || merged.getLast()[1] < current[0]) {
                // No overlap → add new interval
                merged.add(current);
            } else {
                merged.getLast()[1] = Math.max(
                        merged.getLast()[1], current[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static int[][] mergeLineSweep(int[][] intervals) {

        record Event(int pos, int type) {
        }

        List<Event> events = new ArrayList<>();
        for (int[] interval : intervals) {
            events.add(new Event(interval[0], 1));  // start event
            events.add(new Event(interval[1], -1)); // end event
        }

        // Sort events: first by position, then by type descending (start before end)
        events.sort((a, b) -> a.pos != b.pos ? a.pos - b.pos : b.type - a.type);

        List<int[]> result = new ArrayList<>();
        int count = 0;
        Integer start = null;

        for (Event event : events) {
            count += event.type;
            if (count == 1 && event.type == 1) {
                start = event.pos; // start new interval
            } else if (count == 0) {
                result.add(new int[]{start, event.pos}); // end current interval
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(mergeLineSweep(new int[][]{
                {1, 3},
                {4, 6},
                {8, 10},
                {15, 18},
                {20, 24},
        }))); // [[1, 3], [4, 6], [8, 10], [15, 18], [20, 24]]

        System.out.println(Arrays.deepToString(mergeLineSweep(new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18},
        }))); // [[1, 6], [8, 10], [15, 18]]
    }
}
