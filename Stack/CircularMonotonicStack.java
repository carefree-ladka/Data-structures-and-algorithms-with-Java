package DSA.Stack;

import module java.base;

public class CircularMonotonicStack {

    // Next Greater Element - Circular
    public static int[] nextGreaterCircular(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num;
            }
            if (i < n) stack.push(i);
        }
        return result;
    }

    // Next Lesser Element - Circular
    public static int[] nextLesserCircular(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] > num) {
                result[stack.pop()] = num;
            }
            if (i < n) stack.push(i);
        }
        return result;
    }

    // Previous Greater Element - Circular
    public static int[] prevGreaterCircular(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] <= num) {
                stack.pop();
            }
            if (i < n && !stack.isEmpty()) {
                result[i] = nums[stack.peek()];
            }
            stack.push(i % n);
        }
        return result;
    }

    // Previous Lesser Element - Circular
    public static int[] prevLesserCircular(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] >= num) {
                stack.pop();
            }
            if (i < n && !stack.isEmpty()) {
                result[i] = nums[stack.peek()];
            }
            stack.push(i % n);
        }
        return result;
    }

    static void main(String[] args) {
        int[] nums = {2, 1, 2, 4, 3};

        System.out.println("Next Greater Circular: " + Arrays.toString(nextGreaterCircular(nums)));
        // [4, 2, 4, -1, 4]

        System.out.println("Next Lesser Circular:  " + Arrays.toString(nextLesserCircular(nums)));
        // [1, -1, 1, 3, 2]

        System.out.println("Prev Greater Circular: " + Arrays.toString(prevGreaterCircular(nums)));
        // [-1, 2, -1, -1, 4]

        System.out.println("Prev Lesser Circular:  " + Arrays.toString(prevLesserCircular(nums)));
        // [1, -1, 1, 2, 2]
    }
}

