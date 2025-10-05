package DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Bitmask Approach:

So, for nums = [1, 2, 3], the subsets correspond to:

Binary	 Subset
000	     []
001	     [3]
010	     [2]
011	     [2, 3]
100	     [1]
101	     [1, 3]
110	     [1, 2]
111	     [1, 2, 3]
* */


public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current)); // add current subset

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);             // include nums[i]
            backtrack(nums, i + 1, current, result);
            current.removeLast(); // backtrack
        }
    }

    public static List<List<Integer>> subsetsBitmask(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        // Iterate through all possible masks from 0 to (2^n - 1)
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) { // if i-th bit is set
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));   // [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    }
}

