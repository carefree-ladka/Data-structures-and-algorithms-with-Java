package DSA.Backtracking;

import java.util.Arrays;

public class CombinationSum4 {
    public static int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(nums, target, memo);
    }

    private static int dfs(int[] nums, int target, int[] memo) {
        if (target == 0)
            return 1;

        if (memo[target] != -1)
            return memo[target];

        int count = 0;

        for (int num : nums) {
            if (num <= target) {
                count += dfs(nums, target - num, memo);
            }
        }

        memo[target] = count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4)); // 7
        System.out.println(combinationSum4(new int[]{9}, 3)); // 0
    }
}
