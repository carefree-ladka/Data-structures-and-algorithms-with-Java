package DSA.DynamicProgramming.DynamicProgramming1D;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;

        int max = amount + 1; // sentinel for "infinity"
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 1, 1, 1, 1, 1, 1}, 2));// 2
    }

    public int bfs(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        boolean[] visited = new boolean[amount + 1];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{amount, 0});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int remaining = curr[0];
            int coinsUsed = curr[1];

            if (remaining == 0)
                return coinsUsed;

            if (visited[remaining])
                continue;

            visited[remaining] = true;

            for (int coin : coins) {
                if (coin <= remaining) {
                    queue.offer(new int[]{remaining - coin, coinsUsed + 1});
                }
            }

        }
        return -1;
    }
}
