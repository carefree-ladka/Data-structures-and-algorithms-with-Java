package DSA.DynamicProgramming.DynamicProgramming1D;

public class MinCostClimbingStairs {
    // Top Down Memoization - O(n) 1ms
    int[] dp;

    // Bottom up computation - O(n) time, O(1) space
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n == 2) return Math.min(first, second);
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }

    // Bottom up tabulation - O(n) 1ms
    public static int minCostClimbingStairsBottomUp(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 2, 3, 4, 5}));
    }

    public int minCostClimbingStairsTopDown(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    private int minCost(int[] cost, int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return cost[n];
        if (dp[n] != 0) return dp[n];
        dp[n] = cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
        return dp[n];
    }
}
