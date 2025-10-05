package DSA.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); // sort to handle duplicates
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }

    private static void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] used) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // skip used elements
            if (used[i]) continue;

            // skip duplicates: if same as previous and previous is not used in this branch
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            current.add(nums[i]);
            used[i] = true;
            backtrack(nums, current, result, used);
            used[i] = false;
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2})); // [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    }
}
