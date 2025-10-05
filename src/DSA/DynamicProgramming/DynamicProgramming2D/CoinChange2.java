package DSA.DynamicProgramming.DynamicProgramming2D;

public class CoinChange2 {
    public static int changeBottomUp(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // one way to make 0 (choose nothing)

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static int changeTopDown(int amount, int[] coins) {
        Integer[][] memo = new Integer[coins.length][amount + 1];
        return dfs(0, amount, coins, memo);
    }

    private static int dfs(int i, int remain, int[] coins, Integer[][] memo) {
        // Base cases
        if (remain == 0) return 1;       // found valid combination
        if (i == coins.length) return 0; // no coins left

        if (memo[i][remain] != null) return memo[i][remain];

        int ways = 0;

        // Option 1: skip this coin
        ways += dfs(i + 1, remain, coins, memo);

        // Option 2: take this coin (if possible)
        if (remain >= coins[i]) {
            ways += dfs(i, remain - coins[i], coins, memo);
        }

        return memo[i][remain] = ways;
    }

    public static void main(String[] args) {
        int[] coins1 = {1, 2, 5};
        System.out.println(changeBottomUp(5, coins1)); // 4 -> [1+1+1+1+1, 1+1+1+2, 1+2+2, 5]

        int[] coins2 = {2};
        System.out.println(changeBottomUp(3, coins2)); // 0 (impossible)

        int[] coins3 = {10};
        System.out.println(changeBottomUp(10, coins3)); // 1 -> [10]
    }
}
