package DSA.Intervals;

import java.util.Arrays;

public class MeetingRooms {
    public static boolean canAttendMeetings(int[][] intervals) {
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Check for overlaps
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][][] testIntervals = {
                {{0, 30}, {5, 10}, {15, 20}}, // false
                {{7, 10}, {2, 4}},            // true
                {{1, 5}, {5, 10}},            // true
                {},                            // true
                {{1, 3}},                      // true
                {{1, 4}, {2, 3}}               // false
        };

        boolean[] expectedResults = {false, true, true, true, true, false};

        for (int i = 0; i < testIntervals.length; i++) {
            boolean result = canAttendMeetings(testIntervals[i]);
            System.out.println("Test " + (i + 1) + ": " + (result == expectedResults[i] ? "PASS" : "FAIL"));
        }

    }
}
