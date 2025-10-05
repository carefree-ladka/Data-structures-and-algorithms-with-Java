package DSA.DynamicProgramming.DynamicProgramming2D;

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        // impossible cases
        if ((sum + target) % 2 != 0 || Math.abs(target) > sum) return 0;

        int subsetSum = (sum + target) / 2;

        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; // one way to reach 0 (choose nothing)

        for (int num : nums) {
            for (int s = subsetSum; s >= num; s--) {
                dp[s] += dp[s - num];
            }
        }
        return dp[subsetSum];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1}, 2));
    }
}
