package DSA.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int k, int target, List<Integer> path, List<List<Integer>> result) {

        if (target == 0 && path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (path.size() > k || target < 0)
            return;

        for (int i = start; i <= 9; i++) {
            path.add(i);
            backtrack(i + 1, k, target - i, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 7;

        System.out.println(combinationSum3(k, n)); // [[1, 2, 4]]
        System.out.println(combinationSum3(k, 9)); // [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
    }
}
