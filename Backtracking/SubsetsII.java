package DSA.Backtracking;

import java.util.*;

public class SubsetsII {

    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums); // sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.removeLast();
        }
    }

    public static List<List<Integer>> subsetsBitmask(int[] nums) {
        Arrays.sort(nums); // sort to handle duplicates
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            set.add(subset); // duplicates automatically removed
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 2})); // [[], [1], [1,2], [1,2,2], [2], [2,2]]
    }
}
