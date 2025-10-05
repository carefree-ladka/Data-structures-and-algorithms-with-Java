package DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int index,
            List<Integer> path, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (index == candidates.length || target < 0)
            return;

        path.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, path, result);

        path.remove(path.size() - 1);
        backtrack(candidates, target, index + 1, path, result);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int target = 4;

        System.out.println(combinationSum(nums, target));
    }
}
